package oj.ots;
import java.util.*;

public class RemoveLargestChar {
	/*
	3. 给定一个string, 问如何去掉一个character，使得剩下的string最小。
比如给出acd，去掉d返回剩下的ac就是正确的。因为去掉c留下ad，去掉a留下cd，都比ac要大。
比如给出hot，去掉t返回剩下的ho就是正确的。因为去掉h留下ot，去掉o留下ht，都比ho要大。
比如给出aaaa，只要返回aaa就是正确的
提示：
第三题用的Stack，循环遍历riddle的每个字母，如果栈顶char比要入栈的char大就弹出再插入。

	 */

	// https://leetcode.com/problems/kth-largest-element-in-an-array/solution/
	// Time complexity: O(N)	
	public String removeLargestChar(String riddle) {
		char[] arr = riddle.toCharArray();
		
		 // init heap 'the smallest element first'
        PriorityQueue<Character> heap =
            new PriorityQueue<Character>((n1, n2) -> n1 - n2);

        // keep the largest elements in the heap
        for (char n: arr) {
          heap.add(n);
          if (heap.size() > 1)
            heap.poll();
        }

        char largest = heap.poll();
        
        //remove the largest one
        int idx = riddle.indexOf(largest);
        String ret = riddle.substring(0, idx) + riddle.substring(idx + 1);
        return ret;       

	}

	public static  void main(String[] args) {
		String[] strs = {"abcde", "ABCD", "mabcd", "abkcdD"};
		RemoveLargestChar cdt  = new RemoveLargestChar();
		for (String str : strs) {
			String ret = cdt.removeLargestChar(str);
			System.out.println("ret: " + ret);
		}
	}

}
