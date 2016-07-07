package old;
/*41. First Missing Positive

Total Accepted: 56062 Total Submissions: 240250 Difficulty: Hard
Given an unsorted integer array, find the first missing positive integer.

For example,
Given [1,2,0] return 3,
and [3,4,-1,1] return 2.

Your algorithm should run in O(n) time and uses constant space.

Hide Tags Array
Hide Similar Problems (M) Missing Number (H) Find the Duplicate Number
*/
public class FirstMissingPositive {
    public static int firstMissingPositive(int[] nums) {
        /*
        The basic idea is for any k positive numbers (duplicates allowed), the first missing positive number must be within [1,k+1]. The reason is like you put k balls into k+1 bins, there must be a bin empty, the empty bin can be viewed as the missing number.
          Ref 1: https://leetcode.com/discuss/28531/o-1-space-java-solution
            The key here is to use swapping to keep constant space and also make use of the length of the array, which means there can be at most n positive integers. So each time we encounter an valid integer, find its correct position and swap. Otherwise we continue.*/
        // Ref2: https://leetcode.com/discuss/4220/a-very-nice-solution-from-ants-aasma-%40stackoverflow
        int[] A = nums;
        int i = 0 ;
        while (i < A.length) {
            if (A[i] == i+1 || A[i] <=0 || A[i] > A.length) i++;
            else if ( A[A[i] -1] != A[i]) swap(A, i, A[i] - 1);
            else i++;
        }

        i= 0;
        // 2. find first location where the index doesn't match the value
        while( i < A.length && A[i] == i+1 ) i++;
        return i+1;

    }

    private static void swap(int[] A, int i, int j) {
        if (i != j) {
            A[i] ^= A[j];
            A[j] ^= A[i];
            A[i] ^= A[j];
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {3, 4, -1, 1};
        int[] nums2 = {1, 2, 0};
        
        System.out.printf("missing number 1 : %d\n", firstMissingPositive(nums1));  // 2
        System.out.printf("missing number 2 : %d", firstMissingPositive(nums2));  // 3
    }
}