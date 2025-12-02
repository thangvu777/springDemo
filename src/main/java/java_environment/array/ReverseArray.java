package java_environment.array;

import java.util.Arrays;

// https://leetcode.com/problems/rotate-array/
// Time : O(n) Loops through array one time
// Space : O(1) Does everything in place
public class ReverseArray {

    private static final int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    // Reverse an Array
    static void main(String[] args) {
        int n = nums.length;
        System.out.println("Before:");
        IO.println(Arrays.toString(nums));

        // #1 Reverse whole array
        // This helps displace the elements at the end to the front, but now they are in reverse order
        reverse(nums, 0, n - 1);
        IO.println(String.format("After reversing whole array"));
        IO.println(Arrays.toString(nums));// Reverse Whole Array
    }
    private static void reverse(int[] nums, int left, int right) {
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }

    private static void swap(int[] nums, int left, int right) {
        int temp = nums[right];
        nums[right] = nums[left];
        nums[left] = temp;
    }
}