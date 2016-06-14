package dfs;

import java.util.*;

class UndirectedGraphNode {
	int label;
	List<UndirectedGraphNode> neighbors;

	UndirectedGraphNode(int x) {
		label = x;
		neighbors = new ArrayList<UndirectedGraphNode>();
	}
};

public class CloneGraph {
	
	private HashMap<Integer, UndirectedGraphNode> map = new HashMap<Integer, UndirectedGraphNode>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		// https://leetcode.com/discuss/26988/depth-first-simple-java-solution
		if (node == null)
			return null;

		if (map.containsKey(node.label)) {
			return map.get(node.label);
		}

		UndirectedGraphNode clone = new UndirectedGraphNode(node.label);
		map.put(node.label, clone);

		for (int i = 0; i < node.neighbors.size(); i++) {
			clone.neighbors.add(cloneGraph(node.neighbors.get(i)));
		}
		return clone;
	}
	
	
	public UndirectedGraphNode cloneGraph_dfs(UndirectedGraphNode node) {
		HashMap<Integer, UndirectedGraphNode> map = new HashMap<Integer, UndirectedGraphNode>();
		return dfs(node, map);
	}

	public UndirectedGraphNode dfs(UndirectedGraphNode node, HashMap<Integer, UndirectedGraphNode> map) {
		if (node == null)
			return null;

		if (map.containsKey(node.label)) {
			return map.get(node.label);
		}

		UndirectedGraphNode clone = new UndirectedGraphNode(node.label);
		map.put(node.label, clone);

		for (int i = 0; i < node.neighbors.size(); i++) {
			clone.neighbors.add(dfs(node.neighbors.get(i), map));
		}
		return clone;
	}

}
