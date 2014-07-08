/* Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.

For example,
X X X X
X O O X
X X O X
X O X X
After running your function, the board should be:

X X X X
X X X X
X X X X
X O X X*/

/* The observation is that all 'O's at the edge are alive, if inside 'O's have path to the edge 'O's, then it is alive.
So the solution is record the position of live 'O's at the edge, then ust BFS to search its neighbors. */

public class Solution {
    public void solve(char[][] board) {
        if(null==board || 0==board.length) return ;
        int m=board.length,n=board[0].length;
        Queue<Integer[]> queue=new LinkedList<Integer[]>();
        for(int i=0;i<m;++i){
            if('O'==board[i][0])
                queue.add(new Integer[]{i,0});
            if('O'==board[i][n-1])
                queue.add(new Integer[]{i,n-1});
        }
        for(int i=1;i<n-1;++i){
            if('O'==board[0][i])
                queue.add(new Integer[]{0,i});
            if('O'==board[m-1][i])
                queue.add(new Integer[]{m-1,i});
        }
        while(queue.size()>0){
            Integer[] cur=queue.remove();
            int x=cur[0];
            int y=cur[1];
            board[x][y]='+';
            if(x>0 && 'O'==board[x-1][y])
                queue.add(new Integer[]{x-1,y});
            if(y>0 && 'O'==board[x][y-1])
                queue.add(new Integer[]{x,y-1});
            if(x<board.length-1 && 'O'==board[x+1][y] )
                queue.add(new Integer[]{x+1,y});
            if(y<board[0].length-1 && 'O'==board[x][y+1])
                queue.add(new Integer[]{x,y+1});
        }
        for(int i=0;i<m;++i){
            for(int j=0;j<n;++j){
                if('+'==board[i][j]) board[i][j]='O';
                else if('O'==board[i][j]) board[i][j]='X';
            }
        }
    }
}
