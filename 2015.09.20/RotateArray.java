/*

Roatate Array

https://leetcode.com/problems/rotate-array/

Rotate an array of n elements to the right by k steps.

For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].

Note:
Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.

[show hint]

Related problem: Reverse Words in a String II

Credits:
Special thanks to @Freezen for adding this problem and creating all test cases.
*/

import java.util.*;
public class RotateArray {
<<<<<<< Local Changes
<<<<<<< Local Changes
<<<<<<< Local Changes
<<<<<<< Local Changes
    public static void rotate1(int[] nums, int k) {
=======
	
	// solution2: 
    public static void rotate1(int[] nums, int k) {
>>>>>>> External Changes
=======
	
	// solution2: 
=======
	
	// solution2: 
>>>>>>> External Changes
=======
	
	// solution2: 
>>>>>>> External Changes
    public static void rotate(int[] nums, int k) {
>>>>>>> External Changes
		HashMap<Integer, Integer> map  = new HashMap<Integer, Integer>();
	
		int len = nums.length;
	
		if( len > k) {
			for(int i= len-k; i< len; i++) {
				map.put(i - (len-k), nums[i]);
			}
        	for (int i =0; i< len -k ; i++) {
        		map.put( i + k , nums[i]);
        	}
	
			for(int j =0; j< map.size();j++)
				nums[j]= map.get(j);
<<<<<<< Local Changes
<<<<<<< Local Changes
		}
		if (len < k) {
			k = k%len;
			rotate(nums, k);
		}
    }
	
	// solution 1: 
    public static void rotate1(int[] nums, int k) {
	
	    int len = nums.length;
			int[] temp = new int[len];
			if (len > k) {
				// Refer :  http://stackoverflow.com/questions/26610309/java-rotating-array
				System.arraycopy(nums, 0, temp, k, len-k);
				System.arraycopy(nums, len-k, temp, 0, k);
			
				System.arraycopy(temp, 0, nums, 0, len); // nums[i] = temp[i], i= 0... len

			}
		
			if( len <k) {  // this part is wroten by myself -hua
				k = k%len;
				System.out.println("k=" + k);
				rotate(nums, k);
			}
			
	
		
    }
	
<<<<<<< Local Changes
<<<<<<< Local Changes
<<<<<<< Local Changes
<<<<<<< Local Changes
<<<<<<< Local Changes
<<<<<<< Local Changes
<<<<<<< Local Changes
<<<<<<< Local Changes
<<<<<<< Local Changes
<<<<<<< Local Changes
<<<<<<< Local Changes
<<<<<<< Local Changes
<<<<<<< Local Changes
<<<<<<< Local Changes
<<<<<<< Local Changes
<<<<<<< Local Changes
<<<<<<< Local Changes
<<<<<<< Local Changes
<<<<<<< Local Changes
<<<<<<< Local Changes
<<<<<<< Local Changes
<<<<<<< Local Changes
<<<<<<< Local Changes
<<<<<<< Local Changes
    public static void rotate1(int[] nums, int k) {
		HashMap<Integer, Integer> map  = new HashMap<Integer, Integer>();
	
		int len = nums.length;
		int[] newArr = new int[len];
		System.arraycopy(nums, 0, temp, k, len-k);
		System.arraycopy(nums, len-k, temp, 0, k);
		
		nums = temp;

    }
	
=======
    public static void rotate1(int[] nums, int k) {
		HashMap<Integer, Integer> map  = new HashMap<Integer, Integer>();
	
		int len = nums.length;
		int[] temp = new int[len];
		System.arraycopy(nums, 0, temp, k, len-k);
		System.arraycopy(nums, len-k, temp, 0, k);
		
		nums = temp;

    }
	
>>>>>>> External Changes
=======
    public static void rotate1(int[] nums, int k) {
		HashMap<Integer, Integer> map  = new HashMap<Integer, Integer>();
	
		int len = nums.length;
		int[] temp = new int[len];
		if( len > k) {
			System.arraycopy(nums, 0, temp, k, len-k);
			System.arraycopy(nums, len-k, temp, 0, k);
			nums = temp;
		}

    }
	
>>>>>>> External Changes
=======
    public static void rotate(int[] nums, int k) {
	
		int len = nums.length;
		int[] temp = new int[len];
		if( len > k) {
			System.arraycopy(nums, 0, temp, k, len-k);
			System.arraycopy(nums, len-k, temp, 0, k);
			nums = temp;
		} else if ( k%2 !=0) {
			
		}
			
		

    }
	
>>>>>>> External Changes
=======
    public static void rotate(int[] nums, int k) {
	
		int len = nums.length;
		int[] temp = new int[len];
	
			System.arraycopy(nums, 0, temp, k, len-k);
			System.arraycopy(nums, len-k, temp, 0, k);
			nums = temp;
		
			
		

    }
	
>>>>>>> External Changes
=======
    public static void rotate(int[] nums, int k) {
	
		int len = nums.length;
		int[] temp = new int[len];
		if (len > k) {
	
			System.arraycopy(nums, 0, temp, k, len-k);
			System.arraycopy(nums, len-k, temp, 0, k);
			nums = temp;
		}
=======
		}
		if (len < k) {
			k = k%len;
			rotate(nums, k);
		}
    }
	
	// solution 1: 
    public static void rotate1(int[] nums, int k) {
	
	    int len = nums.length;
			int[] temp = new int[len];
			if (len > k) {
				// Refer :  http://stackoverflow.com/questions/26610309/java-rotating-array
				System.arraycopy(nums, 0, temp, k, len-k);
				System.arraycopy(nums, len-k, temp, 0, k);
			
				System.arraycopy(temp, 0, nums, 0, len); // nums[i] = temp[i], i= 0... len

			}
		
			if( len <k) {  // this part is wroten by myself -hua
				k = k%len;
				System.out.println("k=" + k);
				rotate(nums, k);
			}
>>>>>>> External Changes
			
<<<<<<< Local Changes
		

    }
	
>>>>>>> External Changes
=======
    public static void rotate(int[] nums, int k) {
	
		int len = nums.length;
		int[] temp = new int[len];
		if (len > k) {
	
			System.arraycopy(nums, 0, temp, k, len-k);
			System.arraycopy(nums, len-k, temp, 0, k);
			nums = temp;
		}
		
		if( len <k) {
			k = k%len;
			rotate(nums, k);
		}
			
		

    }
	
>>>>>>> External Changes
=======
    public static void rotate(int[] nums, int k) {
	
		int len = nums.length;
		int[] temp = new int[len];
		if (len > k) {
	
			System.arraycopy(nums, 0, temp, k, len-k);
			System.arraycopy(nums, len-k, temp, 0, k);
			nums = temp;
		}
		
		if( len <k) {
			k = k%len;
			System.out.println("k=" + k);
			rotate(nums, k);
		}
			
		

    }
	
>>>>>>> External Changes
=======
    public static void rotate(int[] nums, int k) {
	
		int len = nums.length;
		int[] temp = new int[len];
		if (len > k) {
	
			System.arraycopy(nums, 0, temp, k, len-k);
			System.out.println(" nums " + nums);
			System.out.println(" temp " + temp);
			System.arraycopy(nums, len-k, temp, 0, k);
			nums = temp;
		}
		
		if( len <k) {
			k = k%len;
			System.out.println("k=" + k);
			rotate(nums, k);
		}
			
		

    }
	
>>>>>>> External Changes
=======
    public static void rotate(int[] nums, int k) {
	
		int len = nums.length;
		int[] temp = new int[len];
		if (len > k) {
	
			System.arraycopy(nums, 0, temp, k, len-k);
			System.out.println(" a. nums " + nums);
			System.out.println(" a. temp " + temp);
			System.arraycopy(nums, len-k, temp, 0, k);
			System.out.println(" b. nums " + nums);
			System.out.println(" b. temp " + temp);
			nums = temp;
		}
		
		if( len <k) {
			k = k%len;
			System.out.println("k=" + k);
			rotate(nums, k);
		}
			
		

    }
	
>>>>>>> External Changes
=======
    public static void rotate(int[] nums, int k) {
	
		int len = nums.length;
		int[] temp = new int[len];
		if (len > k) {
	
			System.arraycopy(nums, 0, temp, k, len-k);
			System.out.println(" a. nums " + nums.toString());
			System.out.println(" a. temp " + temp.toString());
			System.arraycopy(nums, len-k, temp, 0, k);
			System.out.println(" b. nums " + nums.toString());
			System.out.println(" b. temp " + temp.toString());
			nums = temp;
		}
		
		if( len <k) {
			k = k%len;
			System.out.println("k=" + k);
			rotate(nums, k);
		}
			
		

    }
	
>>>>>>> External Changes
=======
    public static void rotate(int[] nums, int k) {
	
		int len = nums.length;
		int[] temp = new int[len];
		if (len > k) {
	
			System.arraycopy(nums, 0, temp, k, len-k);
			System.arraycopy(nums, len-k, temp, 0, k);

			nums = temp;
		}
		
		if( len <k) {
			k = k%len;
			System.out.println("k=" + k);
			rotate(nums, k);
		}
			
		

    }
	
>>>>>>> External Changes
=======
    public static void rotate(int[] nums, int k) {
	
		int len = nums.length;
		int[] temp = new int[len];
		if (len > k) {
	
			System.arraycopy(nums, 0, temp, k, len-k);
			System.arraycopy(nums, len-k, temp, 0, k);

			nums = temp;
		}
		
		if( len <k) {
			k = k%len;
			System.out.println("k=" + k);
			rotate(nums, k);
		}
=======
		}
		if (len < k) {
			k = k%len;
			rotate(nums, k);
		}
    }
	
