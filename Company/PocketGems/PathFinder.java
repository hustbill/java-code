package PocketGems;

import java.io.*;
import java.util.*;


//class Graph {
//    private Map<String, LinkedHashSet<String>> map = new HashMap<String, LinkedHashSet<String>>();
//
//    public void addEdge(String node1, String node2) {
//    	LinkedHashSet<String> adjacent = map.get(node1);
//        if(adjacent==null) {
//            adjacent = new LinkedHashSet<String>();
//            map.put(node1, adjacent);
//        }
//        adjacent.add(node2);
//    }
//
//    public LinkedList<String> adjacentNodes(String last) {
//        LinkedHashSet<String> adjacent = map.get(last);
//        
//        if(adjacent==null) {
//            return new LinkedList<String>();
//        }
//        return new LinkedList<String>(adjacent);
//    }
//}

public class PathFinder {
    public static void main(String[] args)
            throws FileNotFoundException, IOException {
        String filename = "input_1.txt";
        if (args.length > 0) {
        	filename = args[0];
        }
        
        List<String> answer = parseFile(filename);
        System.out.println(answer);
    }
    
    static List<String> parseFile(String filename)
    		throws FileNotFoundException, IOException {
    	/*
    	 *  Don't modify this function
    	 */
        BufferedReader input = new BufferedReader(new FileReader(filename));
        List<String> allLines = new ArrayList<String>();
        String line;
        while ((line = input.readLine()) != null) {
        	allLines.add(line);
        }
        input.close();

        return parseLines(allLines);    	
    }
    
    static List<String> parseLines(List<String> lines) {
    	/*
    	 * 
    	 *  Your code goes here
    	 *  
    	 */
        Graph graph = new Graph();
  
        String firstLine = lines.get(0).replaceAll(" ", "");
        System.out.printf(" %s ", firstLine);
       
        String start =  firstLine.substring(0,1);
        String  end =   firstLine.substring(1,2);
        System.out.printf(" start = %s,  end = %s", start, end);
    	for (int i=1; i < lines.size(); i++) {
            String[] parts = lines.get(i).split(":");
            String p0 = parts[0].trim();
            if (parts.length > 1 ) {
    			char[] points = parts[1].replaceAll(" ", "").toCharArray();  //B C D

        		for (char c : points) {
        			String p1 = String.valueOf(c);
                    System.out.printf(" %s->%s", p0, p1);
        			graph.addEdge(p0, p1);
        		}
    		} else {
    			graph.addEdge(p0, p0);
    		}
    	}
        LinkedList<String> visited = new LinkedList<String>();
        visited.add(start);
        ArrayList<LinkedList<String>> res = new PathFinder().depthFirst(graph, visited, end);
        
        System.out.print(res.size());
        // for ( LinkedList<String> path : res) {
  //           printPath(path);
  //       }
  List<String> path = res.get(0);
        return path;
    }
    private ArrayList<LinkedList<String>> depthFirst(Graph graph, LinkedList<String> visited , String end) {
           LinkedList<String> nodes = graph.adjacentNodes(visited.getLast());
           ArrayList<LinkedList<String>> res = new ArrayList<LinkedList<String>>();
           System.out.printf(" end = %skk", end);
 
           // check adjacent nodes
           for (String node : nodes) {
               if (visited.contains(node)) {
                   continue;
               }
               if (node.equals(end)) {
                   visited.add(node);
                   printPath(visited);
                   res.add(visited);
                   System.out.printf("res.size() = %d", res.size());
                   visited.removeLast();
                   break;
               }
           }
           for (String node : nodes) {
               if (visited.contains(node) || node.equals(end)) {
                   continue;
               }
               visited.addLast(node);
               depthFirst(graph, visited, end);
               visited.removeLast();
           }
           return res;
        
       }
       
       private static void printPath(LinkedList<String> visited) {
           for (String node : visited) {
               System.out.print(node);
               System.out.print(" ");
           }
           System.out.println();
       }
}