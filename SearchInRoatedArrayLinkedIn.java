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
public class SearchInRoatedArray {
    public static void main(String[] args){
        int[] array = {1 1 2 1 1 1 1 1 1 1};
        System.out.printf(findTarget, )
    }
    
    public boolean findTarget (int[] array, int target) {
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
                 else {
                     end = mid -1;
                 }
            }
        }
        
        return false;
    }
}