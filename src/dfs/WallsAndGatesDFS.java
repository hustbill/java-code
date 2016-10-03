public class WallsAndGatesDFS {
    

    // https://discuss.leetcode.com/topic/33459/my-short-java-solution-very-easy-to-understand
    // DFS beat 80%
    public void wallsAndGatesDFS(int[][] rooms) {
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0) helper(rooms, i, j, 0);
            }
        }
    }
    
    public void helper(int[][] rooms, int i, int j, int d) {
        if ( i < 0 || i >= rooms.length ||  j < 0 || j >= rooms[0].length || rooms[i][j] < d)  return;
        rooms[i][j] = d;

        helper(rooms, i - 1, j, d + 1);
        helper(rooms, i + 1, j, d + 1);
        helper(rooms, i, j - 1, d + 1);
        helper(rooms, i, j + 1, d + 1);
    }
    
        // BFS beat 69%
    int[][] dir ={{0,1},{0,-1},{1,0},{-1,0}};
    public void wallsAndGates(int[][] rooms) {
        for(int i=0;i<rooms.length;i++){
            for(int j=0;j<rooms[0].length;j++){
                if(rooms[i][j]==0)
                    bfs(rooms,i,j);
            }
        }
    }
    public void bfs(int[][] rooms,int i,int j){
        for(int[] d:dir){
            if(i+d[0]>=0 && i+d[0]<rooms.length && j+d[1]>=0 && j+d[1]<rooms[0].length && rooms[i+d[0]][j+d[1]]>rooms[i][j]+1){
                rooms[i+d[0]][j+d[1]]=rooms[i][j]+1;
                bfs(rooms,i+d[0],j+d[1]);
            }
        }
    }
}