package math;

import java.util.*;

public class HappyNum {
	public static void main(String[] args) {
		HappyNum hpn = new HappyNum();
		int[] nums = { 1, 19, 27, 371, 65, 9 }; // 1, 19 true,  anothers false
		for (int n: nums )
			System.out.println(n + " is happy num ? " + hpn.isHappy(n));
	}

	public boolean isHappy(int n) {
		// https://leetcode.com/discuss/33349/o-1-space-java-solution
		// There is some "detecting a circle in a linkedlist" flavor in this solution. Nice!
		// 1, 19 true,  others are false 
		// e.g 27 -53- 34-25-29-85-[89]-145 -42-20-4-16-37-58-[89]
		int x = n;
		int y = n;

		while (true) {
			x = cal(x);
			if (x == 1)
				return true;

			y = cal(cal(y));
			if (y == 1)
				return true;

			if (x == y)
				return false;
		}

	}

	public int cal(int n) {
		int x = n;
		int result = 0;

		while (x > 0) {
			result += (x % 10) * (x % 10);
			x = x / 10;
		}
		return result;
	}
}
