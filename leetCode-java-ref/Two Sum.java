/* Given an array of integers, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

You may assume that each input would have exactly one solution.

Input: numbers={2, 7, 11, 15}, target=9
Output: index1=1, index2=2*/

/* The first way use hashmap to record the number and index, no need to sort the array, overrall run time is O(n).*/
public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] result=new int[2];
        HashMap<Integer,Integer> record=new HashMap<Integer,Integer>();
        for(int i=0;i<numbers.length;++i){
            if(record.containsKey(numbers[i])){
                int index=record.get(numbers[i]);
                result[0]=index+1;
                result[1]=i+1;
            }
            else
                record.put(target-numbers[i],i);
        }
        return result;
    }
}

/* The other way is to use two pointers to traverse the array, however the array must be sorted first, and there is a 
hashmap to store the indexs, the overall running time is O(nlogn).*/
