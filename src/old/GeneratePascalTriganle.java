package old;
/*
118. Pascal's Triangle
Total Accepted: 70947 Total Submissions: 220995 Difficulty: Easy
Given numRows, generate the first numRows of Pascal's triangle.

For example, given numRows = 5,
Return

[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
*/ 
import java.util.*;
    
public class GeneratePascalTriganle {
    
    public static void main(String[] args) {
        int numRows = 5;
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        res = generate(numRows);
        //System.out.println(res);
        for (int i=0; i < res.size(); i++) {
            List<Integer> row = res.get(i);
            for(int k : row)
                System.out.printf(" %d ", k);
            System.out.println("");
        }
        
    }
    
    public static List<List<Integer>> generate(int numRows) {
        
        List<List<Integer>> rows = new ArrayList<List<Integer>>();
        List<Integer> row = new ArrayList<Integer>();
        for (int i=0; i< numRows; i++) {
            row.add(0,1);

            System.out.printf("row.size() = %d\n", row.size());
            for( int j=1; j< row.size() - 1; j++) {
                row.set(j, row.get(j) + row.get(j+1));
            }
            rows.add(new ArrayList<Integer>(row));
        }
        return rows;
    }
}