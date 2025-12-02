package java_environment.set;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

// https://leetcode.com/problems/longest-consecutive-sequence/
// Order does not matter
// Time : O(N)
// Space : O(N)
public class LongestConsecutiveSequence {

    static int[] nums = {1,2,3,4,5,6,7,5,5,5,4,3,2,2,2,2,1};

    static int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        int maxStreak = 0;
        for(int num: set){
            // skip until you found the lowest number to start with
            if(!set.contains(num - 1)){
                int currentNum = num;
                int currentStreak = 1;
                while(set.contains(currentNum+1)){
                    currentNum+=1;
                    currentStreak+=1;
                }
                maxStreak = Math.max(maxStreak, currentStreak);
            }
        }
        return maxStreak;
    }

    static void main(String[] args){
        IO.println(longestConsecutive(nums));
    }
}
