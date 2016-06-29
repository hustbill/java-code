package dfs;

/*
 * 302. Smallest Rectangle Enclosing Black Pixels
Total Accepted: 5760 Total Submissions: 14382 Difficulty: Hard
An image is represented by a binary matrix with 0 as a white pixel and 1 as a black pixel. The black pixels are connected, i.e., there is only one black region. Pixels are connected horizontally and vertically. Given the location (x, y) of one of the black pixels, return the area of the smallest (axis-aligned) rectangle that encloses all black pixels.

For example, given the following image:

[
  "0010",
  "0110",
  "0100"
]
and x = 0, y = 2,
Return 6.

Hide Company Tags Google
Hide Tags Binary Search

 */
import java.util.*;

//T(m*n), dfs
public class SmallestRactangleEnclosing {

	private int top = Integer.MAX_VALUE, left = Integer.MAX_VALUE, bottom = 0, right = 0;

	public static void main(String[] args) {
		String[] strs = { "0010", "0110", "0100" };
		char[][] image = new char[strs.length][strs[0].length()];
		for (int i = 0; i < strs.length; i++) {
			for (int j = 0; j < strs[0].length(); j++) {
				image[i][j] = strs[i].charAt(j);
			}
		}
		
		SmallestRactangleEnclosing sre = new SmallestRactangleEnclosing();
		int x = 0, y = 2;
		int result = sre.minArea(image, x, y); //6
		System.out.println(result);
	}

	public int minArea(char[][] image, int x, int y) {
		// leetcode oj doesn't check the initial value of image[x][y]. default
		// val is '1'
		// if (image == null || image.length ==0 || image[x][y] == '0') return
		// 0;
		// Ref:
		/*
		 * https://leetcode.com/discuss/68233/java-dfs-solution-and-seeking-for-
		 * a-binary-search-solution DFS or BFS is the intuitive solution for
		 * this problem while the problem is with a tag "binary search". So can
		 * anyone provide a binary search answer. DFS complexity is O(m * n) and
		 * if binary search it would be O(n * lgm + m * lgn)
		 */

		if (image == null || image.length == 0 || image[0].length == 0)
			return 0;

		dfs(image, x, y);
		return (bottom - top + 1) * (right - left + 1);
	}

	public void dfs(char[][] image, int x, int y) {
		int m = image.length, n = image[0].length;
		if (x < 0 || x >= m || y < 0 || y >= n || image[x][y] != '1')
			return;
		image[x][y] = '0';

		top = Math.min(top, x);
		bottom = Math.max(bottom, x);
		left = Math.min(left, y);
		right = Math.max(right, y);

		dfs(image, x - 1, y);
		dfs(image, x, y - 1);
		dfs(image, x + 1, y);
		dfs(image, x, y + 1);
	}

	// T(n*m), S(n+m)
	// bfs

	public int minAreaUsingQueue(char[][] grid, int x, int y) {
		if (grid == null || grid.length == 0 || grid[x][y] == '0')
			return 0;

		bfs(grid, x, y);
		return (bottom - top + 1) * (right - left + 1);
	}

	public void bfs(char[][] grid, int x, int y) {
		int n = grid[0].length;
		Queue<Integer> queue = new LinkedList<>();
		fillQueue(grid, queue, x, y);

		while (!queue.isEmpty()) {
			Integer cur = queue.poll();
			int i = cur / n, j = cur % n;

			fillQueue(grid, queue, i - 1, j);
			fillQueue(grid, queue, i, j - 1);
			fillQueue(grid, queue, i + 1, j);
			fillQueue(grid, queue, i, j + 1);
		}
	}

	public void fillQueue(char[][] grid, Queue<Integer> queue, int x, int y) {
		if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] != '1')
			return;
		grid[x][y] = '0';

		top = Math.min(top, x);
		bottom = Math.max(bottom, x);
		left = Math.min(left, y);
		right = Math.max(right, y);
		queue.offer(x * grid[0].length + y);
	}
}