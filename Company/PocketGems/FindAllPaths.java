import java.util.*;

public class FindAllPaths {
/*
Ref: http://stackoverflow.com/questions/58306/graph-algorithm-to-find-all-connections-between-two-arbitrary-vertices
Here is a logically better-looking recursive version as compared to the second floor.
*/

private static final String START = "B";
private static final String END = "E";

public static void main(String[] args) {
    // this graph is directional
    Graph graph = new Graph();
    graph.addEdge("A", "B");
    graph.addEdge("A", "C");
    graph.addEdge("B", "A");
    graph.addEdge("B", "D");
    graph.addEdge("B", "E"); // this is the only one-way connection
    graph.addEdge("B", "F");
    graph.addEdge("C", "A");
    graph.addEdge("C", "E");
    graph.addEdge("C", "F");
    graph.addEdge("D", "B");
    graph.addEdge("E", "C");
    graph.addEdge("E", "F");
    graph.addEdge("F", "B");
    graph.addEdge("F", "C");
    graph.addEdge("F", "E");
    List<ArrayList<String>> paths = new ArrayList<ArrayList<String>>();
    String currentNode = START;
    List<String> visited = new ArrayList<String>();
    visited.add(START);
    new Search().findAllPaths(graph, seen, paths, currentNode);
    for(ArrayList<String> path : paths){
        for (String node : path) {
            System.out.print(node);
            System.out.print(" ");
        }
        System.out.println();
    }   
}

private void findAllPaths(Graph graph, List<String> visited, List<ArrayList<String>> paths, String currentNode) {        
    if (currentNode.equals(END)) { 
        paths.add(new ArrayList(Arrays.asList(visited.toArray())));
        return;
    }
    else {
        LinkedList<String> nodes = graph.adjacentNodes(currentNode);    
        for (String node : nodes) {
            if (visited.contains(node)) {
                continue;
            } 
            List<String> temp = new ArrayList<String>();
            temp.addAll(visited);
            temp.add(node);          
            findAllPaths(graph, temp, paths, node);
        }
    }
}
}