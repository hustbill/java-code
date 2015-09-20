/*

Anagrams Total 
https://leetcode.com/problems/anagrams/

Accepted: 34131 Total Submissions: 140100 
Given an array of strings, return all groups of strings that are anagrams.

Note: All inputs will be in lower-case.

Date: 2015-04-27

*/
import java.util.*;

public class Anagrams {
    public static List<String> anagrams(String[] strs) {
		// ref 
		// 1. http://blog.csdn.net/linhuanmars/article/details/21664747
		// 2. http://www.cnblogs.com/AnnieKim/archive/2013/04/25/3041982.html
		// 3. http://www.cnblogs.com/springfor/p/3874667.html
		/*
		这道题看所给的字符串数组里面有多少个是同一个变形词变的。这道题同样使用HashMap来帮助存老值和新值，以及帮忙判断是否是变形词。
		首先对每个string转换成char array然后排下序，HashMap里面的key存sort后的词，value存原始的词。
			然后如果这个排好序的词没在HashMap中出现过，那么就把这个sorted word和unsortedword put进HashMap里面。
			如果一个sorted word是在HashMap里面存在过的，说明这个词肯定是个变形词，除了把这个词加入到返回结果中，
			还需要把之前第一个存进HashMap里面的value存入result中。*/
		List<String> res = new ArrayList<String>();
		if (strs.length==0 || strs == null) 
			return res;
		HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
		for(String str : strs) {
				char[] charArr = str.toCharArray();
				Arrays.sort(charArr);
				String tempStr =  new String(charArr);
				if( map.containsKey(tempStr)) {
					map.get(tempStr).add(str);
				} else {
					ArrayList<String> newList = new ArrayList<String>();
					newList.add(str);
					map.put(tempStr, newList);
				}
		}
		Iterator iter = map.values().iterator();
		while (iter.hasNext()) {
			ArrayList<String> item = (ArrayList<String>)iter.next();
			if(item.size()> 1)
				res.addAll(item);
		}
		return res;
    }
	
	public static void main(String[] args) {
		String[] strs = {"hello", "olleh", "good", "doog", "world", "word", "enjoy", "joyen"};
		List<String> list = anagrams(strs);
		System.out.println(list);
		
	}


	// 3. http://www.cnblogs.com/springfor/p/3874667.html
public ArrayList<String> anagrams2(String[] strs) {
     ArrayList<String> result=new ArrayList<String>();
     
     if (strs==null||strs.length==0)
         return result;
     
     HashMap<String,ArrayList<String>> hm = new HashMap<String, ArrayList<String>>();
     
     for (String s:strs){
         char[] temp=s.toCharArray();
         Arrays.sort(temp);
         String tempStr=new String(temp);
         
         if (hm.containsKey(tempStr)){
             if(hm.get(tempStr).size() == 1)
                result.add(hm.get(tempStr).get(0));
             hm.get(tempStr).add(s);
             result.add(s);
         }else{
             ArrayList<String> tempList=new ArrayList<String>();
             tempList.add(s);
             hm.put(tempStr, tempList);
             }
        }
        return result;
 }
}