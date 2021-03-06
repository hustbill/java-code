package unionfind;
/*
 * 出了参考普林斯顿大学算法pdf文件
 * 也可以参考wikipidia 伪代码  见下面注释
 * https://en.wikipedia.org/wiki/Disjoint-set_data_structure
 * 
 * Weighted quick-union analysis

• Find: takes time proportional to depth of p and q.
• Union: takes constant time, given roots.
• Fact: depth is at most lg N. [needs proof]

￼￼￼￼Weighted quick-union with path compression

• Standard implementation: add second loop to root() to set
 • the id of each examined node to the root.
Simpler one-pass variant: make every other node in path point to its grandparent.

Summary		
Algorithm			Worst-case time
Quick-find  		M N
Quick-union			M N
Weighted QU			N + M log N
Path compression 	N + M log N 
Weighted + path		(M + N) lg* N

M union-find ops on a set of N objects

Ex. Huge practical problem.

• 10^10 edges connecting 109 nodes.
• WQUPC reduces time from 3,000 years to 1 minute.
• Supercomputer won't help much. WQUPC on Java cell phone beats QF on supercomputer!
• Good algorithm makes solution possible.

Bottom line.
WQUPC makes it possible to solve problems that could not otherwise be addressed

￼￼Union-find applications
  Network connectivity.
• Percolation.
• Image processing.
• Least common ancestor.
• Equivalence of finite state automata.
• Hinley-Milner polymorphic type inference. 
• Kruskal's minimum spanning tree algorithm. 
• Games (Go, Hex)
• Compiling equivalence statements in Fortran.
 */

/*
 * wiki 上伪代码
 * Pseudocode for the improved MakeSet and Union:

 function MakeSet(x)
     x.parent := x
     x.rank   := 0
 
 function Union(x, y)
     xRoot := Find(x)
     yRoot := Find(y)
     if xRoot == yRoot
         return

     // x and y are not already in same set. Merge them.
     if xRoot.rank < yRoot.rank
         xRoot.parent := yRoot
     else if xRoot.rank > yRoot.rank
         yRoot.parent := xRoot
     else
         yRoot.parent := xRoot
         xRoot.rank := xRoot.rank + 1
         
     //The second improvement, called path compression    
     function Find(x)
     if x.parent != x
        x.parent := Find(x.parent)
     return x.parent
 */

// 
public class WeightedQuickUnion {
	
	private int[] id;
	private int[] sz; 
	
	// set id of each object to itself
	public WeightedQuickUnion(int N) {
		id = new int[N];
		sz = new int[N];
		for (int i = 0; i < N; i++) {
			id[i] = i;
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
	
	public boolean find(int p, int q) {
		//return id[p] == id[q];	// 1 operation
		return root(p) == root(q);   // time proportional to depth of p and q
	}
	
	public void unite(int p, int q) { 
		int i = root(p);  // time proportional to depth of p and q
		int j = root(q);
		
		//id[i] = j;  // quick union
		if (sz[i] < sz[j])  {
			id[i] = j; 
			sz[j] += sz[i];
		} else {
			id[j] = i;
			sz[i] += sz[j];
		}
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Weighted Quick Union");
	}
}
