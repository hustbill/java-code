/*
200. Number of Islands
Total Accepted: 41523 Total Submissions: 151640 Difficulty: Medium
Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:

11110
11010
11000
00000
Answer: 1

Example 2:

11000
11000
00100
00011
Answer: 3

Credits:
Special thanks to @mithmatt for adding this problem and creating all test cases.

Hide Company Tags Amazon Microsoft Google Facebook Zenefits
Hide Tags Depth-first Search Breadth-first Search Union Find
Hide Similar Problems (M) Surrounded Regions (M) Walls and Gates (H) Number of Islands II (M) Number of Connected Components in an Undirected Graph
*/

public class NumIslands_200 {
    private static int m;
    private static int n;
    
    public static void main(String[] args) {
        char[][] grid = new char[][]{
            {'1','1','0','0', '0'},
            {'1','1','0','0', '0'},
            {'0','0','1','0', '0'},
            {'0','0','0','1', '1'}
        };
        System.out.printf("%s" , numIslands(grid) == 3 ? 
            "Number of Islands test case success!" : "Number of Islands test case failed!");
    }
    
    public static int numIslands(char[][] grid) {
        // Ref: https://leetcode.com/discuss/34436/very-concise-java-ac-solution
        m = grid.length;
        n = grid[0].length;
        int count = 0;
        
        for (int i=0; i < m; i++) {
            for (int j=0; j < n; j++) {
                if (grid[i][j] == '1') {
                    dfsMarking(grid, i, j);
                    ++count;
                }
            }
        }
        return count;
    }
    
    // mark the explored cell to '0'
    public  static void dfsMarking(char[][] grid, int i, int j) {
        if (i < 0 || j < 0  || i >=m || j >= n || grid[i][j] != '1') return;
        grid[i][j] = '0';
        dfsMarking(grid, i + 1, j);
        dfsMarking(grid, i - 1, j);
        dfsMarking(grid, i , j + 1);
        dfsMarking(grid, i , j - 1);
    }
}