/* 
170. Two Sum III - Data structure design
https://leetcode.com/problems/two-sum-iii-data-structure-design/

Total Accepted: 10259 Total Submissions: 42707 Difficulty: Easy
Design and implement a TwoSum class. It should support the following operations: add and find.

add - Add the number to an internal data structure.
find - Find if there exists any pair of numbers which sum is equal to the value.

For example,
add(1); add(3); add(5);
find(4) -> true
find(7) -> false
Hide Company Tags LinkedIn
Hide Tags Hash Table Design
Hide Similar Problems (E) Two Sum (E) Unique Word Abbreviation
*/

import java.util.*;

public class TwoSumIII {
    private Map<Integer, Integer> table = new HashMap<>();
    // add - O(1) runtime, find- O(n) runtime, O(n) space- store in hash table
	
    // Add the number to an internal data structure.
   	public void add(int number) {
        int count = table.containsKey(number) ? table.get(number) : 0;
        table.put(number, count + 1);
   	}

       // Find if there exists any pair of numbers which sum is equal to the value.
   	public boolean find(int value) {
        for (Map.Entry<Integer, Integer> entry : table.entrySet()) {
            int num = entry.getKey();
            int y = value - num;
            if ( y == num) {
                // For duplicates, ensure there are at least two individual numbers.
                if (entry.getValue() >= 2) return true;
            } else if (table.containsKey(y)) {
                return true;
            }
        }
        return false;
   	}
    
	public static void main(String[] args) {
        // Your TwoSum object will be instantiated and called as such:
        // TwoSum twoSum = new TwoSum();
        // twoSum.add(number);
        // twoSum.find(value);
        TwoSumIII t = new TwoSumIII();
        t.add(1); t.add(3); t.add(5);
        System.out.printf("%s \n", t.find(4) == true? "Test case- find(4) success" : "Test case- find(4) failed"); // -> true
        System.out.printf("%s \n", t.find(7) == false ? "Test case- find(7) success" : "Test case- find(4) failed"); // -> true// -> false
        
	}
}