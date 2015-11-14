//T(m*n), dfs
public class Solution {
    int top=Integer.MAX_VALUE, bottom=0, left=Integer.MAX_VALUE, right=0; 
    public int minArea(char[][] grid, int x, int y) {
        if(grid==null || grid.length==0 || grid[x][y]=='0') return 0; 
        //arr[0][0]--top, arr[0][1]--bottom, arr[1][0]--left, arr[1][1]--right
        dfs(grid, x, y);
        return (bottom-top+1)*(right-left+1);
    }
    public void dfs(char[][] grid, int x, int y){
        if(x<0 || x>=grid.length || y<0 || y>=grid[0].length || grid[x][y]!='1') return; 
        grid[x][y]='0';
        
        top=Math.min(top, x);
        bottom=Math.max(bottom, x);
        left=Math.min(left, y);
        right=Math.max(right, y);
        
        dfs(grid, x-1, y);
        dfs(grid, x, y-1);
        dfs(grid, x+1, y);
        dfs(grid, x, y+1);
    }
}

//T(n*m), S(n+m)
//bfs
public class Solution {
    int top=Integer.MAX_VALUE, bottom=0, left=Integer.MAX_VALUE, right=0; 
    public int minArea(char[][] grid, int x, int y) {
        if(grid==null || grid.length==0 || grid[x][y]=='0') return 0; 
        
        bfs(grid, x, y);
        return (bottom-top+1)*(right-left+1);
    }
    public void bfs(char[][] grid, int x, int y){
        int n=grid[0].length; 
        Queue<Integer> queue=new LinkedList<>(); 
        fillQueue(grid, queue, x, y);
        
        while(!queue.isEmpty()){
            Integer cur=queue.poll(); 
            int i=cur/n, j=cur%n; 
            
            fillQueue(grid, queue, i-1, j);
            fillQueue(grid, queue, i, j-1);
            fillQueue(grid, queue, i+1, j);
            fillQueue(grid, queue, i, j+1);
        }
    }
    
    public void fillQueue(char[][] grid, Queue<Integer> queue, int x, int y){
        if(x<0 || x>=grid.length || y<0 || y>=grid[0].length || grid[x][y]!='1') return; 
        grid[x][y]='0'; 
        
        top=Math.min(top, x);
        bottom=Math.max(bottom, x);
        left=Math.min(left, y);
        right=Math.max(right, y);
        queue.offer(x*grid[0].length+y);
    }
}