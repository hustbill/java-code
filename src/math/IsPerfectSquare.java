   /* https://discuss.leetcode.com/category/451/valid-perfect-square
    Java Three Solutions 1,3,5,.. Sequence/Binary Search/Newton
    a square number is 1+3+5+7+... Time Complexity O(sqrt(N)) (Credit to lizhibupt, thanks for correcting this).
binary search. Time Complexity O(logN)
Newton Method. See this wiki page. Time Complexity is close to constant, given a positive integer.
    */
    public boolean isPerfectSquare1(int num) {
        if (num < 0 ) return false;
        
        for (int i = 1 ;  num > 0 ; i += 2) {
            num -= i;
        }
        return num == 0;
    }
    
    public boolean isPerfectSquare(int num) {
      if (num < 1) return false;
      long left = 1, right = num;// long type to avoid 2147483647 case
    
      while (left <= right) {
        long mid = left + (right - left) / 2;
        long t = mid * mid;
        if (t > num) {
          right = mid - 1;
        } else if (t < num) {
          left = mid + 1;
        } else {
          return true;
        }
      }
    
      return false;
    }
    public boolean isPerfectSquare3(int num) {
      if (num < 1) return false;
      long t = num / 2;
      while (t * t > num) {
        t = (t + num / t) / 2;
      }
      return t * t == num;
    }
