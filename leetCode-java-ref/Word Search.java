/* Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or 
vertically neighboring. The same letter cell may not be used more than once.

For example,
Given board =

[
  ["ABCE"],
  ["SFCS"],
  ["ADEE"]
]
word = "ABCCED", -> returns true,
word = "SEE", -> returns true,
word = "ABCB", -> returns false.*/


/* The solution is to use DFS search and keep a table to record visited chars.*/

public class Solution {
    public boolean exist(char[][] board, String word) {
        if(null==board || 0==board.length ||0==board[0].length)
            return false;
        boolean[][] visited=new boolean[board.length][board[0].length];
        for(int i=0;i<board.length;++i){
            for(int j=0;j<board[0].length;++j){
                if(find(board,word,0,i,j,visited))
                    return true;
            }
        }
        return false;
    }
    public boolean find(char[][] board, String word, int len, int row, int col,boolean[][] visited){
        if(row<0 || col<0|| row>=board.length || col>=board[0].length || visited[row][col] || board[row][col]!=word.charAt(len))
            return false;
        if(len==word.length()-1)
            return true;
        visited[row][col]=true;
        boolean res=find(board,word,len+1,row-1,col,visited) || find(board,word,len+1,row+1,col,visited)
                    ||find(board,word,len+1,row,col-1,visited) || find(board,word,len+1,row,col+1,visited);
        visited[row][col]=false;
        return res;
    }
}
