/*

Count and Say 
https://leetcode.com/problems/count-and-say/

The count-and-say sequence is the sequence of integers beginning as follows:
1, 11, 21, 1211, 111221, ...

1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.
Given an integer n, generate the nth sequence.

Note: The sequence of integers will be represented as a string.

*/

public class CountAndSay {

	public static String countAndSay(int n){
		// two reference
		// 1. http://blog.csdn.net/linhuanmars/article/details/20679963
		// 2. http://www.cnblogs.com/springfor/p/3889221.html
    	if (n<=0)  return "";
		String curRes = "1";
		int start = 1; // start from 1
		while( start < n) {
			StringBuilder res = new StringBuilder();
			int count = 1;
			for( int j=1; j< curRes.length(); j++) {
				if(curRes.charAt(j) == curRes.charAt(j-1))
					count++;
				else{
					res.append(count);
					res.append(curRes.charAt(j-1));
					count =1;
				}
			}
			
			res.append(count);
			res.append(curRes.charAt(curRes.length()-1));
			// 小陷阱就是跑完循环之后记得把最后一个字符也加上，因为之前只是计数而已。这道题属于字符串或者说数组操作的类型，考察对于明确问题和算法的实现能力，一般会在电面，或者最容易的第一道题中出现，力求一遍搞定，不留bug哈。
			//
			curRes = res.toString();
			start++;
		}
		return curRes;
	}

    public static String countAndSay2(int n) {
        String res = "";
		String prev = "";
		if (n==1)  res = "1";
		if (n==2)  res = "11";
		if (n==3)  res = "21";
		if(n> 3) {
			
			res = calcCurrent(countAndSay(n-1));
			n=n-1;
		}
		
		return res;
    }
	
	public static String calcCurrent(String prev) {
		String res = prev;
		
		System.out.println("\nprev="+ res);
			//
			// for(int i=0; i< prev.length()-1; ){
			//
			// 	String substr = prev.substring(i,i+2);
			// 	System.out.println("substr=" + substr);
			// 	//System.out.println("i=" + i+ " , prev.substring(i+2)="+  prev.substring(i+2));
			//
			// 	if( substr.equals( "11")) {
			// 		res = "21"  + prev.substring(i+2) ;
			// 	}
			// 	if(substr.equals( "12")) {
			// 		res = "1112" + prev.substring(i+2) ;
			// 		System.out.println("i=" + i+ " , prev.substring(i+2)="+  prev.substring(i+2));
			// 		System.out.println("res=" + res);
			// 	}
			// 	if(substr.equals( "21" )) {
			// 		res = "1211"  + prev.substring(i+2) ;
			// 	}
			// 	i=i+2;
			// }
			//	
			String left ="", right= "";
			int len = prev.length();
			if (len %2 ==0 ) {
				left = prev.substring(0, len/2);
				right = prev.substring(len/2, len);
				
			}
			
			if(left.length()==2) {
				if(left.equals("11")) {
					left = "21";
				}
				if(left.equals("12")) {
					left = "1112";
				}
				if(left.equals("21")) {
					left = "1211";
				}
			}
			
			if(right.length()==2) {
				if(right.equals("11")) {
					right = "21";
				}
				if(right.equals("12")) {
					right = "1112";
				}
				if(right.equals("21")) {
					right = "1211";
				}
			}
			res = left +right;
		System.out.println("res=" + res);
			return res;
	}
	
	public static void main(String[] args) {
		
		for(int n=4; n <6; n++) {
			System.out.println(String.format("The No. %d string is %s", n , countAndSay(n)));
			System.out.println();
		}
	}
}


