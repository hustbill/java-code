Given an array of integers and a positive integer  k, determine the number of  pairs where (i, j)  and ar[i] +ar[j]  is divisible by k.

**Example**  


**Sample Input**

```
STDIN           Function
-----           --------
6 3             n = 6, k = 3
1 3 2 6 1 2     ar = [1, 3, 2, 6, 1, 2]
```

**Sample Output**

```
 5
```
**Function Description**

Complete the *divisibleSumPairs* function in the editor below.   

divisibleSumPairs has the following parameter(s):  

- *int n:* the length of array 

- *int ar[n]:* an array of integers  
- *int k:* the integer divisor   

**Returns** 
 \-   *int:* the number of pairs  

**Input Format**

The first line 2 contains , space-separated integers,  n and k.   
 The second line contains n   space-separated integers, each a value of arr[i].    

**Constraints**

- 2 <= n <= 100
- 1 <= k <= 100
- 1 <= ar[i] <=100



```java

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'divisibleSumPairs' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER k
     *  3. INTEGER_ARRAY ar
     */

    /*
    (ari + arj ) / k == 0
    brute force sol:  two for loops,  get all sums 
    check each sum in sums , if divisible by k, add count +=1


    Efficient Approach:
    use Hashing technique. 
    We will separate elements into buckets depending on their (value mod K). 
    When a number is divided by K then the remainder may be 0, 1, 2, up to (k-1).
     So take an array to say freq[] of size K (initialized with Zero) 
     and increase the value of freq[A[i]%K] 
     so that we can calculate the number of values giving remainder j 
     on division with K.

    Test Case2:
    5 2
    5 9 10 7 4
    res: 4

    Test case:
    100 96
    34 38 30 27 1 81 37 19 74 73 32 13 44 99 7 88 50 52 32 82 29 1 55 85 89 58 35 19 76 55 45 37 41 74 80 46 38 74 56 18 86 23 57 27 52 9 69 78 52 8 62 85 65 2 11 70 34 26 72 11 20 32 9 75 74 85 29 6 87 81 40 11 31 49 66 91 99 85 18 54 81 93 52 9 72 89 85 66 24 11 85 3 14 36 72 3 76 99 88 8
    res: 65

    */

    public static int divisibleSumPairs(int n, int k, List<Integer> ar) {
        int[] freq = new int[k];
        
        // Count occurrences of all remainders
        for (int i = 0; i < ar.size(); i++) {
            int remainder = ar.get(i) % k;
            freq[remainder]++;
        }
        
        // if all pairs are divisiable by K
        int sum = freq[0] * (freq[0] - 1) / 2;  // eg. [3, 6]
        
        // count for all i and (k-i) freq pairs
        for (int i = 1; i <= k / 2 && i != k - i; i++) {
            sum += freq[i] * freq[k - i];
        }
        
        // if k is even
        /*
                5 2
                5 9 10 7 4
        freq: 1 1  0 1  0
        k % 2 == 0,
        
        f(0) = 2   f(0) * [f(0) - 1] /2  = 1
        f(1) = 3
        f[k / 2] * (f[k / 2] - 1) / 2 = f(1) * (f(1)  - 1)/2 = 3
        sum = 1 + 3 = 4
        */
        if (k % 2 == 0) {  
            sum += freq[k / 2] * (freq[k / 2] - 1) / 2;
        }
        return sum;
    }
    
    public static int divisibleSumPairs_fifteen_percent(int n, int k, List<Integer> ar) {
        if ( n == 1 || ar == null || ar.size() <=1) return 0;
        
    // Write your code here
        int kCount = 0;  // count of k divisors
        int res = 0;     // count of all pairs which sum is divisiable by k
        List<Integer> list = new ArrayList<>(); // remainders list
        for (int num : ar) {
            int remainder = num % k ;
            if (remainder == 0) {
                kCount++;            
            } else {
                list.add(remainder);
            }
        }
        res += kCount / 2;
        Collections.sort(list);
        int pairCount = twoSum(list, k);
        res += pairCount;
        return res;
    }
    
     private static int twoSum(List<Integer> list, int k) {
        int size = list.size();  
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < size; i++) {
            int item = list.get(i);
            map.put(item, i);
        }
        for (int item : list) {
            if  (map.containsKey(k - item)) {
                count++;
            }
        }
        return count;
    }
    
    // get number of the pair (i,j) sum == k  if no duplicates
    private static int twoSumWithoutDuplicates(List<Integer> list, int k) {
        int lo = 0, hi = list.size() - 1;
        int count = 0;
        while (lo <= hi) {
            int sum = list.get(lo) + list.get(hi);
            if (sum == k) {
                count++;
            } else if (sum < k) {
                lo++;
            } else {
                hi--;
            }
        }
        return count;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> ar = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.divisibleSumPairs(n, k, ar);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

```

