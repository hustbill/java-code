/*
 * @lc app=leetcode id=60 lang=java
 *
 * [60] Permutation Sequence
 *
 * https://leetcode.com/problems/permutation-sequence/description/
 *
 * algorithms
 * Medium (34.34%)
 * Likes:    1022
 * Dislikes: 268
 * Total Accepted:    153.7K
 * Total Submissions: 447.1K
 * Testcase Example:  '3\n3'
 *
 * The set [1,2,3,...,n] contains a total of n! unique permutations.
 * 
 * By listing and labeling all of the permutations in order, we get the
 * following sequence for n = 3:
 * 
 * 
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * 
 * 
 * Given n and k, return the k^th permutation sequence.
 * 
 * Note:
 * 
 * 
 * Given n will be between 1 and 9 inclusive.
 * Given k will be between 1 and n! inclusive.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: n = 3, k = 3
 * Output: "213"
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: n = 4, k = 9
 * Output: "2314"
 * 
 * 
 */

// @lc code=start
class Solution {
    // https://leetcode.com/problems/permutation-sequence/discuss/22508/An-iterative-solution-for-reference
    /*
    The logic is as follows: 
    for n numbers the permutations can be divided to (n-1)! groups, 
    for n-1 numbers can be divided to (n-2)! groups, and so on. 
    
    i = n
    Thus k/(i-1)! indicates the index of current number i, 
    and k%(i-1)! denotes remaining index for the remaining i-1 numbers.
    
    We keep doing this until i reaches 0, then we get n numbers permutations that is kth.
    */
    public String getPermutation(int n, int k) {
        List<Integer> num = new LinkedList<Integer>();

        for (int i = 1; i <= n; i++) num.add(i);

        int[] fact = new int[n]; // factorial
        fact[0] = 1;
        for (int i = 1; i < n; i++) 
            fact[i] = i * fact[i - 1];
        
        k = k - 1; // using k = k-1 would avoid dealing with case k%(n-1)!==0.
        StringBuilder sb = new StringBuilder();
        for (int i = n; i > 0; i--) {
            int idx = k / fact[i - 1];  // indicates the index of current number i, 
            k = k % fact[i - 1]; //  k%(i-1)! denotes remaining index for the remaining i-1 numbers.
            sb.append(num.get(idx));
            num.remove(idx);
        }
        return sb.toString();
    }

    // public Set<Integer> permute(int n) {
    //     StringBuilder sb = new StringBuilder();

    //     for (int i = 1; i <= n; i++) {
    //         sb.append(String.valueOf(i));
    //     }
    // }
}
// @lc code=end

