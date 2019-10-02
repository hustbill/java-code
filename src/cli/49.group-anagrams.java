/*
 * @lc app=leetcode id=49 lang=java
 *
 * [49] Group Anagrams
 *
 * https://leetcode.com/problems/group-anagrams/description/
 *
 * algorithms
 * Medium (48.71%)
 * Total Accepted:    405.8K
 * Total Submissions: 817.3K
 * Testcase Example:  '["eat","tea","tan","ate","nat","bat"]'
 *
 * Given an array of strings, group anagrams together.
 * 
 * Example:
 * 
 * 
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Output:
 * [
 * ⁠ ["ate","eat","tea"],
 * ⁠ ["nat","tan"],
 * ⁠ ["bat"]
 * ]
 * 
 * Note:
 * 
 * 
 * All inputs will be in lowercase.
 * The order of your output does not matter.
 * 
 * 
 */
class Solution {
   
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ret = new ArrayList<List<String>>();
        if (strs == null || strs.length == 0) return ret;
        Map<String, List> map = new HashMap<String, List>();
        for (String str : strs) {
            char[] ca = str.toCharArray();
            Arrays.sort(ca);
            String key = String.valueOf(ca);
            if (!map.containsKey(key)) map.put(key, new ArrayList<String>());
            map.get(key).add(str);
        }
        return new ArrayList(map.values());
    }
    
   // two pointers,   ✘ Time Limit Exceeded
   // ✘ 100/101 cases passed (N/A)

    public List<List<String>> groupAnagrams_nok(String[] strs) {
        List<List<String>> ret = new ArrayList<List<String>>();
        if (strs == null || strs.length == 0) return ret;
        // use two pointers
        int left = 0, right = 1;
        int len = strs.length;
        int[] visited = new int[len];
        while (left < len) {
            List<String> curr = new ArrayList<String>();
            curr.add(strs[left]);
            visited[left] = 1;
            while (right < len) {
                if (isAngrams(strs[left], strs[right])) {
                    curr.add(strs[right]);
                    visited[right] = 1;
                }
                right++;
            }
            ret.add(curr);
            while (left < len && visited[left] == 1) {
                left++;
                right = left + 1;
            }
        }
        return ret;
    }

    private boolean isAngrams(String a, String b) {
        char[] aArr = a.toCharArray();
        char[] bArr = b.toCharArray();
        Arrays.sort(aArr);
        Arrays.sort(bArr);
        return Arrays.equals(aArr, bArr);
    }
}
