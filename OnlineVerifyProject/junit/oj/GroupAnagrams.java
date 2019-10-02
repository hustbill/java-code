package oj;

import java.util.*;

public class GroupAnagrams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GroupAnagrams gm = new GroupAnagrams();
		String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
		
		List<List<String>> ret = gm.groupAnagrams(strs);
		System.out.print(ret);

	}
	
	  public List<List<String>> groupAnagrams(String[] strs) {
	        List<List<String>> ret = new ArrayList<List<String>>();
	        if (strs == null || strs.length == 0) return ret;
	        // use two pointers
	        int left = 0, right = 1;
	        int len = strs.length;
	        int[] visited = new int[strs.length];
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
	            while(left < len && visited[left] == 1) {
	            		left++;
	            		right = left + 1;
	           }
	        }
	        return ret;
	    }

	    private boolean isAngrams(String a, String b) {
	        char[] aArr = a.toCharArray();
	        char[] bArr = b.toCharArray();	     
	        return Arrays.equals(aArr, bArr);
	    }

}
