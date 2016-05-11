import java.util.*;

public class Digraph {
  private final int vertices;
  private int edges;
  private List<LinkedList<Integer>> adj;

  public Digraph(int vertices) {
    if (vertices < 0) throw new IllegalArgumentException (" Number of vertices in a Digraph must be nonnegative");

    this.vertices = vertices;
    this.edges = 0;
     adj = new ArrayList<LinkedList<Integer>>();
     for(int i=0; i < vertices; i++) {
        adj.add(new LinkedList<Integer>());
     }
}
   public void addEdge(int v, int w) {
    if (v < 0 || v >= vertices) 
        throw new IndexOutOfBoundsException("vertex " + v + " not in bound.");
    if (w < 0 || w >= vertices)
 	throw new IndexOutOfBoundsException("vertex " + w + " not in bound.");
     adj.get(v).add(w);
     edges++;
  }
}
