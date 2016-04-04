/*
3/29/16 LinkedIn Phone interview 
Kevin Lu

*/

// Given a sorted array that has been transposed (that is, a portion has been removed from one end and attached to the other), write a function to determine if a given number is present in the array.
// For example, here's a transposed array: 6 7 1 2 3 4 5. Note: numbers don't have to be sequential.
// Task #1: Find number "1". Should return true (or index "2").
// Task #2: Find number "4". Should return true (or index "5").

// 1. Find the tranposed pos. return index 2
// 2. do binary search to check the target

/* begin     mid     end
6     7 1  2  3 4  5

6 7 1 2 3 4 5
Search for 7

1 1 2 1 1 1 1 1 1 1 
*/
public class SearchInRoatedArrayLinkedIn {
    public static void main(String[] args){
        int[] array = {1, 1, 1, 2, 1, 1, 1, 1, 1, 1};
        //int[] array = {6, 7, 1,2, 3, 4, 6};
        //System.out.print(findTarget(array, 2));
        System.out.print(search(array, 2));
    }
    // this solution is able to solve {1, 1, 2, 1, 1, 1, 1, 1, 1, 1} 2  => 2
    // this solution is able to solve {1, 1, 1, 1, 2, 1, 1, 1, 1, 1} 2  => 4
    // but failed at  {1, 1, 1, 2, 1, 1, 1, 1, 1, 1}  => -1
    public static int search(int[] nums, int target) {
           // // 3. https://leetcode.com/discuss/11701/concise-o-log-n-binary-search-solution
           // Date : 2016.04.03 it is easy to present in the interview - Linkedin Phone interview.
               int n = nums.length;
               int lo=0, hi = n - 1;
           // find the index of the smallest value using binary search.
           // Loop will terminate since mid < hi, and lo or hi will shrink by at least 1.
           // Proof by contradiction that mid < hi: if mid==hi, then lo==hi and loop would have been terminated.
           while(lo < hi){
               int mid = (lo + hi) / 2;
               if(nums[mid] > nums[hi]) lo = mid + 1;
               else hi = mid;
           }
        
           // lo==hi is the index of the smallest value and also the number of places rotated.
           int rot = lo;
           lo = 0; hi = n - 1;
           // The usual binary search and accounting for rotation.
           while(lo <= hi){
               int mid = (lo + hi)/2;
               int realmid = (mid + rot) % n;
               if(nums[realmid] == target) {
                   return realmid;
               }
               if(nums[realmid] < target) {
                   lo = mid + 1;
               } else {
                   hi = mid - 1;
               }
           }
           return -1;    
       }
    
    
       // date : 2016.04.03 failed at duplicate items in the roated sorted array. ???
    public static boolean findTarget (int[] array, int target) {
        /* test case 
                 1.  [6,7,1,2,3,4,5]   4  =>5
                 2.   [3,1]  1   => 1
        
               */
               // Reference:
               // 1. https://leetcode.com/discuss/41134/java-ac-solution-using-once-binary-search
               /*
               The idea is that when rotating the array, there must be one half of the array that is still in sorted order. For example, 6 7 1 2 3 4 5, the order is disrupted from the point between 7 and 1. So when doing binary search, we can make a judgement that which part is ordered and whether the target is in that range, if yes, continue the search in that half, if not continue in the other half.
               */
               // 2.  https://leetcode.com/discuss/22678/revised-binary-search
        if (array == null || array.length == 0) return false;
        
       
        int n = array.length;
        int begin = 0;
        int end = n -1;
        
        while (begin <= end) {
           int mid = begin + (end - begin) /2;
            int midVal = array[mid];
            if (midVal == target) return true;
            
            if (array[begin] <= midVal) {   
                if ( target < midVal && target >= array[begin]){
                    end = mid - 1;
                } else { 
                     begin = mid + 1;
                }
            }
            if (  midVal <= array[end]) {
                if (target > midVal && target <= array[end]) {
                    begin = mid + 1;
                }
                 else {
                     end = mid -1;
                 }
            }
        }
        
        return false;
    }
}