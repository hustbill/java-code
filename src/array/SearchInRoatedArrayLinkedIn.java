package array;
/*
3/29/16 LinkedIn Phone interview 
Kevin Lu
9/5
刷题不熟练


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
	public static void main(String[] args) {
		// int[] array = {1, 2, 1, 1, 1};
		 int[] arrayWithDuplicates = {1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1};
		int[] array = { 6, 7, 1, 2, 3, 4, 6 };
	
		System.out.println(search(array, 2)); // 3
		System.out.println(searchInRotatedArrayWithDuplicates(array, 2));  // true
		System.out.println(findInRotatedArrayWithDuplicates(array, 2)); //3
	}

	// this solution is able to solve {1, 1, 2, 1, 1, 1, 1, 1, 1, 1} 2 => 2
	// this solution is able to solve {1, 1, 1, 1, 2, 1, 1, 1, 1, 1} 2 => 4
	// but failed at {1, 1, 1, 2, 1, 1, 1, 1, 1, 1} 2 => -1
	public static int searchSol2(int[] nums, int target) {
		// https://leetcode.com/discuss/11701/concise-o-log-n-binary-search-solution
		// Date : 2016.04.03 it is easy to present in the interview - Linkedin
		// Phone interview.

		// find the index of the smallest value using binary search.
		// Loop will terminate since mid < hi, and lo or hi will shrink by at
		// least 1.
		// Proof by contradiction that mid < hi: if mid==hi, then lo==hi and
		// loop would have been terminated.
		int start = 0, end = nums.length - 1;

		while (start < end) {
			int mid = start + (end - start) / 2;
			if (nums[end] < nums[mid]) {
				start = mid + 1; // 转折点在mid 的右侧
			} else {
				end = mid;
			}
		}
		// start == end is the smallest value and also the number of places
		// roated.
		int rot = start; // 可以理解为偏移量
		start = 0;
		end = nums.length - 1;

		while (start <= end) {
			int mid = start + (end - start) / 2;
			int readmid = (mid + rot) % (nums.length); // [4] 5 6 7 0 1 2 [4]
														// 就是原先的 真正mid
			if (nums[readmid] == target)
				return readmid;
			if (nums[readmid] < target) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return -1;

	}

	// date : 2016.04.03 failed at duplicate items in the roated sorted array.
	// date : 2016.06.26 33. Search in Rotated Sorted Array 本来就不包含 duplicate
	// items.
	// date : 2016.09.05  leetcode 81. search in roated sorted array II 包含duplicates
	// test case 1. [6,7,1,2,3,4,5] 4 =>5 2. [3,1] 1 => 1
	public static int search(int[] nums, int target) {
		/*
		 * 先用中点分成两个 parts，判断target 是否在这两段中（还有判断是否是sorted part）。
		 * https://leetcode.com/discuss/41134/java-ac-solution-using-once-binary
		 * -search
		 * 
		 * The idea is that when rotating the array, there must be one half of
		 * the array that is still in sorted order. e.g., 4 5 6 7 0 1 2, the
		 * order is disrupted from the point between 7 and 0. So when doing
		 * binary search, we can make a judgement that which part is ordered and
		 * whether the target is in that range, if yes, continue the search in
		 * that half, if not continue in the other half. 判断target 是在 4567
		 * 这一段，还是在012 这一段。分别进行binary search。 这个方法，要注意边界条件，结束条件。
		 * 
		 */
		int start = 0;
		int end = nums.length - 1;

		while (start <= end) {
			int mid = start + (end - start) / 2;
			int midVal = nums[mid];
			if (midVal == target) {
				return mid;
			}

			if (nums[start] <= midVal) {
				if (target >= nums[start] && target < midVal) {
					end = mid - 1;
				} else {
					start = mid + 1;
				}
			}

			if (midVal <= nums[end]) {
				if (target > midVal && target <= nums[end]) {
					start = mid + 1;
				} else {
					end = mid - 1;
				}
			}
		}
		return -1;
	}

	/*  81. Search in Rotated Sorted Array II
	 * Follow up for "Search in Rotated Sorted Array": What if duplicates are
	 * allowed?
	 * 
	 * Would this affect the run-time complexity? How and why?
	 */
	public static boolean searchInRotatedArrayWithDuplicates(int[] nums, int target) {
		int start = 0, end = nums.length - 1;

		// check each num so we will check start == end
		// We always get a sorted part and a half part
		// we can check sorted part to decide where to go next
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (nums[mid] == target)
				return true;

			// if left part is sorted
			if (nums[start] < nums[mid]) {
				if (target < nums[start] || target > nums[mid]) {
					// target is in rotated part
					start = mid + 1;
				} else {
					end = mid - 1;
				}
			} else if (nums[start] > nums[mid]) {
				// right part is rotated

				// target is in rotated part
				if (target < nums[mid] || target > nums[end]) {
					end = mid - 1;
				} else {
					start = mid + 1;
				}
			} else {
				// duplicates, we know nums[mid] != target, so nums[start] !=
				// target
				// based on current information, we can only move left pointer
				// to skip one cell
				// thus in the worest case, we would have target: 2, and array
				// like 11111111, then
				// the running time would be O(n)
				start++;
			}
		}
		return false;
	}
	
	// find the index of the target in the rotated array with duplicates
	public static int findInRoatedArrayWithDuplicates(int[] nums, int target) {
		int start = 0, end = nums.length - 1;

		// check each num so we will check start == end
		// We always get a sorted part and a half part
		// we can check sorted part to decide where to go next
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (nums[mid] == target)
				return mid;

			// if left part is sorted
			if (nums[start] < nums[mid]) {
				if (target < nums[start] || target > nums[mid]) {
					// target is in rotated part
					start = mid + 1;
				} else {
					end = mid - 1;
				}
			} else if (nums[start] > nums[mid]) {
				// right part is rotated

				// target is in rotated part
				if (target < nums[mid] || target > nums[end]) {
					end = mid - 1;
				} else {
					start = mid + 1;
				}
			} else {
				// duplicates, we know nums[mid] != target, so nums[start] !=
				// target
				// based on current information, we can only move left pointer
				// to skip one cell
				// thus in the worest case, we would have target: 2, and array
				// like 11111111, then
				// the running time would be O(n)
				start++;
			}
		}
		return start;
	}

}