package java_environment.array;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MoveAllZeros {
    static int[] nums = {0, 0, 0 , 1, 2, 3};

    // Time : O(n)
    // Space : O(n)
    static int[] shiftZeros(int[] nums){
        List<Integer> resultList = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            if(nums[i]!=0){
                resultList.add(nums[i]);
            }
        }
        int numZeros = nums.length - resultList.size();
        for(int i = 0; i < numZeros; i++){
            resultList.add(0);
        }
        return resultList.stream().mapToInt(i->i).toArray();
    }

    // Time: O(n)
    // Space: O(1)
    static int[] shiftZeros2(int[] nums){
        int i = 0;
        for(int num: nums){
            if(num!=0){
                nums[i] = num;
                i++;
            }
        }
        while(i < nums.length){
            nums[i] = 0;
            i++;
        }
        return nums;
    }

    static void main() {
        IO.println("Result 1: " + Arrays.toString(shiftZeros(nums)));
        IO.println("Result 2: " + Arrays.toString(shiftZeros2(nums)));
    }
}

