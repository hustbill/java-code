/*
 * @lc app=leetcode id=66 lang=java
 *
 * [66] Plus One
 */

// @lc code=start
class Solution {
    public int[] plusOne(int[] digits) {
        int len = digits.length;

        for (int i = len - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }

        int[] newArr = new int[len + 1];
        newArr[0] = 1;
        return newArr;

    }
    public int[] plusOne_ok(int[] digits) {
        int len = digits.length;  
        int carry = (digits[len - 1] + 1) / 10;
        int[] arr = new int[len];
        arr[len - 1] = (digits[len - 1] + 1) % 10;
        
        
        for (int i = len - 2; i >=0; i--) {
            arr[i] = (digits[i]  + carry ) % 10;
            carry = (digits[i]  + carry) / 10;
        }
        if (carry == 1) {
            int[] ret = new int[len + 1];
            ret[0] = carry;            
            return ret;
        }
        return arr;
    }
}
// @lc code=end