	// solution 1: 
    public static void rotate1(int[] nums, int k) {
	
	    int len = nums.length;
			int[] temp = new int[len];
			if (len > k) {
				// Refer :  http://stackoverflow.com/questions/26610309/java-rotating-array
				System.arraycopy(nums, 0, temp, k, len-k);
				System.arraycopy(nums, len-k, temp, 0, k);
			
				System.arraycopy(temp, 0, nums, 0, len); // nums[i] = temp[i], i= 0... len

			}
		
			if( len <k) {  // this part is wroten by myself -hua
				k = k%len;
				System.out.println("k=" + k);
				rotate(nums, k);
			}
>>>>>>> External Changes
			
<<<<<<< Local Changes
		

    }
	
>>>>>>> External Changes
=======
    public static void rotate(int[] nums, int k) {
	
		int len = nums.length;
		int[] temp = new int[len];
		if (len > k) {
	
			System.arraycopy(nums, 0, temp, k, len-k);
			System.arraycopy(nums, len-k, temp, 0, k);

			//nums = temp;
		}
		
		if( len <k) {
			k = k%len;
			System.out.println("k=" + k);
			rotate(nums, k);
		}
			
		

    }
	
>>>>>>> External Changes
=======
    public static void rotate(int[] nums, int k) {
	
		int len = nums.length;
		int[] temp = new int[len];
		if (len > k) {
	
			System.arraycopy(nums, 0, temp, k, len-k);
			System.arraycopy(nums, len-k, temp, 0, k);

			//nums = temp;
		}
		
		if( len <k) {
			k = k%len;
			System.out.println("k=" + k);
			rotate(nums, k);
		}
			
		for(int i=0; i< temp.length; i++)
			System.out.print(temp[i] + " ");
    }
	
>>>>>>> External Changes
=======
    public static void rotate(int[] nums, int k) {
	
		int len = nums.length;
		int[] temp = new int[len];
		if (len > k) {
	
			System.arraycopy(nums, 0, temp, k, len-k);
			System.arraycopy(nums, len-k, temp, 0, k);

			//nums = temp;
		}
		
		if( len <k) {
			k = k%len;
			System.out.println("k=" + k);
			rotate(nums, k);
		}
			
		for(int i=0; i< temp.length; i++)
			System.out.print(temp[i] + " ");
		System.out.println();
    }
	
>>>>>>> External Changes
=======
    public static void rotate(int[] nums, int k) {
	
		int len = nums.length;
		int[] temp = new int[len];
		if (len > k) {
	
			System.arraycopy(nums, 0, temp, k, len-k);
			System.arraycopy(nums, len-k, temp, 0, k);

			//nums = temp;
		}
		
		if( len <k) {
			k = k%len;
			System.out.println("k=" + k);
			rotate(nums, k);
		}
			
		for(int i=0; i< temp.length; i++)
			nums[i] = temp[i];
		
    }
	
>>>>>>> External Changes
=======
    public static void rotate(int[] nums, int k) {
	
		int len = nums.length;
		int[] temp = new int[len];
		if (len > k) {
	
			System.arraycopy(nums, 0, temp, k, len-k);
			System.arraycopy(nums, len-k, temp, 0, k);

			//nums = temp;
		}
		
		if( len <k) {
			k = k%len;
			System.out.println("k=" + k);
			rotate(nums, k);
		}
			
		for(int i=0; i< temp.length; i++)
			nums[i] = temp[i];
		
    }
	
>>>>>>> External Changes
=======
    public static void rotate(int[] nums, int k) {
	
		int len = nums.length;
		int[] temp = new int[len];
		if (len > k) {
	
			System.arraycopy(nums, 0, temp, k, len-k);
			System.arraycopy(nums, len-k, temp, 0, k);

			//nums = temp;
			for(int i=0; i< temp.length; i++)
				nums[i] = temp[i];
		}
		
		if( len <k) {
			k = k%len;
			System.out.println("k=" + k);
			rotate(nums, k);
		}
			
	
		
    }
	
>>>>>>> External Changes
=======
	// Refer :  http://stackoverflow.com/questions/26610309/java-rotating-array
    public static void rotate(int[] nums, int k) {
	
		int len = nums.length;
		int[] temp = new int[len];
		if (len > k) {
	
			System.arraycopy(nums, 0, temp, k, len-k);
			System.arraycopy(nums, len-k, temp, 0, k);
			System.arraycopy(temp, 0, nums, 0, len);

			//nums = temp;
			// for(int i=0; i< temp.length; i++)
		// 		nums[i] = temp[i];
		}
		
		if( len <k) {
			k = k%len;
			System.out.println("k=" + k);
			rotate(nums, k);
		}
			
	
		
    }
	
>>>>>>> External Changes
=======
	// Refer :  http://stackoverflow.com/questions/26610309/java-rotating-array
    public static void rotate(int[] nums, int k) {
	
		int len = nums.length;
		int[] temp = new int[len];
		if (len > k) {
	
			System.arraycopy(nums, 0, temp, k, len-k);
			System.arraycopy(nums, len-k, temp, 0, k);
			System.arraycopy(temp, 0, nums, 0, len);

			//nums = temp;
			// for(int i=0; i< temp.length; i++)
		// 		nums[i] = temp[i];
		}
		
		if( len <k) {
			k = k%len;
			System.out.println("k=" + k);
			rotate(nums, k);
		}
			
	
		
    }
	
>>>>>>> External Changes
=======
	// Refer :  http://stackoverflow.com/questions/26610309/java-rotating-array
    public static void rotate(int[] nums, int k) {
	
		int len = nums.length;
		int[] temp = new int[len];
		if (len > k) {
	
			System.arraycopy(nums, 0, temp, k, len-k);
			System.arraycopy(nums, len-k, temp, 0, k);
			System.arraycopy(temp, 0, nums, 0, len);

		}
		
		if( len <k) {
			k = k%len;
			System.out.println("k=" + k);
			rotate(nums, k);
		}
			
	
		
    }
	
>>>>>>> External Changes
=======
	// Refer :  http://stackoverflow.com/questions/26610309/java-rotating-array
    public static void rotate(int[] nums, int k) {
	
		int len = nums.length;
		int[] temp = new int[len];
		if (len > k) {
	
			System.arraycopy(nums, 0, temp, k, len-k);
			System.arraycopy(nums, len-k, temp, 0, k);
			
			System.arraycopy(temp, 0, nums, 0, len); // nums[i] = temp[i], i= 0... len

		}
		
		if( len <k) {
			k = k%len;
			System.out.println("k=" + k);
			rotate(nums, k);
		}
			
	
		
    }
	
>>>>>>> External Changes
=======
	
