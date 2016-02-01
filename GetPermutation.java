/*60. Permutation Sequence
Total Accepted: 47766 Total Submissions: 196320 Difficulty: Medium
The set [1,2,3,…,n] contains a total of n! unique permutations.

By listing and labeling all of the permutations in order,
We get the following sequence (ie, for n = 3):

"123"
"132"
"213"
"231"
"312"
"321"
Given n and k, return the kth permutation sequence.

Note: Given n will be between 1 and 9 inclusive.*/

import java.util.*;

public class GetPermutation {
    
    public static void main(String[] args) {
        int n = 3;
        String res = getPermutation(3, 6);
        System.out.printf("res = %s", res);
    }
    
    public static String getPermutation(int n, int k) {
        /* https://leetcode.com/discuss/42700/explain-like-im-five-java-solution-in-o-n
        {1, 2, 3, 4}  k = 13    k/(n-1)!= 13 /(4-1)! = 13/(4-1)! =13/3! = 13/6= 2.
        1:    234 243 423  /  324 342 432 
        2:    134 143 413  /  314 341 431
        3:    124 142 412  /  214 241 421
        4:    123 132 312  /  213 231 321 */
        int pos = 0;
        List<Integer> numbers = new ArrayList<>();
        int[] factorial = new int[n+1];
        StringBuilder sb = new StringBuilder();
        
        // create an array of factorial lookup
        int sum = 1;
        factorial[0] = 1;
        for ( int i=1; i <= n; i++) {
            sum *= i;
            factorial[i] = sum;
        }
        // factorial[] = { 1, 1, 2, 6, 24, ... , n!}
        
        // create a list of numbers to get indices
        for (int i=1; i <=n; i++) {
            numbers.add(i);
        }
        // numbers = {1, 2, 3,4}
        k--;
        
        for (int i = 1; i <= n; i++) {
            int index = k / factorial[n-i];
            sb.append(String.valueOf(numbers.get(index)));
            numbers.remove(index);
            k -= index * factorial[n-i];
        }
        
        return String.valueOf(sb);
        
    }
    
    public static String getPermutation1(int n, int k) {
        /* https://leetcode.com/discuss/42700/explain-like-im-five-java-solution-in-o-n
            https://leetcode.com/discuss/16064/an-iterative-solution-for-reference
Recursion will use more memory, while this problem can be solved by iteration. I solved this problem before, but I didn't realize that using k = k-1 would avoid dealing with case k%(n-1)!==0. Rewrote this code, should be pretty concise now.

Only thing is that I have to use a list to store the remaining numbers, neither linkedlist nor arraylist are very efficient, anyone has a better idea?

The logic is as follows: for n numbers the permutations can be divided to (n-1)! groups, thus k/(n-1)! indicates the index of current number, and k%(n-1)! denotes remaining sequence (to the right). We keep doing this until n reaches 0, then we get n numbers permutations that is kth.*/
        
        List<Integer> num = new LinkedList<Integer>();
        for (int i =1 ; i <=n; i++) num.add(i);
        
        int [] fact = new int[n]; // factorial
        fact[0] = 1;
        for (int i=1; i < n; i++)  fact[i] = i * fact[i-1];
        
        k = k - 1;
        StringBuilder sb = new StringBuilder();
        
        for( int i = n; i > 0 ; i--) {
            int ind = k /fact[i-1];
            k = k % fact[i-1];
            sb.append(num.get(ind));
            num.remove(ind);
        }
        return sb.toString();
    }
    
    public static String getPermutation_optimal(int n, int k) {
        /* For n numbers, permutations can be divided into n groups with (n-1)! elements
            in each group. Thus, k/(n-1)! is the group index among the current n 
            (to be) sorted groups, and k % (n-1)! is the sequence number k for next iteration*/
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 1; i <= n; i++) list.add(i);
        int fact = 1;
        for (int i=2 ; i <= n; i++)  fact *= i; // factorial
        
        StringBuilder sb = new StringBuilder();
        
        for (k--; n > 0 ; n--) {
            fact /= n;
            sb.append(list.remove(k /fact));
            System.out.printf("sb.toString() = %s \n ", sb.toString());
            k %= fact;
        }
        
        return sb.toString();
    }
    
}