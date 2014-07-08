/*Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

For example,
Given [100, 4, 200, 1, 3, 2],
The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

Your algorithm should run in O(n) complexity.*/

/* Use a hashset to store all the elements, traverse the array to find the left and right element.*.

public class Solution {
    public int longestConsecutive(int[] num) {
        if(null==num || 0==num.length)
            return 0;
        HashSet<Integer> set=new HashSet<Integer>();
        for(int i:num){
            set.add(i);
        }
        int max=0;
        for(int i:num){
            int count=1,left=i-1,right=i+1;
            while(set.contains(left)){
                count++;
                set.remove(left--);
            }
            while(set.contains(right)){
                count++;
                set.remove(right++);
            }
            max=Math.max(max,count);
        }
        return max;
    }
}

/* another solution: use hashmap to store the maximum consequtive length for each elements then update the map.*/
public class Solution {
    public int longestConsecutive(int[] num) {
        if(null==num || 0==num.length)
            return 0;
        int max=1;
        HashMap<Integer,Integer>map = new HashMap<Integer,Integer>();
        for(int i:num){
            if(map.containsKey(i))
                continue;
            map.put(i,1);
            if(map.containsKey(i-1))
                max=Math.max(max,merge(map,i-1,i));
            if(map.containsKey(i+1))
                max=Math.max(max,merge(map,i,i+1));
        }
        return max;
    }
    public int merge(HashMap<Integer,Integer> map, int left, int right){
        int upper=right+map.get(right)-1;
        int lower=left-map.get(left)+1;
        int len=upper-lower+1;
        map.put(upper,len);
        map.put(lower,len);
        return len;
    }
}
