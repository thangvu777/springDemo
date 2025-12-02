package deque;

import java.util.*;

// Time :
// Space : O(N)
// https://leetcode.com/problems/find-median-from-data-stream/
public class MedianFinder {
    private final PriorityQueue<Integer> maxHeap;
    private final PriorityQueue<Integer> minHeap;

    public MedianFinder () {
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        minHeap = new PriorityQueue<>();
    }

    // O(logN) heapify
    public void addNum(int num){
        if(maxHeap.isEmpty() || num <= maxHeap.peek()) maxHeap.offer(num);
        else minHeap.offer(num);

        if(minHeap.size() > maxHeap.size()) maxHeap.offer(minHeap.poll());
        else if (maxHeap.size() > minHeap.size() + 1) minHeap.offer(maxHeap.poll());
    }

    // O(1) with peek
    public double findMedian() {
        if(maxHeap.size() > minHeap.size()){
            return maxHeap.peek();
        } else {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        }
    }

    public void clearHeaps() {
        maxHeap.clear();
        minHeap.clear();
    }

    static void main (String[] args){
        MedianFinder mf = new MedianFinder();
        int[] nums = new int[]{ 1,2,3,4,5,6,7,8,9,10,11,12 };
        Arrays.stream(nums).forEach(mf::addNum);
        IO.println(mf.findMedian());
        mf.clearHeaps();

        int[] nums2 = new int[]{ 92,12,3892127,123,11 };
        Arrays.stream(nums2).forEach(mf::addNum);
        IO.println(mf.findMedian());
        mf.clearHeaps();
    }
}
