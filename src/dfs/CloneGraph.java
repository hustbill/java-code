/*
 * 133. Clone Graph My Submissions QuestionEditorial Solution
Total Accepted: 69310 Total Submissions: 278633 Difficulty: Medium
Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.


OJ's undirected graph serialization:
Nodes are labeled uniquely.

We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.
As an example, consider the serialized graph {0,1,2#1,2#2,2}.

The graph has a total of three nodes, and therefore contains three parts as separated by #.

First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
Second node is labeled as 1. Connect node 1 to node 2.
Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
Visually, the graph looks like the following:

       1
      / \
     /   \
    0 --- 2
         / \
         \_/
Hide Company Tags Pocket Gems Google Uber Facebook
Hide Tags Depth-first Search Breadth-first Search Graph
Hide Similar Problems (H) Copy List with Random Pointer

 */
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
