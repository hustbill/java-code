package old;
/*
89. Gray Code
Total Accepted: 57721 Total Submissions: 160293 Difficulty: Medium
The gray code is a binary numeral system where two successive values differ in only one bit.

Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.

For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:

00 - 0
01 - 1
11 - 3
10 - 2
Note:
For a given n, a gray code sequence is not uniquely defined.

For example, [0,2,3,1] is also a valid gray code sequence according to the above definition.

For now, the judge is able to judge based on one instance of gray code sequence. Sorry about that.

Hide Company Tags Amazon
Hide Tags Backtracking

*/
import java.util.*;

public class GrayCode_88 {
    public static void main(String[] args) {
        int n = 2;
        System.out.print(grayCode(n));

        n=3;
        System.out.print(grayCode(n));
    }




    public static List<Integer> grayCode(int n) {
        // ref: https://leetcode.com/discuss/24634/an-accepted-three-line-solution-in-java
        List<Integer> res = new LinkedList<>();
        for (int i = 0; i < 1<<n; i++) 
            res.add(i ^ i>>1);
        return res;
    }

    /*
    The purpose of this function is to convert an unsigned
    binary number to reflected binary Gray code.

    The operator >> is shift right. The operator ^ is exclusive or.
    */
    int binaryToGray( int num)
    {
        return (num >> 1) ^ num;
    }

    /*
    The purpose of this function is to convert a reflected binary
    Gray code number to a binary number.
    */
    int grayToBinary( int num)
    {
        int mask;
        for (mask = num >> 1; mask != 0; mask = mask >> 1)
        {
            num = num ^ mask;
        }
        return num;
    }


    public static List<Integer> grayCode_sol2(int n) {
        // ref: https://leetcode.com/discuss/10068/share-my-solution
        /*
        My idea is to generate the sequence iteratively. For example, when n=3, we can get the result based on n=2. 00,01,11,10 -> (000,001,011,010 ) (110,111,101,100). The middle two numbers only differ at their highest bit, while the rest numbers of part two are exactly symmetric of part one. It is easy to see its correctness. Code is simple:
        */
        List<Integer> res = new ArrayList<>();
        res.add(0);
        for (int i = 0; i < n; i++) {
            int size = res.size();
            for (int k = size -1; k >= 0; k--) {
                res.add(res.get(k) | 1 << i);
                System.out.print(res); // [0, 1][0, 1, 3][0, 1, 3, 2]
            }
        }
        return res;
    
    }

}