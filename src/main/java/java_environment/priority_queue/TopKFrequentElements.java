package java_environment.priority_queue;

// Top K Frequent Elements
// https://leetcode.com/problems/top-k-frequent-elements/

// Time :
// Space :

import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

// Top K Frequent Elements
// https://leetcode.com/problems/top-k-frequent-elements/

// Time : O(N log K) : O(N * log(k)) where log K is the max time it takes to rebalance the tree
// Space : O(N) : O(N + k + k)

public class TopKFrequentElements {

    private static int[] nums = new int[] {1,2,3,4,5,6,7,8,7,7,6,6,9,9,9,9};

    private static int[] topKFrequent(int[] nums, int k){
        // key: number, value: frequency count
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num: nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        // Min Heap with comparator in order
        // Where a occurs less than b
        // PQ is made with having the least frequent element as the root
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> map.get(a) - map.get(b));

        for(int num : map.keySet()){
            // add num from key set
            pq.add(num);
            // If we have more than k elements, remove the root
            if(pq.size() > k){
                pq.poll();
            }
        }

        // Convert min heap to array to get the Kth most frequent element
        int[] result = new int[k];
        for(int i = 0; i < k; i++){
            result[i] = pq.poll();
        }
        return result;
    }

    static void main() {
        IO.println("K = 1: " + Arrays.toString(topKFrequent(nums, 1)));
        IO.println("K = 2: " + Arrays.toString(topKFrequent(nums, 2)));
        IO.println("K = 3: " + Arrays.toString(topKFrequent(nums, 3)));
    }
}
