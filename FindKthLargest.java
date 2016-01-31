/*
215. Kth Largest Element in an Array
Total Accepted: 39571 Total Submissions: 126261 Difficulty: Medium
Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.

For example,
Given [3,2,1,5,6,4] and k = 2, return 5.

Note: 
You may assume k is always valid, 1 ≤ k ≤ array's length.

Credits:
Special thanks to @mithmatt for adding this problem and creating all test cases.

Hide Company Tags Microsoft Bloomberg Facebook
Hide Tags Divide and Conquer Heap
Hide Similar Problems
*/

import java.util.*;

public class FindKthLargest {
    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        int k = 2;
        
        int res = findKthLargest(nums, k);
        System.out.printf("res = %d", res);
    }
    
    public static int findKthLargest_failed(int[] nums, int k) {
        Arrays.sort(nums);
        int len = nums.length;
        Set<Integer> set = new HashSet<>();
        
        while (set.size() == k) {
            set.add(nums[len--]);
        }
        
        int res = 0;
        Iterator it = set.iterator();
        while (it.hasNext() && k >0) {
            Object test= it.next();
            k--;
        }
        return 0;
    }
    
    public static int findKthLargest(int[] nums, int k) {
       return solution2(nums, k);
    }
    
    public static int solution1(int[] nums, int k) {
        // https://leetcode.com/discuss/36966/solution-explained
        /*  O(N lg N) running time + O(1) memory
The simplest approach is to sort the entire input array and then access the element by it's index (which is O(1)) operation:
        */
        final int N = nums.length;
         Arrays.sort(nums);
        
        return nums[N-k];
    }
    
    /*O(N lg K) running time + O(K) memory
Other possibility is to use a min oriented priority queue that will store the K-th largest values. The algorithm iterates over the whole input and maintains the size of priority queue.
*/
    public static int solution2(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        
        for (int i : nums) {
            pq.offer(i);
            
            if (pq.size() > k) {
               pq.poll();
            }
        }
        
     
        return pq.peek();
    }
}