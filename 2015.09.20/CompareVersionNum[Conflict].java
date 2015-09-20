// Compare Version Numbers

//https://leetcode.com/problems/compare-version-numbers/ 
// compareVersion ( )
// Date:  3/11/2015  hua.zhang@email.wsu.edu
import java.util.*;

public class CompareVersionNum {
	public static int compareVersion(String version1, String version2) {
		int left1 , left2, right1, right2;
		int len1 = version1.length();
		int len2 = version2.length();
		System.out.println("\nversion1=" + version1  + " version2=" + version2);
		System.out.println("len1=" + len1 + " len2=" + len2);
		
		int ret=2;
		
		int pos1 = version1.indexOf('.'); 
		int pos2 = version2.indexOf('.');
		System.out.println("pos1= " + pos1 + " pos2=" + pos2);
		
		
		if(len1 ==1  && len2==1) {
			left1 = Integer.parseInt(version1);
			right1 =0;
			left2 = Integer.parseInt(version2);
			right2=0;
			
			// if v1's left part  is larger than v2's left part, return 1 
			if( left1 > left2) {
				ret= 1;
			}	else if (left1 < left2) {
				// if v1's left part  is smaller than v2's left part, return -1
				ret= -1;
			}  else if( left1 == left2) {
					ret=0;
			}
		}	
		

		
		if( len1 ==1  && len2 >1  && pos2 != -1) {
			left1 = Integer.parseInt(version1);
			right1 =0;
			
			left2 = Integer.parseInt(version2.substring(0, pos2));
			String substr = version2.substring(pos2+1, version2.length());
			int pos3 =  substr.indexOf('.');
			if (pos3 ==-1) 
				right2 = Integer.parseInt(substr);
			else 
				right2 = Integer.parseInt(substr.substring(0, pos3));
		
			
			// if v1's left part  is larger than v2's left part, return 1 
			if( left1 > left2) {
				ret= 1;
			}	else if (left1 < left2) {
				// if v1's left part  is smaller than v2's left part, return -1
				ret= -1;
			}  else if( left1 == left2) {
				// if their left part are equal, then compare the right part
				if(right1 < right2)
					ret= -1;
			
		   } 
		}
		
		if(len1>1 && len2==1 && pos1 != -1) {
			left1 = Integer.parseInt(version1.substring(0, pos1));
			String substr = version1.substring(pos1+1, version1.length());
			int pos3 =  substr.indexOf('.');
			if (pos3 ==-1) 
				right1 = Integer.parseInt(substr);
			else 
				right1 = Integer.parseInt(substr.substring(0, pos3));
			left2 = Integer.parseInt(version2);
			right2=0;
			
			// if v1's left part  is larger than v2's left part, return 1 
			if( left1 > left2) {
				ret= 1;
			}	else if (left1 < left2) {
				// if v1's left part  is smaller than v2's left part, return -1
				ret= -1;
			}  else if( left1 == left2) {
				// if their left part are equal, then compare the right part
				if(right1 > right2)
					ret= 1;
			}
		}
		
		
		if(len1>1 && len2==1 && pos1 == -1) {
			left1 = Integer.parseInt(version1);
			System.out.println("left1=" + left1);
			right1=0;
			left2 = Integer.parseInt(version2);
			right2=0;
			
			// if v1's left part  is larger than v2's left part, return 1 
			if( left1 > left2) {
				ret= 1;
			}	else if (left1 < left2) {
				// if v1's left part  is smaller than v2's left part, return -1
				ret= -1;
			}  else if( left1 == left2) {
				ret= 1;
			}
		}
		
		if(len1>1 && len2>1 && pos1 !=-1 && pos2 !=-1 ) {
			
				System.out.println("pos1=" + pos1 + " pos2=" + pos2);
				left1 = Integer.parseInt(version1.substring(0, pos1));
				left2 = Integer.parseInt(version2.substring(0, pos2));
				System.out.println("left1=" + left1 + " left2=" + left2);
				String substr = version1.substring(pos1+1, version1.length());
				int pos3 =  substr.indexOf('.');
				if (pos3 ==-1) 
					right1 = Integer.parseInt(substr);
				else 
					right1 = Integer.parseInt(substr.substring(0, pos3));
				
				String substr2 = version2.substring(pos2+1, version2.length());
				int pos4 =  substr2.indexOf('.');
				if (pos4 ==-1) 
					right2 = Integer.parseInt(substr2);
				else 
					right2 = Integer.parseInt(substr2.substring(0, pos4));
		
				System.out.println("right1=" + right1 + " right2=" + right2);
				
				// if v1's left part  is larger than v2's left part, return 1 
				if( left1 > left2) {
					ret= 1;
				}	else if (left1 < left2) {
					// if v1's left part  is smaller than v2's left part, return -1
					ret= -1;
				}  else if( left1 == left2) {
					// if their left part are equal, then compare the right part
					if(right1>  right2) 
						ret= 1;
					else if(right1 < right2)
						ret= -1;
					else if (right1 == right2)
						ret=0;
				}
	   	}
		return ret;
		 
	}
	
	public static void main(String[] args) {
		
		String[] input = { "0", "1", "01" , "02"};
		//String[] input = { "0", "1", "01", "2", "02",  "0.0.1", "13", "0.1", "1.1", "1.2", "13.37"};
		char flag = '/';
		// case 1 
		for(int i=0 ; i< input.length; i++ ) {
			for(int j=0; j< input.length; j++) {
				if (input[i]!=input[j])  {
				  	if(	compareVersion(input[i], input[j])==1)  flag ='>';
						if(	compareVersion(input[i], input[j])==-1)  flag ='<';
							if(	compareVersion(input[i], input[j])==0)  flag ='=';
						    System.out.println(String.format("%s  %c  %s\n",
							input[i], flag, input[j]));
				}				    
			}
		}
		
	}
	
}
