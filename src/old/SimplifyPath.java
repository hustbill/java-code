package old;
/*71. Simplify Path My Submissions Question
Total Accepted: 44962 Total Submissions: 211834 Difficulty: Medium
Given an absolute path for a file (Unix-style), simplify it.

For example,
path = "/home/", => "/home"
path = "/a/./b/../../c/", => "/c" */

import java.util.*;

public class SimplifyPath {
    public  static String simplifyPath(String path) {
        // The main idea is to push to the stack every valid file name (not in {"",".",".."}), popping only if there's smth to pop and we met "..".
           // https://leetcode.com/discuss/22592/java-10-lines-solution-with-stack
        Deque<String> stack = new LinkedList<>();
        Set<String> skip = new HashSet<>(Arrays.asList("..", ".", ""));
        
        for (String dir : path.split("/")) {
            if (dir.equals("..") && !stack.isEmpty()) stack.pop();
            else if (!skip.contains(dir)) stack.push(dir);
        }
        
        String res = "";
        for (String dir : stack) res = "/" + dir + res;
        return res.isEmpty() ? "/" : res;
        
    }
    
    public static void main(String[] args) {
        //String path = "/home/";
        String path = "/a/b/../.././c/";
        String res = simplifyPath(path);
        System.out.printf("res = %s", res);
    }
}
