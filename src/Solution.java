import java.util.*;

public class SearchMatrix {
	public static void main(String[] args) {
		String s1 = "small", s2 = "smart", s3 = "smartsite", s4= "smab", s5="smac";
		String[] strs = new String[] { s1, s2, s3, s4, s5};
		System.out.printf("prefix =%s", findCommonPrefix(s1, s2));
		System.out.printf("\tres = %s", longestCommonPrefix(strs));
	}
	
    public boolean searchMatrix(int[][] matrix, int target) {
        
    }
}