package java_environment.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Time : O(NlogN)
// Space : O(N)
public class MergeIntervals {

    int[][] intervals = {
            {1, 3},
            {2, 6},
            {8, 10},
            {15, 18}
    };

    static public int[][] mergeIntervals (int[][] intervals) {
        // Sort intervals by starting time
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
        List<int[]> merged = new ArrayList<>();

        for(int[] interval: intervals){
            // First merge item or No overlap
            if(merged.isEmpty() || merged.getLast()[1] < interval[0]){
                merged.add(interval);
            } else { // There is an overlap, overwrite previous interval with the current interval end
                int[] lastMerged = merged.getLast();
                lastMerged[1] = Math.max(lastMerged[1], interval[1]);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }

    static void main() {
        int[][] intervals1 = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] result1 = mergeIntervals(intervals1);
        System.out.println(Arrays.deepToString(result1));
    }
}
