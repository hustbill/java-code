package old;
public class NextPermutation{
	public static void main(String[] args) {
		int[] nums = {2, 4, 3, 8, 7, 5,1};
		
		nextPermutation(nums);
		System.out.println();
		for ( int i : nums ) 
			System.out.printf(" %d ", i);
	}
// https://leetcode.com/discuss/8472/share-my-o-n-time-solution
// spend two hours
	public static void nextPermutation(int[] nums) {
	    int n = nums.length;
		if (n < 2)  return ;
	
		int i = n - 1;
		//Start from its last element, traverse backward to find the first one with index i that satisfy num[i-1] < num[i].
		while(i > 0)  {
			if ( nums[i-1] < nums[i] ) { 
				break;  // for 2, 4, 3,8,7,5,1 . i=3 nums[i]=8   i-1=2, nums[i-1]=3 
			}
			i--;
		}
		
		// find the one from end which lager than the index
		if (i != 0)  {  // not {5, 4, 3, 2, 1}
			int val = nums[i-1];
			int j= n-1;
			while (j >= i) {
				if( nums[j] > val)
					break;
				j--;
			}  
			// swap it with the smallest number between num[i,n-1] that is larger than num[i-1]. 
			swap(nums, j, i-1);   // index- 1    
		}
		
		// reverse the  ascending remains part
		reverse(nums, i, n-1);
	}
	
	private static void swap(int[] nums, int i, int j) {
			int temp = 0;
			temp = nums[i];
			nums[i] =nums[j];
			nums[j] = temp;
		
	}
	
	// reversely sort the num[i,n-1]
	private static void reverse(int[] nums, int begin, int end) {
	   while ( begin < end) {
		    swap(nums, begin, end);
			begin++;
			end--;
	   }
	}
}