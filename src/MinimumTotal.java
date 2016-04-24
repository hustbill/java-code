/*120. Triangle My Submissions Question
Total Accepted: 65704 Total Submissions: 220745 Difficulty: Medium
Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

For example, given the following triangle
[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

Note:
Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.

Hide Tags Array Dynamic Programming
Have you met this question in a real interview? Yes  No

Discuss
https://leetcode.com/discuss/5337/dp-solution-for-triangle


*/



import java.util.*;

public class MinimumTotal {
    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();
        
        List<Integer> list = new ArrayList<>();
        list.add(2);
        triangle.add(list);
        
        List<Integer> list1 = new ArrayList<>();
        list1.add(3);  list1.add(4);
        triangle.add(list1);
        
        List<Integer> list2 = new ArrayList<>();
        list2.add(6); list2.add(5); list2.add(7);
        triangle.add(list2);
        
        List<Integer> list3 = new ArrayList<>();
        list3.add(4); list3.add(1); list3.add(8); list3.add(3);
        triangle.add(list3);
        System.out.println(triangle);
         System.out.println(minimumTotal(triangle));
    }
    
    
    
    public static int minimumTotal_my(List<List<Integer>> triangle) {
        int res = 0;
        for (List<Integer> list : triangle) {
            res += getMinimum(list);
        }
        return res;
    }
    
    public static int getMinimum(List<Integer> list) {
        int res = Integer.MAX_VALUE;
        for (int a : list) {
            if (a < res) {
                res = a;
            }
        }
        return res;
    }
}
