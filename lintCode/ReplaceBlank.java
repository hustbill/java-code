public class ReplaceBlank {
    /**
     * @param string: An array of Char
     * @param length: The true length of the string
     * @return: The true length of new string
     */
       
    
    public static int replaceBlank(char string[], int length) {
         // refer : http://www.jiuzhang.com/solutions/space-replacement/
        if(0 == length) return 0;
        int num = 0;
        for(int i=0; i<length; i++) {
            if(string[i] == ' ') num++;
        }
        
        int newLen = length + num*2;
        string[newLen] = 0;
        int j = 1;
        
        for(int i=length-1; i>=0; i--) {
            if (string[i] != ' ') {
                string[newLen - j] = string[i];
                j++;
            }
            else {
                string[newLen - j] = '0';
                j++;
                string[newLen - j] = '2';
                j++;
                string[newLen - j] = '%';
                j++;
            }
        }
        return newLen;
    }
   
    public static int replaceBlankMine(char[] string, int length) {
        // Write your code here
        if(0 == length) return 0;
        int newLength = 0;
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i < string.length; i++) {
            if(string[i] == ' ') {
                //string[i] = "%20";
                sb.append("%20");
              
            } else {
                sb.append(string[i]);
            }  
            System.out.print(sb.toString());
            System.out.println();
        }
        
        newLength =  sb.length();
        return newLength;
    }
    
    public static void main(String[] args) {
        // int length = 13;
        // String str = "Mr John Smith                  ";
        int length = 11;
        String str = "hello world          " ;
        
        char[] string = str.toCharArray();
        
        System.out.print(replaceBlank(string, length));
    }
}