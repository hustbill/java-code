/* Given two numbers represented as strings, return multiplication of the numbers as a string.

Note: The numbers can be arbitrarily large and are non-negative.*/

/* The idea is use array to store the result in reverse order. The 0s at the front need to be deleted.*/

public class Solution {
    public String multiply(String num1, String num2) {
        int len1=num1.length();
        int len2=num2.length();
        if(0==len1 || 0==len2)
            return "0";
        int[] result=new int[len1+len2];
        for(int i=0;i<len1;++i){
            int a=num1.charAt(len1-1-i)-'0';
            int carry=0;
            for(int j=0;j<len2;++j){
                int b=num2.charAt(len2-1-j)-'0';
                result[i+j]+=(a*b+carry);
                carry=result[i+j]/10;
                result[i+j]%=10;
            }
            if(carry>0)
                result[i+len2]+=carry;
        }
        int i=result.length-1;
        while(i>0 && result[i]==0){i--;}
        StringBuilder res=new StringBuilder();
        for(;i>=0;--i){
            res.append((char)(result[i]+'0'));
        }
        return res.toString();
    }
}
