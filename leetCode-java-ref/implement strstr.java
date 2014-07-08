/* Implement strStr().

Returns a pointer to the first occurrence of needle in haystack, or null if needle is not part of haystack.*/

/* Brute force solution: time complexity O(m*n), space complexity O(1). */
public class Solution {
    public String strStr(String haystack, String needle) {
        int lenh=haystack.length();
        int lenn=needle.length();
        if(lenh<lenn)
            return null;
        for(int i=0;i<=lenh-lenn;++i){
            int j=0;
            for(;j<lenn;++j){
                if(haystack.charAt(i+j)!=needle.charAt(j))
                    break;
            }
            if(j==lenn)
                return haystack.substring(i);
        }
        return null;
    }
}

/* KMP algorithm solution: time complexity O(m+n), space complexity O(m). */
public class Solution {
    public String strStr(String haystack, String needle) {
        int lenh=haystack.length();
        int lenn=needle.length();
        if(lenh<lenn)
            return null;
        if(0==lenn)
            return haystack;
        int[] overlay=getOverlay(needle);
        int matchLen=0;
        for(int i=0;i<lenh;++i){
        	while(matchLen>0 && needle.charAt(matchLen)!=haystack.charAt(i)){
        		matchLen=overlay[matchLen-1];
        	}
        	if(needle.charAt(matchLen)==haystack.charAt(i)){
        		matchLen++;
        	}
        	if(matchLen==lenn){
        		return haystack.substring(i-lenn+1);
        	}
        }
        return null;
    }
    public int[] getOverlay(String needle){
        int[] overlay=new int[needle.length()];
        overlay[0]=0;
        for(int i=1;i<needle.length();++i){
            int index=overlay[i-1];
            while(index>0 && needle.charAt(index)!=needle.charAt(i)){
                index=overlay[index-1];
            }
            if(needle.charAt(index)==needle.charAt(i)){
                overlay[i]=index+1;
            }
            else{
                overlay[i]=0;
            }
        }
        return overlay;
    }
}


public String strStr(String haystack, String needle) {
        int lenh=haystack.length();
        int lenn=needle.length();
        if(lenh<lenn)
            return null;
        if(0==lenn)
            return haystack;
        int[] overlay=getOverlay(needle);
        int hindex=0,nindex=0;
        while(hindex<lenh && nindex<lenn){
            if(haystack.charAt(hindex)==needle.charAt(nindex)){
                hindex++;
                nindex++;
            }
            else if(0==nindex){
                hindex++;
            }
            else{
                nindex=overlay[nindex-1];
            }
        }
        if(nindex==lenn)
            return haystack.substring(hindex-nindex);
        else
            return null;
    }
}
