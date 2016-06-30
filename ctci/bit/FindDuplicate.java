package bit;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class BitSet {
	int[] bitset;
	public BitSet(int size) {
		bitset = new int[(size >> 5) + 1]; // divide by 32
	}
	
	boolean get(int pos) {
		int wordNumber = (pos >> 5); // divide by 32
		int bitNumber = (pos & 0x1F);   // mod 32
		System.out.println("wordNumber = " + wordNumber);
		if (wordNumber == -1) wordNumber = 0;  // 这里有问题，面试回来解决。
		return (bitset[wordNumber]  &  (1 << bitNumber)) != 0;
	}
	
	void set(int pos) {
		int wordNumber = (pos >> 5);
		int bitNumber = (pos & 0x1F);   // mod 32
		bitset[wordNumber] |= 1 << bitNumber;
	}
}
public class FindDuplicate {

	void checkDuplicates(int[] array) {
		BitSet bs = new BitSet(32000);
		for (int i = 0; i < array.length; i++) {
			int num = array[i];
			int num0 = num - 1; // bitset starts at 0, numbers start at 1
			if (bs.get(num0)) {
				System.out.println(num);
			} else {
				bs.set(num0);
			}
		}
	}
	
	List<Integer> findDuplicates(int[] array) {
		List<Integer> result = new ArrayList<>();
		BitSet bs = new BitSet(32000);
		for (int i = 0; i < array.length; i++) {
			int num = array[i];
			int num0 = num - 1; // bitset starts at 0, numbers start at 1
			if (bs.get(num0)) {
				System.out.println(num);
				result.add(num);
			} else {
				bs.set(num0);
			}
		}
		return result;
	}
	
	/**
	 * Returns a psuedo-random number between min and max, inclusive.
	 * The difference between min and max can be at most
	 * <code>Integer.MAX_VALUE - 1</code>.
	 *
	 * @param min Minimim value
	 * @param max Maximim value.  Must be greater than min.
	 * @return Integer between min and max, inclusive.
	 * @see java.util.Random#nextInt(int)
	 */
	public static int randInt(int min, int max) {

	    // Usually this can be a field rather than a method variable
	    Random rand = new Random();

	    // nextInt is normally exclusive of the top value,
	    // so add 1 to make it inclusive
	    int randomNum = rand.nextInt((max - min) + 1) + min;

	    return randomNum;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = new int[30000];
		int min = 0, max = 30000;
	
		for (int i = 0;  i< array.length - 3; i++) {
			array[i] = randInt (min, max);
		}
		
		FindDuplicate fd = new FindDuplicate();
		System.out.println(fd.findDuplicates(array));
		
	}

}
