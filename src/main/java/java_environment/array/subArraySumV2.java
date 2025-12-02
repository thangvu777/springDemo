package java_environment.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Time: O(N^2)
// Space: O(N^2) in the worst case to store all results
public class subArraySumV2 {
    // NOTE: This version finds all contiguous subarrays and returns them as a List of Lists
    public static List<List<Integer>> subarraySumList(int[] nums, int k) {

        // Final list to store all valid subarrays
        List<List<Integer>> allSubarrays = new ArrayList<>();
        int n = nums.length;

        // Outer loop: Fix the starting index (i)
        for (int i = 0; i < n; i++) {
            int currentSum = 0;
            // Inner loop: Fix the ending index (j) and calculate the sum
            for (int j = i; j < n; j++) {

                // Add the current element to the sum for the subarray starting at i
                currentSum += nums[j];

                // Check if the current subarray sum matches K
                if (currentSum == k) {
                    // Create the subarray list and add it to the final result
                    List<Integer> validSubarray = new ArrayList<>();

                    // Build the subarray from start index (i) to end index (j)
                    for (int m = i; m <= j; m++) {
                        validSubarray.add(nums[m]);
                    }
                    allSubarrays.add(validSubarray);
                }
            }
        }
        return allSubarrays;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4, 5};
        int k1 = 7;
        List<List<Integer>> result1 = subarraySumList(nums1, k1);
        System.out.println("Subarrays for K=7: " + result1);
        // Expected: [[3, 4]]

        int[] nums2 = {1, 1, 1, 1, 1};
        int k2 = 2;
        List<List<Integer>> result2 = subarraySumList(nums2, k2);
        System.out.println("Subarrays for K=2: " + result2);
        // Expected: [[1, 1], [1, 1], [1, 1], [1, 1]]

        int[] nums3 = {3, 1, 2, 4};
        int k3 = 6;
        List<List<Integer>> result3 = subarraySumList(nums3, k3);
        System.out.println("Subarrays for K=6: " + result3);
        // Expected: [[3, 1, 2], [2, 4]]
    }
}
