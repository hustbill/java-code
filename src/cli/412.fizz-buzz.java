/*
 * @lc app=leetcode id=412 lang=java
 *
 * [412] Fizz Buzz
 *
 * https://leetcode.com/problems/fizz-buzz/description/
 *
 * algorithms
 * Easy (59.99%)
 * Total Accepted:    228.9K
 * Total Submissions: 381.4K
 * Testcase Example:  '1'
 *
 * Write a program that outputs the string representation of numbers from 1 to
 * n.
 * 
 * But for multiples of three it should output “Fizz” instead of the number and
 * for the multiples of five output “Buzz”. For numbers which are multiples of
 * both three and five output “FizzBuzz”.
 * 
 * Example:
 * 
 * n = 15,
 * 
 * Return:
 * [
 * ⁠   "1",
 * ⁠   "2",
 * ⁠   "Fizz",
 * ⁠   "4",
 * ⁠   "Buzz",
 * ⁠   "Fizz",
 * ⁠   "7",
 * ⁠   "8",
 * ⁠   "Fizz",
 * ⁠   "Buzz",
 * ⁠   "11",
 * ⁠   "Fizz",
 * ⁠   "13",
 * ⁠   "14",
 * ⁠   "FizzBuzz"
 * ]
 * 
 * 
 */
class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> ans = new ArrayList<String>();

        for (int num = 1; num <= n; num++) {
            boolean divisiableBy3 = (num % 3 == 0);
            boolean divisiableBy5 = (num % 5 == 0);
            String curr = "";
            if (divisiableBy3) {
                curr += "Fizz";
            } 
            if (divisiableBy5) {
                curr += "Buzz";
            } 
            
            if (curr.equals("")) {
                // Not divisiable by 3 or 5, add the number
                curr += Integer.toString(num);
            }

            // Append the current answer str to the ans list
            ans.add(numAnsStr);
        }
        return ans;
    }

            
    public List<String> fizzBuzzi_2(int n) {
        List<String> ans = new ArrayList<String>();

        for (int num = 1; num <= n; num++) {
            boolean divisiableBy3 = (num % 3 == 0);
            boolean divisiableBy5 = (num % 5 == 0);
            
            if (divisiableBy3 && divisiableBy5) {
                ans.add("FizzBuzz");
            } else if (divisiableBy3) {
                ans.add("Fizz");
            } else if (divisiableBy5) {
                ans.add("Buzz");
            } else {
                ans.add(Integer.toString(num));
            }
        }
        return ans;
    }

    public List<String> fizzBuzz_1(int n) {
        List<String> ans = new ArrayList<String>();
        String curr = "";
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0)  {
                curr = "FizzBuzz";
            }
            if (i % 3 != 0 && i % 5 == 0) {
                curr = "Buzz";
            }
            if (i % 3 == 0 && i %5 != 0) {
                curr = "Fizz";
            }
            if (i % 3 != 0 && i % 5 != 0) {
                curr = Integer.toString(i);
            }
            ans.add(curr);
        }
        return ans;            
    }
}
