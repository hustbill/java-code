package unionfind;
// https://www.cs.princeton.edu/~rs/AlgsDS07/01UnionFind.pdf
// http://algs4.cs.princeton.edu/15uf/WeightedQuickUnionPathCompressionUF.java.html
	
/******************************************************************************
 *  Compilation:  javac WeightedQuickUnionPathCompressionUF.java
 *  Execution:  java WeightedQuickUnionPathCompressionUF < input.txt
 *  Dependencies: StdIn.java StdOut.java
 *
 *  Weighted quick-union with path compression.
 *
 ******************************************************************************/

/**
 *  The <tt>WeightedQuickUnionPathCompressionUF</tt> class represents a
 *  union-find data structure.
 *  It supports the <em>union</em> and <em>find</em> operations, along with
 *  methods for determining whether two sites are in the same component
 *  and the total number of components.
 *  <p>
 *  This implementation uses weighted quick union (by size) with full path compression.
 *  Initializing a data structure with <em>N</em> sites takes linear time.
 *  Afterwards, <em>union</em>, <em>find</em>, and <em>connected</em> take
 *  logarithmic time (in the worst case) and <em>count</em> takes constant
 *  time. Moreover, the amortized time per <em>union</em>, <em>find</em>,
 *  and <em>connected</em> operation has inverse Ackermann complexity.
 *  <p>
 *  For additional documentation, see <a href="http://algs4.cs.princeton.edu/15uf">Section 1.5</a> of
 *  <i>Algorithms, 4th Edition</i> by Robert Sedgewick and Kevin Wayne.
 *     
 *  @author Robert Sedgewick
 *  @author Kevin Wayne
 */

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class WeightedQuickUnionPathCompressionUF {
    private int[] parent;  // parent[i] = parent of i
    private int[] size;    // size[i] = number of sites in tree rooted at i
                           // Note: not necessarily correct if i is not a root node
    private int count;     // number of components

    /**
     * Initializes an empty union-find data structure with <tt>N</tt> sites
     * <tt>0</tt> through <tt>N-1</tt>. Each site is initially in its own 
     * component.
     *
     * @param  N the number of sites
     * @throws IllegalArgumentException if <tt>N &lt; 0</tt>
     */
    public WeightedQuickUnionPathCompressionUF(int N) {
        count = N;
        parent = new int[N];
        size = new int[N];
        for (int i = 0; i < N; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    /**
     * Returns the number of components.
     *
     * @return the number of components (between <tt>1</tt> and <tt>N</tt>)
     */
    public int count() {
        return count;
    }
  

    /**
     * Returns the component identifier for the component containing site <tt>p</tt>.
     *
     * @param  p the integer representing one site
     * @return the component identifier for the component containing site <tt>p</tt>
     * @throws IndexOutOfBoundsException unless <tt>0 &le; p &lt; N</tt>
     */
    public int find(int p) {
        validate(p);
        int root = p;
        while (root != parent[root])
            root = parent[root];
        while (p != root) {
            int newp = parent[p];
            parent[p] = root;
            p = newp;
        }
        return root;
    }

   /**
     * Returns true if the the two sites are in the same component.
     *
     * @param  p the integer representing one site
     * @param  q the integer representing the other site
     * @return <tt>true</tt> if the two sites <tt>p</tt> and <tt>q</tt> are in the same component;
     *         <tt>false</tt> otherwise
     * @throws IndexOutOfBoundsException unless
     *         both <tt>0 &le; p &lt; N</tt> and <tt>0 &le; q &lt; N</tt>
     */
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    // validate that p is a valid index
    private void validate(int p) {
        int N = parent.length;
        if (p < 0 || p >= N) {
            throw new IndexOutOfBoundsException("index " + p + " is not between 0 and " + (N-1));  
        }
    }  

    /**
     * Merges the component containing site <tt>p</tt> with the 
     * the component containing site <tt>q</tt>.
     *
     * @param  p the integer representing one site
     * @param  q the integer representing the other site
     * @throws IndexOutOfBoundsException unless
     *         both <tt>0 &le; p &lt; N</tt> and <tt>0 &le; q &lt; N</tt>
     */
    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) return;

        // make smaller root point to larger one
        if (size[rootP] < size[rootQ]) {
            parent[rootP] = rootQ;
            size[rootQ] += size[rootP];
        }
        else {
            parent[rootQ] = rootP;
            size[rootP] += size[rootQ];
        }
        count--;
    }

    /**
     * Reads in a sequence of pairs of integers (between 0 and N-1) from standard input, 
     * where each integer represents some site;
     * if the sites are in different components, merge the two components
     * and print the pair to standard output.
     * 
     * @throws FileNotFoundException 
     */
    public static void main(String[] args) throws FileNotFoundException {
    	String  line = null;
        int N;
		try {
			 BufferedReader in
	    	   = new BufferedReader(new FileReader("/Users/huazhang/git/java-code/common-data-structure/tinyUF.txt"));
			N = Integer.valueOf(in.readLine());
			System.out.println(N);
	        WeightedQuickUnionPathCompressionUF uf = new WeightedQuickUnionPathCompressionUF(N);

	        while ((line = in.readLine())!= null) {
	        	System.out.println(line);
	            int p = Integer.valueOf(line.split("")[0]);
	            int q = Integer.valueOf(line.split("")[2]);
	           // if (uf.connected(p, q)) continue;
	            uf.union(p, q);
	            System.out.println(p + " " + q);
	        }
	        System.out.println(uf.count() + " components");
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}

/* tinyUF.txt
10
4 3
3 8
6 5

9 4
2 1
8 9

5 0
7 2
6 1

1 0
6 7
*/