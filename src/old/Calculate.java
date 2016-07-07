package old;
import java.util.*;

public class Calculate {
    public int calculate(String s) {
        if(s==null || s.length()==0) return 0; 
        
        int i=0, num=0, sign=1, res=0; 
        Stack<Integer> stack=new Stack<>();
        
        while(i<s.length()){
            if(Character.isDigit(s.charAt(i))){
                while(i<s.length() && Character.isDigit(s.charAt(i))){
                    num=num*10+s.charAt(i)-'0';
                    i++;
                }
            }
            else{
                switch(s.charAt(i)){
                    case '+':
                    case '-':
                        res+=num*sign; 
                        num=0; 
                        sign=s.charAt(i)=='+'?1:-1; 
                        break;
                    case '(':
                        stack.push(res);
                        stack.push(sign);
                        res=0; 
                        sign=1; 
                        break;
                    case ')':
                        res+=sign*num;
                        num=0; 
                        res*=stack.pop();
                        res+=stack.pop();
                        break;
                }
                i++;
            }
        }
        res+=sign*num; 
        return res;
    }
}