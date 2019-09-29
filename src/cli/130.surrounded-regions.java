/*
 * @lc app=leetcode id=130 lang=java
 *
 * [130] Surrounded Regions
 *
 * https://leetcode.com/problems/surrounded-regions/description/
 *
 * algorithms
 * Medium (23.69%)
 * Total Accepted:    163.9K
 * Total Submissions: 680.4K
 * Testcase Example:  '[["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]'
 *
 * Given a 2D board containing 'X' and 'O' (the letter O), capture all regions
 * surrounded by 'X'.
 * 
 * A region is captured by flipping all 'O's into 'X's in that surrounded
 * region.
 * 
 * Example:
 * 
 * 
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * 
 * 
 * After running your function, the board should be:
 * 
 * 
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 * 
 * 
 * Explanation:
 * 
 * Surrounded regions shouldn’t be on the border, which means that any 'O' on
 * the border of the board are not flipped to 'X'. Any 'O' that is not on the
 * border and it is not connected to an 'O' on the border will be flipped to
 * 'X'. Two cells are connected if they are adjacent cells connected
 * horizontally or vertically.
 * 
 */
class Solution {
    // using DFS
    /* https://leetcode.com/problems/surrounded-regions/discuss/41633/Java-DFS-%2B-boundary-cell-turning-solution-simple-and-clean-code-commented
     * First, check the four border of the matrix. If there is a element is
     *   'O', alter it and all its neighbor 'O' elements to '*.
     *  Then ,alter all the 'O' to 'X'
     *  At last,alter all the '*' to 'O'
   */
    public void solve(char[][] board) {
        // Edge case 
        if (board.length == 0 || board[0].length == 0) return;
        if (board.length < 3 || board[0].length < 3) return;

        int m = board.length;
        int n = board[0].length;
        
        // Start from first and last column, turn 'O' to '*'
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O')  helper(board, i, 0);
            if (board[i][n - 1] == 'O') helper(board, i, n - 1); 
        }

        // Start from first and last row, turn 'O' to '*'
        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O') helper(board, 0, j);
            if (board[m - 1][j] == 'O') helper(board, m - 1, j);
        }

        // post-processing, turn 'O' to 'X', '*' back to 'O', keep 'X' intact
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X';
                if (board[i][j] == '*') board[i][j] = 'O';
            }
        }

    }

    private void helper(char[][] board, int r, int c) {
        if (r < 0 || c < 0 || r > board.length - 1 || c > board[0].length - 1 
                || board[r][c] != 'O') return;
        board[r][c] = '*';
        helper(board, r + 1, c);
        helper(board, r - 1, c);
        helper(board, r, c + 1);
        helper(board, r, c - 1);
    }

}
