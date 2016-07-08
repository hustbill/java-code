/*
 * Quick-find defect
 * union too expensive (N steps)
 * Trees are flat, but too expensive to keep them flat.
 */

public class QuickFind {
	private int[] id;
	
	// set id of each object to itself
	public QuickFind(int N) {
		id = new int[N];
		for (int i = 0; i < N; i++) {
			id[i] = i;
		}
	}
	
	public boolean find(int p, int q) {
		return id[p] == id[q];	// 1 operation
	}
	
	public void unite(int p, int q) { // N operations
		int pid = id[p];
		for (int i = 0; i < id.length; i++) {
			if (id[i] == pid) {
				id[i] = id[q];
			}
		}
	}
	
	

}
