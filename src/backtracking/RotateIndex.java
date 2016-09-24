import java.util.*;

class RotateIndex {
    public static void main(String[] args) {
        RotateIndex ri = new RotateIndex();
            int[] nums = { 0, 1, 2, 3};
            List<List<Integer>> res = ri.permute(nums);
            //System.out.print(res);
            for (int k = nums.length -1 ; k >= 0; k--) {
                rotate()
                    max  = 
            }
            System.out.println(ri.rotate(nums));
    }
    
    private List<List<Integer>> rotate(int[] nums, k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> intList = new ArrayList<Integer>();
            for (int index = 0; index < nums.length; index++){
                intList.add(nums[index]);
            }    
            
            
        int k = nums.length - 1;
        
    }
    
    private int sum(int[] nums) {
        int[] indexArr = new int[nums.length];
        for (int i = 0; i < indexArr.length; i++) {
            indexArr[i] = i;
            sum += indexArr[i] * nums[i];
        }
        
    }
    
    public List<List<Integer>> permute(int[] nums) {
        // https://discuss.leetcode.com/topic/22890/java-solution-easy-to-understand-backtracking
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        backtrack(nums, 0, new ArrayList<Integer>(), result);
        return result;
    }
              
    public void backtrack(int[] nums, int pos, List<Integer> perm, List<List<Integer>> result) {
        // permutation completes
        if (pos == nums.length) {
            result.add(new ArrayList<Integer>(perm));
            return;
        }
        
         ArrayList<Integer> newPerm = new ArrayList<Integer>(perm);
        
        //Insert elements in the array by increasing index
        for (int i = 0; i <= pos; i++) {
            newPerm.add(i, nums[pos]);
            backtrack(nums, pos+1, newPerm, result);
            newPerm.remove(i);
       }
    }
}