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

class UF {
	private int[] id;   // id[i] = parent of i
	private int[] rank;  // rank[i] = rank of subtree rooted at i (cannot be more than 31)
	int count;			// number of components
	
	public UF(int N) {
		count = N;
		id = new int[N];
		rank = new int[N];
		for (int i = 0; i < N; i++) {
			id[i] = i;
			rank[i] = 0;
		}
	}
	
	private int root(int i ) {
		while( i != id[i]) {
			// path compression, make every other node in path point to its grandparent
			id[i] = id[id[i]];   // only one extra line of code from weighted quick union
			i = id [i];  // time proportional to depth of i
		}
		return i;
	}
	
	int find(int p) {
		while (p != id[p]) {
			id[p] = id[id[p]];  // path compression  by halving
			p = id[p];
		}
		return p;
	}
	
	int getCount() {
		return count;
	}
	
	boolean connected(int p, int q) {
		return find(p) == find(q);
	}
	
	void connect(int p, int q) {
		int i = find(p);
		int j = find(q);
		if (i == j ) return ;
		
		if (rank[i] < rank[j]) id[i] = j;
		else if (rank[i] > rank[j]) id[j] = i;
		else {
			id[j] = i;
			rank[i]++;
		}
		count--;
	}
}

public class SurrounedRegions {
	
	public void solve(char[][] board) {

		// solveByDFS(board); // beat 65% java submissions
		solveUnionFind(board);
	}

	public void solveUnionFind(char[][] board) {
		int n = board.length;
		if (n == 0)  return;
		
		int m = board[0].length;
		UF uf = new UF(n*m + 1);
		
		for (int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if ((i == 0 || i == n-1 || j == 0 || j == m -1) && board[i][j] == 'O') {
					// if a 'O' node is on the boundary, connect it to the dummy node
					uf.connect(i * m + j, n * m);
				} else if (board[i][j] == 'O') {
					// connect a 'O' node to its neighbor 'O' nodes 
					if (board[i - 1][j] =='O') 
						uf.connect(i * m + j, (i - 1) * m + j);
					if (board[i + 1][j] =='O') 
						uf.connect(i * m + j, (i + 1) * m + j);
					if (board[i][j - 1] =='O') 
						uf.connect(i * m + j, i * m + j - 1);
					if (board[i][j + 1] =='O') 
						uf.connect(i * m + j, i * m + j + 1);
				}
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (!uf.connected( i*m + j, n * m)) { 
					// if a 'O' node is not connected to the dummy node, it is captured
					board[i][j] = 'X';
				}
			}
		}
		
	}

	/*
	 * Java DFS + boundary cell turning solution, simple and clean code,
	 * commented.
	 */
	public void solveByDFS(char[][] board) {
		// https://leetcode.com/discuss/59652/java-boundary-turning-solution-simple-clean-code-commented
		int m = board.length;
		int n = board[0].length;
		if (m < 2 || n < 2)
			return;

		// Any 'O' connected to a boundary can't be turned to 'X', so ...
		// start from first row to last row, turn 'O' to '*'
		for (int i = 0; i < m; i++) {
			if (board[i][0] == 'O') {
				boundaryDFS(board, i, 0);
			}
			if (board[i][n - 1] == 'O') {
				boundaryDFS(board, i, n - 1);
			}
		}

		// start from first column to last column, turn 'O' to '*'
		for (int j = 0; j < n; j++) {
			if (board[0][j] == 'O') {
				boundaryDFS(board, 0, j);
			}
			if (board[m - 1][j] == 'O') {
				boundaryDFS(board, m - 1, j);
			}
		}

		// post-processing, turn 'O' to 'X', '*' back to 'O', keep 'X' intact.
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j] == 'O') {
					board[i][j] = 'X';
				} else if (board[i][j] == '*') {
					board[i][j] = 'O';
				}
			}
		}

	}

	// Use DFS algo to turn internal however boundary-connected 'O' to '*';
	public void boundaryDFS(char[][] board, int i, int j) {
		if (i < 0 || i > board.length - 1 || j < 0 || j > board[0].length - 1)
			return;

		if (board[i][j] == 'O') {
			board[i][j] = '*';
		}

		if (i > 1 && board[i - 1][j] == 'O') {
			boundaryDFS(board, i - 1, j);
		}

		if (i < board.length - 2 && board[i + 1][j] == 'O') {
			boundaryDFS(board, i + 1, j);
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
			System.out.println(" " + String.valueOf(cells));
		}
	}

}
