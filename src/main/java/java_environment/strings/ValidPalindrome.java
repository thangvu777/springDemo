package java_environment.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ValidPalindrome {

    private static List<String> input = new ArrayList<>(Arrays.asList("Test", "ioi", "azazzaza", "pencil", ""));

    // Time: O(N)
    // Space: O(N)
    private static boolean validPalindrome(String str){
        if (str.length() == 0 || str.isEmpty() == true){
            return false;
        }
        StringBuilder sb = new StringBuilder(str);
        return sb.toString().equals(sb.reverse().toString());
    }

    // Time: O(N)
    // Space: O(N)
    private static boolean validPalindrome2Pointers(String str){
        if (str.length() == 0 || str.isEmpty() == true){
            return false;
        }
        int left=  0;
        int right =str.length()-1;

        while (left < right){
            if (str.charAt(left) != str.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }

    static void main (String[] args){
        IO.println("results 1 = ");
        for(String item: input){
            IO.println(String.format("%s is a palindrome: %s", item, validPalindrome(item)));
        }

        IO.println("results 2 = ");
        for(String item: input){
            IO.println(String.format("%s is a palindrome: %s", item, validPalindrome2Pointers(item)));
        }
    }
}