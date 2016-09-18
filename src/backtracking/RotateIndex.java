import java.util.*;

class RotateIndex {
    public static void main(String[] args) {
        RotateIndex ri = new RotateIndex();
            int[] nums = { 0, 1, 2, 3};
            List<List<Integer>> res = ri.permute(nums);
            //System.out.print(res);
            
            System.out.println(ri.rotate(nums));
    }
    
    private String rotate(int[] nums) {
        int k = nums.length - 1;
        String old = Arrays.toString(nums);
        
        StringBuilder sb = new StringBuilder();        
        sb.append(old.substring(k, old.length()));
        sb.append(old.substring(0, k));
        char[] arr = sb.toString().toCharArray();
        for (char c : arr) {
            System.out.println(c);
        }
        return sb.toString();
        
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