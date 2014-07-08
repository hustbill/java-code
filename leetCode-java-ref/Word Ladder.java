/* Given two words (start and end), and a dictionary, find the length of shortest transformation sequence from start to end, such that:

Only one letter can be changed at a time
Each intermediate word must exist in the dictionary
For example,

Given:
start = "hit"
end = "cog"
dict = ["hot","dot","dog","lot","log"]
As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.

Note:
Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.*/

/* The problem can be sovled by using BFS, we use two queues to store the possible word and the length. Once we found 
the match, we return the lenght. It must be the minimum length.*/

public class Solution {
    public int ladderLength(String start, String end, HashSet<String> dict) {
        if(null==dict || start.length()!=end.length())
            return 0;
        Queue<String> words=new LinkedList<String>();
        Queue<Integer> lengths=new LinkedList<Integer>();
        words.add(start);
        lengths.add(1);
        while(!words.isEmpty()){
            String word=words.poll();
            int len=lengths.poll();
            if(word.equals(end))
                return len;
            for(int i=0;i<word.length();++i){
                char[] arr=word.toCharArray();
                for(char c='a';c<='z';++c){
                    if(arr[i]==c)
                        continue;
                    arr[i]=c;
                    String tmp=String.valueOf(arr);
                    if(dict.contains(tmp)){
                        words.add(tmp);
                        lengths.add(len+1);
                        dict.remove(tmp);
                    }
                }
            }
        }
        return 0;
    }
}

/* Follow up: Given two words (start and end), and a dictionary, find all shortest transformation sequence(s) from start to end, such that:

Only one letter can be changed at a time
Each intermediate word must exist in the dictionary
For example,

Given:
start = "hit"
end = "cog"
dict = ["hot","dot","dog","lot","log"]
Return
  [
    ["hit","hot","dot","dog","cog"],
    ["hit","hot","lot","log","cog"]
  ]*/
  
