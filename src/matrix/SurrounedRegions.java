/*
 * 130. Surrounded Regions My Submissions QuestionEditorial Solution
Total Accepted: 55559 Total Submissions: 339215 Difficulty: Medium
Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.

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
X O X X
Hide Tags Breadth-first Search Union Find
Hide Similar Problems (M) Number of Islands (M) Walls and Gates

 */
package matrix;

public class SurrounedRegions {

	public void solve(char[][] board) {
		int m = board.length;
		int n = board[0].length;
		if (m < 2 || n < 2) 
			return;
		
		//Any 'O' connected to a boundary can't be turned to 'X', so ...
		//start from first row to last row, turn 'O' to '*'
		for (int i = 0; i < m; i++) {
			if (board[i][0] == 'O') {
				boundaryDFS(board, i, 0);
			}
			if (board[i][n-1] == 'O') {
				boundaryDFS(board, i, n-1);
			}
		}
        
        // start from first column to last column, turn 'O' to '*'
		for (int j = 0; j < n; j++) {
			if (board[0][j] == 'O') {
				boundaryDFS(board, 0, j);
			}
			if (board[m-1][j] == 'O') {
				boundaryDFS(board, m-1, j);
			}
		}
        
		// post-processing, turn 'O' to 'X', '*' back to 'O',  keep 'X' intact.
		for (int i= 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j] == 'O') {
					board[i][j] = 'X';
				} else if (board[i][j] == '*') {
					board[i][j] = 'O';
				}
			}
		}
		
	}

	//Use DFS algo to turn internal however boundary-connected 'O' to '*';
	public void boundaryDFS(char[][] board, int i, int j) {
		if (i < 0 || i > board.length - 1 || j < 0 || j > board[0].length - 1) 
			return;
		
		if (board[i][j] == 'O') {
			board[i][j] = '*';
		}
		
		if (i > 1 && board[i - 1][j] == 'O') {
			boundaryDFS(board, i-1, j);
		}
		
		if (i < board.length - 2 && board[i + 1][j] == 'O') {
			boundaryDFS(board, i+1, j);
		}
		if (j > 1 && board[i][j - 1] == 'O') {
			boundaryDFS(board, i, j - 1);
		}
		if (j < board[0].length - 2 && board[i][j + 1] == 'O') {
			boundaryDFS(board, i, j + 1);
		}	
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] board = { { 'X', 'X', 'X', 'X' }, { 'X', 'O', 'O', 'X' }, { 'X', 'X', 'O', 'X' },
				{ 'X', 'O', 'X', 'X' } };

		SurrounedRegions sr = new SurrounedRegions();
		sr.solve(board);
		sr.printMatrix(board);

	}
	
	public void printMatrix(char[][] board) {
		for (char[] cells : board) {
			System.out.println(" "+ String.valueOf(cells));	
		}
	}

}
