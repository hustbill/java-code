/* You are given a string, S, and a list of words, L, that are all of the same length. Find all starting indices of substring(s) in S that is a concatenation of each word in L exactly once and without any intervening characters.

For example, given:
S: "barfoothefoobarman"
L: ["foo", "bar"]

You should return the indices: [0,9].*/

/* This problem is similar to the minimum window substring. We use one hashmap to record the words need to be found, and 
another hashmap to record the found ones. */

public class Solution {
    public ArrayList<Integer> findSubstring(String S, String[] L) {
        if(null==L || 0==L.length)
            return null;
        int n=L.length,m=L[0].length(),l=S.length();
        ArrayList<Integer> res=new ArrayList<Integer>();
        HashMap<String,Integer> covered=new HashMap<String,Integer>();
        for(int i=0;i<n;++i){
            if(covered.containsKey(L[i]))
                covered.put(L[i],covered.get(L[i])+1);
            else
                covered.put(L[i],1);
        }
        int index=0;
        while(l-index>=n*m){
            HashMap<String,Integer> tmp=new HashMap<String,Integer>(covered);
            for(int j=0;j<n;++j){
                String sub=S.substring(index+j*m,index+(j+1)*m);
                if(tmp.containsKey(sub)){
                    if(1==tmp.get(sub))
                        tmp.remove(sub);
                    else
                        tmp.put(sub,tmp.get(sub)-1);
                }
                else
                    break;
            }
            if(0==tmp.size())
                res.add(index);
            index++;
        }
        return res;
    }
}