    public static void rotate(int[] nums, int k) {
	
	    int len = nums.length;
			int[] temp = new int[len];
			if (len > k) {
				// Refer :  http://stackoverflow.com/questions/26610309/java-rotating-array
				System.arraycopy(nums, 0, temp, k, len-k);
				System.arraycopy(nums, len-k, temp, 0, k);
			
				System.arraycopy(temp, 0, nums, 0, len); // nums[i] = temp[i], i= 0... len

			}
		
			if( len <k) {  // this part is wroten by myself -hua
				k = k%len;
				System.out.println("k=" + k);
				rotate(nums, k);
			}
			
	
		
    }
	
>>>>>>> External Changes
=======
	// solution 1: 
    public static void rotate(int[] nums, int k) {
	
	    int len = nums.length;
			int[] temp = new int[len];
			if (len > k) {
				// Refer :  http://stackoverflow.com/questions/26610309/java-rotating-array
				System.arraycopy(nums, 0, temp, k, len-k);
				System.arraycopy(nums, len-k, temp, 0, k);
			
				System.arraycopy(temp, 0, nums, 0, len); // nums[i] = temp[i], i= 0... len

			}
		
			if( len <k) {  // this part is wroten by myself -hua
				k = k%len;
				System.out.println("k=" + k);
				rotate(nums, k);
			}
			
	
		
=======
	
		
>>>>>>> External Changes
=======
	
		
>>>>>>> External Changes
    }
	
>>>>>>> External Changes
	public static void main(String[] args) {
<<<<<<< Local Changes
<<<<<<< Local Changes
<<<<<<< Local Changes
<<<<<<< Local Changes
<<<<<<< Local Changes
<<<<<<< Local Changes
<<<<<<< Local Changes
<<<<<<< Local Changes
<<<<<<< Local Changes
<<<<<<< Local Changes
<<<<<<< Local Changes
		int[]  nums = { 1, 2, 3, 4, 5, 6 ,7};
=======
		//int[]  nums = { 1, 2, 3, 4, 5, 6 ,7};
=======
		//int[]  nums = { 1, 2, 3, 4, 5, 6 ,7};
>>>>>>> External Changes
=======
		int[]  nums = { 1, 2, 3, 4, 5, 6 ,7};
>>>>>>> External Changes
=======
		//int[]  nums = { 1, 2, 3, 4, 5, 6 ,7};
>>>>>>> External Changes
		int[]  nums = { 1, 2};
>>>>>>> External Changes
=======
		int[]  nums = { 1, 2, 3, 4, 5, 6 ,7};
		//int[]  nums = { 1, 2};
>>>>>>> External Changes
=======
		int[]  nums = { 1, 2, 3, 4, 5, 6 ,7};
		//int[]  nums = { 1, 2};
>>>>>>> External Changes
=======
		int[]  nums = { 1, 2, 3, 4, 5, 6 ,7};
		//int[]  nums = { 1, 2};
>>>>>>> External Changes
=======
		int[]  nums = { 1, 2, 3, 4, 5, 6 ,7};
		//int[]  nums = { 1, 2};
>>>>>>> External Changes
=======
		int[]  nums = { 1, 2, 3, 4, 5, 6 ,7};
		//int[]  nums = { 1, 2};
>>>>>>> External Changes
=======
		int[]  nums = { 1, 2, 3, 4, 5, 6 ,7};
		//int[]  nums = { 1, 2};
>>>>>>> External Changes
=======
		int[]  nums = { 1, 2, 3, 4, 5, 6 ,7};
		//int[]  nums = { 1, 2};
>>>>>>> External Changes
		// int[] nums ={-1};
		int k =3;
		rotate(nums, k);
		for(int i=0; i< nums.length; i++)
		System.out.print(nums[i] + " ");
		System.out.println();
		
	}
}