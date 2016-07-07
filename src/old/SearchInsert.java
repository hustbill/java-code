package old;
/*
35. Search Insert Position
Total Accepted: 89356 Total Submissions: 244519 Difficulty: Medium
Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Here are few examples.
[1,3,5,6], 5 → 2
[1,3,5,6], 2 → 1
[1,3,5,6], 7 → 4
[1,3,5,6], 0 → 0
*/

public class SearchInsert {
    public static int searchInsert(int[] nums, int target) {
         if (nums[nums.length-1] < target) return nums.length;
        
         return binarySearch(nums, 0, nums.length-1, target);
     }
    
     public static int binarySearch(int[] nums, int start, int end, int target) {
       
         while (start < end) {
             int mid = start + (end - start) / 2;
             if (nums[mid] == target) return mid;
             else if (nums[mid] < target) start++;
             else end--;
         }
         return start;
     }
     
    public static void main(String[] args) {
        // int[] nums = { 1, 3, 5, 6};
 //        int target = 5;
 
 
 
         int[] nums = { 1, 3, 5, 6}; 
         int target = 7;  // 
        
        int pos = searchInsert(nums, target);
        System.out.printf("pos = %d", pos);
        
    }
    
    private static void printListNode( ListNode head) {
        while (head != null) {
            System.out.print ( head.val + " -> " );
            head = head.next;
        }
    }
}