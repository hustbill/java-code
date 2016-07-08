package phone;


/*
0 1 1 0 0
0 1 0 0 0
0 1 0 0 0
0 0 0 1 1
1 1 0 0 1

1 = water
0 = land

The above matrix represents a topographical map of water and land. 
Write an algorithm that returns the average size of the bodies of water in that map. 

In this example, there are three bodies of water:

one of size 4, one of size 3, and one of size 2. The average size would then be 3.

getAverageWaterSize(matrix) -> 3
*/

/*
 grid[][] 
 count of 1 in the matrix

// dfs mark the visited waters

 Follow up questions?  
  If others need use  grid matrix,   what's your solution?

 outside data structure. Persists between invocations of the below methods. 
 OR
 change char[][] grid -> Node[][] grid
 where Node has .value and .visited attributions
 
*/

class Node {
	int x;
	boolean visited;

	public Node(int i) {
		x = i;
	}
	
	public void setVisited() {
		visited = true;
	}
	
	public boolean getVisited() {
		return visited;
	}

}

public class NumOfIsLandVariant {
	static int[] dx = { 1, 0, 0, -1 };
	static int[] dy = { 0, 1, -1, 0 };
	private int m, n;

	private int[][] matrix = { { 0, 1, 1, 0, 0 }, { 0, 1, 0, 0, 0 }, { 0, 1, 0, 0, 0 }, { 0, 0, 0, 1, 1 },
			{ 1, 1, 0, 0, 1 } };

	Node[][] grid = new Node[matrix.length][matrix[0].length];

	public static void main(String[] args) {
		NumOfIsLandVariant nsw = new NumOfIsLandVariant();
		
		for (int i = 0; i < nsw.matrix.length ; i++) {
			for (int j = 0; j < nsw.matrix[0].length ; j++) {	
				nsw.grid[i][j] =  new Node(nsw.matrix[i][j]);
			}
		}

		int num = nsw.numOfWasters(nsw.grid);
		System.out.println("num of waters : " + num);
	}

	private void dfsMark(Node[][] grid, int x, int y) {
		grid[x][y].setVisited(); // mark cell visited

		for (int i = 0; i < 4; i++) {
			int nextX = x + dx[i];
			int nextY = y + dy[i];
			if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < m) {
				if (grid[nextX][nextY].x == 1  && grid[nextX][nextY].getVisited() == false) {
					dfsMark(grid, nextX, nextY);
				}
			}
		}
	}

	public int numOfWasters(Node[][] grid) {
		n = grid.length;

		if (n == 0) {
			return 0;
		}

		m = grid[0].length;
		if (m == 0) {
			return 0;
		}

		int count = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (grid[i][j].getVisited() == false && grid[i][j].x == 1 ) {
					dfsMark(grid, i, j);
					count++;
				}
			}
		}
		return count;
	}

}
