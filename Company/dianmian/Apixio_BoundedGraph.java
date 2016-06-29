package dianmian;
/*
# Bounded region of a graph that connects 's' to 'e' defined in terms of all
# paths between 's' and 'e'. 's' can have incoming links and 'e' can have
# outgoing edges.  The graph can have cycles in it.  Each node has at most two
# outgoing edges. Additional data-structures and methods may be defined.  
# Do not add new variables in the Node.
# Node has hashCode and equals defined.
#                   +---+         +---+
#             +---->|  g |<--------+ k  +---------+
#             |     +-+-+         +---+         |
#  |   +---+  |       |             ^           |
#--+-->| s +--+       |             |           |
#      +-+-+          v             |           v         ^
#        |          +---+           |         +---+       |
#        +--------->| l  |----------+-------->| e +-------+-->
#  
+---+                     +---+
*/

import java.util.*;


public class Apixio_BoundedGraph {
    public static Node s;
    public static Node e;

    public Apixio_BoundedGraph(Node start, Node end) {
        s = start;
        e = end;
    }

    public static void main(String[] args) {
        
        Node s = new Node();
        s.data = 1;
        
        Node g = new Node();
        g.data = 2;
        g.left = s;
        
        s.right = g;
        
        Node l = new Node();
        l.data = 5;
        l.left = s;
        
        s.right = l;
        g.right = l;
        
        Node k = new Node();
        k.data = 3;
        
        Node e = new Node();
        e.data = 4;
                
        l.right = e;
        l.right = k;
        
        k.left = l;
        k.right = e;
        k.right = g;
            
        Apixio_BoundedGraph bg = new Apixio_BoundedGraph(s, e);
        bg.printGraph();
    }
  
    public static void printGraph() {
        Set<Node> visited = new HashSet<Node>();
        innerPrintGraph(s, e, visited);
    }


    private static void innerPrintGraph(Node s, Node e, Set<Node> visited) {
        if (visited.contains(s)) return;
        System.out.println(s.data);
        visited.add(s);
        if (s.left != null && s != e) 
            innerPrintGraph(s.left, e, visited); 
    }
}

 class Node {
    public Node left;
    public Node right;
    public int data;
}

