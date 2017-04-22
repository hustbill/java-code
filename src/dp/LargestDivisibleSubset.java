public class LargestDivisibleSubset {
    /*
    1. Sort
    2. FInd the length of longest subset
    3. Record the largest element of it.
    4. DO a loop from the largest element to num[0], add every element belong to the logest subset.
    */
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();
        if (nums == null || nums.length == 0) return res;
        Arrays.sort(nums);
        
        int[] dp = new int[nums.length];
        dp[0] = 1;
        
        // for each element in nums; find the length of largest subset it has.
        for (int i = 1; i < nums.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] % nums[j] == 0) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        
        // pick the index of the largest element in dp.
        int maxIndex = 0;
        for (int i = 1; i < nums.length; i++) {
            maxIndex = dp[i] > dp[maxIndex] ? i : maxIndex;
        }
        
        // from nums[maxIndex] to 0, add every element belongs to the largest subset
        int temp = nums[maxIndex];
        int curDp = dp[maxIndex];
        
        for (int i = maxIndex; i >= 0; i--) {
            if (temp % nums[i] == 0 && dp[i] == curDp) {
                res.add(nums[i]);
                temp = nums[i];
                curDp--;
            }
        }
        return res;
    }
}
