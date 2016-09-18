/*
Dynamic Programming | Set 30 (Dice Throw)
http://www.geeksforgeeks.org/dice-throw-problem/

Given n dice each with m faces, numbered from 1 to m, find the number of ways to get sum X. X is the summation of values on each face when all the dice are thrown.


We strongly recommend that you click here and practice it, before moving on to the solution.


The Naive approach is to find all the possible combinations of values from n dice and keep on counting the results that sum to X.

This problem can be efficiently solved using Dynamic Programming (DP).

Let the function to find X from n dice is: Sum(m, n, X)
The function can be represented as:
Sum(m, n, X) = Finding Sum (X - 1) from (n - 1) dice plus 1 from nth dice
               + Finding Sum (X - 2) from (n - 1) dice plus 2 from nth dice
               + Finding Sum (X - 3) from (n - 1) dice plus 3 from nth dice
                  ...................................................
                  ...................................................
                  ...................................................
              + Finding Sum (X - m) from (n - 1) dice plus m from nth dice

So we can recursively write Sum(m, n, x) as following
Sum(m, n, X) = Sum(m, n - 1, X - 1) + 
               Sum(m, n - 1, X - 2) +
               .................... + 
               Sum(m, n - 1, X - m)
Why DP approach?
The above problem exhibits overlapping subproblems. See the below diagram. Also, see this recursive implementation. Let there be 3 dice, each with 6 faces and we need to find the number of ways to get sum 8:

*/
// Java program to find number of ways to get sum 'x' with 'n'
// dice where every dice has 'm' faces

import java.util.*;

public class RollDice {
    

    // The main function that returns number of ways to get sum 'x'
    // with 'n' dice and 'm' with m faces.
    public static int findWays(int m, int n, int x)
    {
    	// Create a table to store results of subproblems. One extra 
    	// row and column are used for simpilicity (Number of dice
    	// is directly used as row index and sum is directly used
    	// as column index). The entries in 0th row and 0th column
    	// are never used.
    	int[][] table = new int[n + 1][x + 1]; // Initialize all entries as 0

    	// Table entries for only one dice
    	for (int j = 1; j <= m && j <= x; j++)
    		table[1][j] = 1;

    	// Fill rest of the entries in table using recursive relation
    	// i: number of dice, j: sum
    	for (int i = 2; i <= n; i++)
    		for (int j = i; j <= x; j++)
    			for (int k = 1; k <= m && k < j; k++)
    				table[i][j] += table[i-1][j-k];

    	//Uncomment these lines to see content of table
    	for (int i = 0; i <= n; i++)
    	{
    	for (int j = 0; j <= x; j++)
    		System.out.print(table[i][j] +  " ");
        System.out.println();
    	}
    	return table[n][x];
    }

    // Driver program to test above functions
    public static void main(String[] args)
    {
    	// System.out.println(findWays(4, 2, 1) );
//         System.out.println(findWays(2, 2, 3) );
//         System.out.println(findWays(6, 3, 8) );
//         System.out.println(findWays(4, 2, 5) );
//         System.out.println(findWays(4, 3, 5) );
        System.out.println(findWays(6, 3, 6) );
        // System.out.println(findWays(6, 2, 3) );
    }
}
/*
Result: 
0
2
21
4
6
*/
