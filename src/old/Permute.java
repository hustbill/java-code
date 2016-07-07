package old;
import java.util.*;

public class Permute {
    public static List<List<Integer>> permute(int[] nums) {
		// two solutions:  (1) recursive  (2) iteration 
	    LinkedList<List<Integer>> res = new LinkedList<List<Integer>>();
		if (nums.length ==0 ) return res;
		
		res.add(new ArrayList<Integer>());
		for(int n : nums) {
			int size = res.size();
			for(; size > 0 ; size--) {
				List<Integer> list = res.pollFirst();
				for(int j=0; j<= list.size(); j++) {
					List<Integer> newList = new ArrayList<Integer>(list);
					newList.add(j, n);
					System.out.println("newList = " + newList);
					res.add(newList);
				}
			}
		}
		/*
		newList = [1]
		newList = [2, 1]
		newList = [1, 2]
		newList = [3, 2, 1]
		newList = [2, 3, 1]
		newList = [2, 1, 3]
		newList = [3, 1, 2]
		newList = [1, 3, 2]
		newList = [1, 2, 3]
		0 : [3, 2, 1]
		1 : [2, 3, 1]
		2 : [2, 1, 3]
		3 : [3, 1, 2]
		4 : [1, 3, 2]
		5 : [1, 2, 3]
		*/
		/* for( int i=1; i< nums.length; ++i) {
			List<List<Integer>> newRes = new ArrayList<List<Integer>>();
			for(int j=0; j<=i; ++j) {
				for (List<Integer>  item : res) {
					List<Integer> newItem = new ArrayList<Integer>(item);
					System.out.println("j=" +j + ", nums["+ i + "]= " + nums[i]);
					newItem.add(j, nums[i]);
					System.out.println("newItem= " + newItem);
					newRes.add(newItem);
				}
			}
			res = newRes;
		} */
		return res;
    }
	
	public static void main(String[] args) {
		int[] nums = {1, 2, 3};
		List<List<Integer>> res = permute(nums);
		printListList(res);
	}
	
	public static void printListList( List<List<Integer>> res) {
		int i=0; 
		for(List<Integer> list : res) {
			System.out.println( i +" : " + list);
			i++;
		}
	}
}