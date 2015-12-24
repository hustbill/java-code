import java.util.*;

public class FourSum {
   
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        // Clean accepted java O(n^3) solution based on 3sum
        // https://leetcode.com/discuss/32594/clean-accepted-java-o-n-3-solution-based-on-3sum
        /*
          int[] nums = { 1, 1, 3, 11, 7, 2, 2, 6};  => 
                                                         1  2  3  7 
                                                         2  2  3  6   
        */
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        
        if (nums == null || nums.length < 4) return res;
        
        Arrays.sort(nums);
        
        for (int i=0; i<nums.length-3; i++) {
            if ( i>0 && nums[i] == nums[i-1]) continue;
            
            for (int j=i+1; j < nums.length -2; j++) {
                if (j>i+1 && nums[j] == nums[j-1]) continue;
                int low = j+1, high = nums.length-1;
                while (low < high) {
                    int sum = nums[i] + nums[j] + nums[low] + nums[high];
                    if (sum == target) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[low], nums[high]));
                        while(low < high && nums[low] == nums[low+1]) low++;
                        while(low < high && nums[high] == nums[high-1]) high--;
                        low++;
                        high--;
                    }
                    else if (sum < target) low++;
                    else high--;
                }
            }
        }
        return res;
        
    }
    
    public static void main(String[] args) {
       int[] nums = { 1, 1, 3, 11, 7, 2, 2, 6};
       List<List<Integer>> ans = fourSum(nums, 13);
      //List<List<Integer>> ans = fourSum(null, 13);
        for( List<Integer> list : ans) {
            for (int i: list) {
                System.out.printf (" %d ", i);
            }
            System.out.println();
        }
    }
}