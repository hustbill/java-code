/*
Permutations 
https://oj.leetcode.com/problems/permutations/
Given a collection of numbers, return all possible permutations.

For example,
[1,2,3] have the following permutations:
[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].

*/
import java.util.*;

public class Permutations {
    public static List<List<Integer>> permute2(int[] num) {
		//if( num.length ==0 || num.length==1) return ;
		List<Integer> numList = new ArrayList<Integer>();
		List<List<Integer>> permList = new ArrayList<List<Integer>>();
		for(int i=0; i< num.length; i++) {
			numList.add(num[i]);
		}
		int len = num.length * (num.length-1)/2;
        return permList;
    }
	

    
    /**
     * 
     */
    public static List<List<Integer>> permute(int[] num) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(num);
        permute(num, 0, res);
        return res;
    }
    
    public static void permute(int[] num, int level, List<List<Integer>> res) {
        if (level == num.length) {
            List<Integer> row = new ArrayList<Integer>();
            for (int a : num) row.add(a);
            res.add(row);
            return;
        }
        for (int i = level; i < num.length; i++) {
            swap(num, level, i);
            permute(num, level + 1, res);
            swap(num, level, i); // reset
        }
    }
    
    public static void swap(int[] num, int i, int j) {
        if (i == j) return;
        num[i] = num[j] - num[i];
        num[j] = num[j] - num[i];
        num[i] = num[j] + num[i];
    }
    
    private static void print(int[] num) {
        for (int i = 0; i < num.length; i++) {
            System.out.print(num[i] + " ");
        }
        System.out.println();
    }
	
	public static void main(String[] args) {
		int[] A = { 1, 2, 3};
		List<List<Integer>> permList  = permute(A);
		System.out.println(permute(new int[]{1, 3, 2}));
	}
}