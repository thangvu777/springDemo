package java_environment.array;

import java.util.HashMap;
import java.util.Map;

// Time : O(N) loop through array once, all map operations are O(1)
// Space : O(N) map may contain all unique elements
public class subArraySum {
    public static int [] nums = new int[] {1,2,3,4,5,6,7,8,9,10};

    public static int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefixSumCounts = new HashMap<>();

        prefixSumCounts.put(0,1);

        int currentSum = 0;
        int count = 0;

        for(int num : nums) {
            currentSum += num;

            int requiredPreSum = currentSum - k;

            if (prefixSumCounts.containsKey(requiredPreSum)){
                count += prefixSumCounts.get(requiredPreSum);
            }

            prefixSumCounts.put(currentSum, prefixSumCounts.getOrDefault(currentSum, 0) + 1);
        }
        return count;
    }

    static void main() {
        IO.println("Total Number of Subarrays that equal K: ");
    }
}
