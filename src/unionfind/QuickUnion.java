package unionfind;

/*
 * Quick-union defect
 * 	Trees can get tall.
 *  Find too expensive (could be N steps)
 *  Need to do find to do union
 */
public class QuickUnion {

	private int[] id;
	
	// set id of each object to itself
	public QuickUnion(int N) {
		id = new int[N];
		for (int i = 0; i < N; i++) {
			id[i] = i;
		}
	}
	
	private int root(int i ) {
		while( i != id[i]) {
			i = id [i];  // time proportional to depth of i
		}
		return i;
	}
	
	public boolean find(int p, int q) {
		//return id[p] == id[q];	// 1 operation
		return root(p) == root(q);   // time proportional to depth of p and q
	}
	
	public void unite(int p, int q) { 
		int i = root(p);  // time proportional to depth of p and q
		int j = root(q);
		id[i] = j;
	}




	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
