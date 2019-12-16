package oj;
import java.util.*;

public class VMwareCodeTemplate {



	public static  void main(String[] args) {
		String digits = "23";
		VMwareCodeTemplate cdt  = new VMwareCodeTemplate();
		
		int[] inputArr = {1, 2 ,3 ,4 ,5 ,6 , 7 }; //
		int[] outputArr = cdt.sortArrayByParity(inputArr);
		for (int i = 0; i < outputArr.length; i++)
			System.out.print(outputArr[i] + "\t");	
		// outputArr: 2	4	6	7	5	3	1	
		
		System.out.println();
		
			// verify_oddEventSort
	        int[] numbers = new int[]{12,33,45,33,13,55,34,7,6};  
	        oddEventSort(numbers);  
	        for(int i=0; i<numbers.length; i++){  
	            System.out.print(numbers[i]+" ");  
	        } 
	}
	
	/*
	 * 奇数偶数分离 Leetcode 905 ： https://leetcode.com/problems/sort-array-by-parity/
	 */
	
	public int[] sortArrayByParity(int[] A) {
		if(A.length == 0) 
			return A;
		
		int[] B = new int[A.length];
		
		int begin = 0;
		int end = B.length - 1;
		for (int i = 0; i < A.length; i++) {
			if (A[i] % 2 == 0) {
				B[begin] = A[i];
				begin++;
			} else {
				B[end] = A[i];
				end--;
			}
		}
		return B;
	}
	
	/*
	 *  经典排序算法 - 奇偶排序Odd-even sort
		又一个比较性质的排序,基本思路是奇数列排一趟序,偶数列排一趟序,再奇数排,再偶数排,直到全部有序
		
		举例吧,		
		待排数组[6 2 4 1 5 9]  => [1 2 4 5 6 9]
		比较过程如下：
		
		第一次比较奇数列,奇数列与它的邻居偶数列比较,如6和2比,4和1比,5和9比
		
		[6 2 4 1 5 9]
		
		交换后变成
		
		[2 6 1 4 5 9]
		
		 
		
		第二次比较偶数列,即6和1比,4和5比
		
		[2 6 1 4 5 9]
		
		交换后变成
		
		[2 1 6 4 5 9]
		
		 
		
		第三趟又是奇数列,选择的是2,6,5分别与它们的邻居列比较
		
		[2 1 6 4 5 9]
		
		交换后
		
		[1 2 4 6 5 9]
		
		 
		
		第四趟偶数列
		
		[1 2 4 6 5 9]
		
		一次交换
		
		[1 2 4 5 6 9]
		
		参考:http://modun.iteye.com/blog/263976
	 */
	 

	    private static void oddEventSort(int[] numbers){  
	        int temp;  
	        for(int i=numbers.length-1; i>numbers.length/2-1; i--){  
	            for(int j=1; j<=i; j+=2){  
	                if(j==numbers.length-1)break;  
	                if(numbers[j]>numbers[j+1]){  
	                    temp = numbers[j];  
	                    numbers[j] = numbers[j+1];  
	                    numbers[j+1] = temp;  
	                }  
	            }  
	            for(int j=0; j<=i; j+=2){  
	                if(j==numbers.length-1)break;  
	                if(numbers[j]>numbers[j+1]){  
	                    temp = numbers[j];  
	                    numbers[j] = numbers[j+1];  
	                    numbers[j+1] = temp;  
	                }  
	           }  
	        }  
	    }  
	

}
