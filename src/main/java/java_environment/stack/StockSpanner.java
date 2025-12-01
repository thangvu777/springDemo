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
            while(!pgp.isEmpty() || prices.get(pgp.peek()) <= price) {
                pgp.pop();
            }
            int span;
            if(pgp.isEmpty()) span = index + 1;
            else span = index - pgp.peek();

            pgp.push(index);
            return span;
        }

        static void main() {
            IO.println("HelloWorld!");
        }
}
