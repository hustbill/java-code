import java.util.*; 
import java.io.*;

class Graph {
    private Map<String, LinkedHashSet<String>> map = new HashMap<String, LinkedHashSet<String>>();

    public void addEdge(String node1, String node2) {
        LinkedHashSet<String> adjacent = map.get(node1);
        if(adjacent==null) {
            adjacent = new LinkedHashSet<String>();
            map.put(node1, adjacent);
        }
        adjacent.add(node2);
    }


    public LinkedList<String> adjacentNodes(String last) {
        LinkedHashSet<String> adjacent = map.get(last);
        if(adjacent==null) {
            return new LinkedList<String>();
        }
        return new LinkedList<String>(adjacent);
    }
}

public class Search {

    private static final String START = "A";
    private static final String END = "E";
    
    private static Graph readFile(File file)  throws IOException {
        // this graph is directional
        Graph graph = new Graph();
          graph.addEdge("A", "B");
          graph.addEdge("A", "C");
          graph.addEdge("A", "D");
          graph.addEdge("B", "C");
          graph.addEdge("C", "E"); 
          graph.addEdge("D", "B");
         
    	// 从文件in.txt 读取node 数据有问题
    	/*BufferedReader br =  new BufferedReader(new  FileReader(file));
    	String line = null;
        while ((line = br.readLine()) != null) {
           //System.out.println(line);
           String[] parts = line.split(":");
           String p0 = parts[0];  // A
           char[] points = parts[1].replaceAll(" ", "").toCharArray();  //B C D
           for (char c : points) {
               String p1 = String.valueOf(c);
               graph.addEdge(p0, p1);
           }
       }
       br.close();
       */
       return graph;
    }
    
  

    private static HashMap<String, ArrayList<String>> parseLine(String line) {
    	HashMap<String, ArrayList<String>>  res  = new HashMap<String, ArrayList<String>>();
    	String[] result = line.split(":");
    	String key = result[0];
    	String remains = result[1];
    	char[] points = remains.toCharArray();
    	
    	for (char c : points) {
    		String point = String.valueOf(c);
    		ArrayList<String> list = new ArrayList<>();
    		list.add(point);
    		res.put(key, list);
    	}
    	
    	return res;
    	
    }
    
    public static void main(String[] args) throws IOException {
      //use . to get current directory
    	File dir = new File(".");
    	File file = new File(dir.getCanonicalPath() + File.separator + "in.txt");
			
    	Graph graph = readFile(file);
        LinkedList<String> visited = new LinkedList();
          visited.add(START);
          ArrayList<LinkedList<String>> res = new Search().depthFirst(graph, visited);
          
          for ( LinkedList<String> path : res) {
        	  printPath(path);
          }
    }
    
    public static void main2(String[] args) {

    	// this graph is directional
        Graph graph = new Graph();
        
    	//use . to get current directory
    	File dir = new File(".");
    	File file;
		try {
			file = new File(dir.getCanonicalPath() + File.separator + "in.txt");
			//readFile(fin);
			BufferedReader br =  new BufferedReader(new  FileReader(file));
	    	
	    	String line = null;
	    	while ((line = br.readLine()) != null) {
	    		String[] parts = line.split(":");
	    		
	    		String p0 = parts[0];  // A
	    		String bcd =  parts[1].replaceAll(" ", "");
	    		// System.out.print(bcd + "\n");
	    		char[] points = bcd.toCharArray();

	    		for (char c : points) {
	    			String p1 = String.valueOf(c);
	    			//System.out.printf("%s ->  %s ", p0, p1);
	    			graph.addEdge(p0, p1);
	    			
	    		}
	    		
	    		System.out.println();
	    		
	    	}
	    	br.close();
		
	    	
	     
	        LinkedList<String> visited = new LinkedList();
	        visited.add(START);
	        ArrayList<LinkedList<String>> res = new Search().depthFirst(graph, visited);
	        
	   
	          for ( LinkedList<String> path : res) {
	        	  printPath(path);
	          }
	  
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    private ArrayList<LinkedList<String>> depthFirst(Graph graph, LinkedList<String> visited) {
        LinkedList<String> nodes = graph.adjacentNodes(visited.getLast());
        ArrayList<LinkedList<String>> res = new ArrayList<LinkedList<String>>();
 
        // examine adjacent nodes
        for (String node : nodes) {
            if (visited.contains(node)) {
                continue;
            }
            if (node.equals(END)) {
                visited.add(node);
                res.add(visited);
                printPath(visited);
                visited.removeLast();
                break;
            }
        }
        for (String node : nodes) {
            if (visited.contains(node) || node.equals(END)) {
                continue;
            }
            visited.addLast(node);
            depthFirst(graph, visited);
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

