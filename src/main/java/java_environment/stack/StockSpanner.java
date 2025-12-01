package java_environment.stack;

import java.util.List;
import java.util.Stack;

// Time : O(N) looping through array of prices. But all stack operations are amarotized of O(1)
// Space : O(N) list of prices
public class StockSpanner {
        private final Stack<Integer> pgp;  // previous greater price candidate indexes
        private final List<Integer> prices;
        private int index; // current day (0 index)

        public StockSpanner(){
            pgp = new Stack<>();
            prices = new Stack<>();
            index = -1;
        }

        // The span of the stock's price in one day is the maximum number of consecutive days (starting from that day and going backward) for which the stock price was less than or equal to the price of that day.
        private int next(Integer price){
            index++;
            prices.add(price);
            while(!pgp.isEmpty() && prices.get(pgp.peek()) <= price) {
                pgp.pop();
            }
            int span;
            if(pgp.isEmpty()) span = index + 1;
            else span = index - pgp.peek();

            pgp.push(index);
            return span;
        }

        static void main() {
            StockSpanner ss = new StockSpanner();

            // Input: [100, 80, 60, 70, 60, 75, 85]
            System.out.println(ss.next(100)); // Price 100: Span is 1
            System.out.println(ss.next(80));  // Price 80: Span is 1 (80 > 100 is false)
            System.out.println(ss.next(60));  // Price 60: Span is 1 (60 > 80 is false)
            System.out.println(ss.next(70));  // Price 70: Span is 2 (70 > 60 and 70 <= 80)
            System.out.println(ss.next(60));  // Price 60: Span is 1 (60 <= 70)
            System.out.println(ss.next(75));  // Price 75: Span is 4 (75 > 60, 75 > 70, 75 > 60, 75 <= 80)
            System.out.println(ss.next(85));  // Price 85: Span is 6 (85 > 75, 85 > 60, etc.)
            System.out.println(ss.next(40));  // Price 85: Span is 6 (85 > 75, 85 > 60, etc.)
            System.out.println(ss.next(110));  // Price 85: Span is 6 (85 > 75, 85 > 60, etc.)
            System.out.println(ss.next(37));  // Price 85: Span is 6 (85 > 75, 85 > 60, etc.)
            System.out.println(ss.next(38));  // Price 85: Span is 6 (85 > 75, 85 > 60, etc.)
            System.out.println(ss.next(40));  // Price 85: Span is 6 (85 > 75, 85 > 60, etc.)
            System.out.println(ss.next(45));  // Price 85: Span is 6 (85 > 75, 85 > 60, etc.)
        }
}
