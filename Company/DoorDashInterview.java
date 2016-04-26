import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

// [1, 2, 3, 5, 7, 9, 10, 11, 12] ==> 4
// [1, 2, 3] ==> 3
// [1, 2, 5, 7] ==> 2
// [] ==> 0
public class DoorDashInterview {
  
  // for arr1:  1->2->3->5    4
  
  private static int getLongestSequenceLength(int[] arr) {
    int result = 0;

    if (arr == null || arr.length == 0) return 0;
    
    int n = arr.length, len = 0;
    
    int[] increasingSeq = new int[n];

    
    increasingSeq[len++]  = arr[0];
    
    for (int i = 1; i < n; i++) {
      if (arr[i] > increasingSeq[len - 1]) {
        
        // System.out.println(arr[i]);
        increasingSeq[len++] = arr[i];
      } else {
        int pos = findMissingPosition(increasingSeq, 0, len - 1, arr[i]);
        increasingSeq[pos] = arr[i];
      }
    }
    
    result = getLengthDiffOne(increasingSeq);
    
    return result;
  }
  
  
  public static int getLengthDiffOne(int[] seq) {
    int result = seq.length;
    
    int start = 0, end = 1;
    
    while (end < seq.length && seq[end] - seq[start] == 1) {
      start++;
      end++;
    }
    return end ;
    
  }
  
  public static int findMissingPosition(int[] seq, int low, int high, int x) {
    // {1, 100}
    //  find the one should be missing in arry  such as, 6 in the arr1
    // [1, 2, 3, 5]
    int mid ;
    while (low <= high) {
      mid = low + (high - low) / 2;
      if (seq[mid] == x) {
        return mid;
      } else if (seq[mid] > x) {
        high = mid -1;
      } else {
        low = mid + 1;
      }
    }
    return low;
  }
  
  public static void main(String[] args) {
    //int[] arr1 = {1, 2, 3, 5, 7, 9, 10, 11, 12};
    int[] arr1 = { 1, 2, 3, 5};
    int[] arr2 = {1, 2, 3};
    int[] arr3 = {1, 2, 5, 7};
    // int[] arr4 = {};
    
    System.out.println(getLongestSequenceLength(arr1)); // should return 4
    System.out.println(getLongestSequenceLength(arr2)); // should return
    System.out.println(getLongestSequenceLength(arr3)); // should return
     //System.out.println(getLongestSequenceLength(arr4)); // should return 0
  }
}