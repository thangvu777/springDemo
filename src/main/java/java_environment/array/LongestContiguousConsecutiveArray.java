package java_environment.array;

// O(N) loop through once
// O(1) Constant space
public class LongestContiguousConsecutiveArray {
    static int[] nums = {1,2,3,2,5,6,7,5,5,5,4,3,2,2,2,2,1};

    static int longestContinguousConsecutive(int[] nums){
        if(nums == null) return 0;
        if(nums.length < 2) return 1;
        int currentStreak = 1;
        int maxStreak = 0;
        for(int i = 0; i < nums.length - 1; i++){
            if(nums[i+1] == nums[i] + 1){
                currentStreak += 1;
            } else {
                maxStreak = Math.max(maxStreak, currentStreak);
                currentStreak = 0;
            }
        }
        return maxStreak;
    }

    static void main(String[] args){
        IO.println(longestContinguousConsecutive(nums));
    }
}
