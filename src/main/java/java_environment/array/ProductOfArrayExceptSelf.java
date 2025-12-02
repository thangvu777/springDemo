package java_environment.array;

import java.util.Arrays;

// Time : O(N)
// Space : O(1)
// https://leetcode.com/problems/product-of-array-except-self/
public class ProductOfArrayExceptSelf {

    static int[] productExceptSelf(int[] nums) {
        if(nums == null || nums.length == 0) return new int[0];

        int n = nums.length;
        int[] output = new int[n];

        int prefix = 1;
        for(int i = 0; i < n; i++){
            output[i] = prefix;
            prefix *= nums[i];
        }

        int suffix = 1;
        for(int i = n - 1; i >= 0; i--){
            output[i] *= suffix;
            suffix *= nums[i];
        }

        return output;
    }

    static void main(String[] args){
        int[] nums1 = {1, 2, 3, 4};
        int[] nums = new int[] {1,2,3,4,5};

        int[] result1 = productExceptSelf(nums1);
        // Expected: [24, 12, 8, 6]
        System.out.println("Result: " + Arrays.toString(result1));
        System.out.println("Result: " + Arrays.toString(productExceptSelf(nums)));
    }
}
