package java_environment.array;

import java.util.Arrays;

// https://leetcode.com/problems/rotate-array/
// Time : O(N) Runs the reverse 3 times, O(N) + O(K) + O(N-K) = O(2N) = O(N)
// Space : O(1) Does everything in place
public class RotateArray {

    private static final int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    static void main(String[] args) {
        // Declare K here
        // K = rotation distance
        int k = 3;
        int n = nums.length;
        k = k % n; // Normalizing K for out of bounds scenarios

        System.out.println("Before:");
        IO.println(Arrays.toString(nums));

        // #1 Reverse whole array
        // This helps displace the elements at the end to the front, but now they are in reverse order
        reverse(nums, 0, n - 1);
        IO.println(String.format("After reversing whole array"));
        IO.println(Arrays.toString(nums));// Reverse Whole Array

        // #2 Reverse first portion to k-1
        // Now rotate the displaced elements at the front portion of k once more to get them back to correct order
        reverse(nums, 0, k - 1);
        IO.println(String.format("After reversing 0 to %d - 1", k));
        IO.println(Arrays.toString(nums));

        // #3 Reverse second portion of k to end of the array
        // Now rotate the displace elements at the back portion of k once more to get them back to correct order
        reverse(nums, k, n-1);
        IO.println(String.format("After reversing %d to n - 1", k));
        IO.println(Arrays.toString(nums));
    }

    // Reverse an Array
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