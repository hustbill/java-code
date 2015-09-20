// Compare Version Numbers

//https://leetcode.com/problems/compare-version-numbers/ 
// compareVersion ( )
// Date:  3/11/2015  hua.zhang@email.wsu.edu

/*
 Test case : 
1  :   1.0 = 1
2 :   2.0 = 02
3:    1.0 = 1.0
*/
import java.util.*;

public class CompareVersionNum {
	
	
	public static int compareVersion(String version1, String version2) {
		int ret = 2;
		int left1 , left2, right1, right2;
		int len1 = version1.length();
		
		int len2 = version2.length();
		int pos1 = version1.indexOf('.'); 
		int pos2 = version2.indexOf('.');
		
		if(pos1 == -1 && pos2 == -1) {
			if (Integer.parseInt(version1) > Integer.parseInt(version2)) ret =1;
				else if (Integer.parseInt(version1) < Integer.parseInt(version2)) ret =-1;
				else  ret =0;
		} else if( pos1 !=-1 && pos2 != -1) {
			String substr1 = version1.substring(0, pos1);
			String substr2 = version2.substring(0, pos2);
			left1 = Integer.parseInt(substr1);
			left2 = Integer.parseInt(substr2);
			if( left1 > left2) {
				ret= 1;
			}	else if (left1 < left2) {
				ret= -1;
			}  else if( left1 == left2) {  // 1.9 vs 1.2.1
				ret=compareVersion(version1.substring(pos1+1, len1), version2.substring(pos2+1, len2));
			}
		} else if ( pos1 != -1  && pos2 == -1)  {  // 2.1   vs 9
			String substr1 = version1.substring(0, pos1);
			left1 = Integer.parseInt(substr1);
			left2 = Integer.parseInt(version2);
			if( left1 > left2)  	ret= 1;
			 if (left1 < left2)   	ret= -1;
		 	 if (left1 == left2) {
				ret=compareVersion(version1.substring(pos1+1, len1), "0");
		 	 }	
		} else if ( pos1 == -1  && pos2 != -1)  { // 9 vs 2.1
			String substr2 = version2.substring(0, pos2);
			left1 = Integer.parseInt(version1);
			left2 = Integer.parseInt(substr2);
			if( left1 > left2) {
				ret=  1;
			}	else if (left1 < left2) {
				ret= -1;
			}  else if( left1 == left2) {
				ret=compareVersion("0", version2.substring(pos2+1, len2));
			}
		}
		
		return ret;
	}
	
	

	public static void main(String[] args) {
		//String[] input = { "1.2.1" , "1.9"};
		//String[] input = { "0", "1", "01", "2", "02",  "13", "0.1", "1.1", "1.2", "13.37", "1.9", "1.9", "1.2.1" , "1.0", "1.0", "1.1"};
		String[] input = {"0.1", "1.0", "1", "2", "02", "2.0"};
		String flag = "";
		for(int i=0;  i< input.length  ; i++) {
			for(int j=0; j < input.length; j++) {
				//if(input[i] != input[j]) {
					System.out.println(String.format("Compare version %s  with  %s :", input[i],  input[j]));
					int ret = compareVersion(input[i], input[j]);
				 		if( ret ==1	)  flag =">";
						if(	ret ==-1)  flag = "<";
						if(	ret==0)  flag ="=";
					System.out.println(String.format("%s  %s  %s\n", input[i], flag, input[j]));
					//}
			
			}
		}		    
		
	  }
	
	
}
