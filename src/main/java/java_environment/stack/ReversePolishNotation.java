package java_environment.stack;

import java.util.Stack;

// https://leetcode.com/problems/evaluate-reverse-polish-notation/description/
// Time : O(N) -> looping through N tokens
// Space : O(N) [1,2,3,4,5,6,+] -> N/2
public class ReversePolishNotation {
    static String[] tokens = {"2", "1", "+", "3", "*"};

    private static int evalRPN(String[] tokens){
        Stack<Integer> stack = new Stack<>();

        for(String token: tokens){
            if(isOperator(token)){
                int num2 = stack.pop();
                int num1 = stack.pop();

                int result = 0;
                switch (token){
                    case "+" -> result = num1 + num2;
                    case "-" -> result = num1 - num2;
                    case "*" -> result = num1 * num2;
                    case "/" -> result = num1 / num2;
                }
                stack.push(result); // Return result of current operation
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop(); // Return final result at end of array
    }

    private static boolean isOperator(String token){
        return token.equals("+") ||
                token.equals("-") ||
                token.equals("*") ||
                token.equals("/");
    }

    static void main(String[] args){
        IO.println(evalRPN(tokens));
    }
}
