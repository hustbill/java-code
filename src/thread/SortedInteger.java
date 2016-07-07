package thread;

import java.util.ArrayList;
import java.util.List;

public class SortedInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = 889;
		SortedInteger si = new SortedInteger();
		System.out.println(isSorted(i / 10, i % 10));
		System.out.println(si.digitsSorted(i));
	}

	public static boolean isSorted(int input, int prev) {
		if (input == 0)
			return true;
		if (input % 10 > prev)
			return false;
		return isSorted(input / 10, input % 10);
	}

	public boolean digitsSorted(int input) {
		return checkSorted(Math.abs(input));
	}

	// Time complexity is O(n)
	public boolean checkSorted(int input) {
		if (0 <= input && input < 10)
			return true;
		int cur = input % 10, left = (input / 10) % 10;
		if (left > cur) {
			return false;
		} else {
			return checkSorted(input / 10);
		}
	}

}
