/* Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.


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
*/

/* use a queue to store all the nodes in BFS
use a hashmap to store the visted nodes.*/

/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(null==node)
            return null;
        Queue<UndirectedGraphNode> queue=new LinkedList<UndirectedGraphNode>();
        HashMap<UndirectedGraphNode,UndirectedGraphNode> map=new HashMap<UndirectedGraphNode,UndirectedGraphNode>();
        queue.add(node);
        UndirectedGraphNode newNode=new UndirectedGraphNode(node.label);
        map.put(node,newNode);
        while(!queue.isEmpty()){
            UndirectedGraphNode cur=queue.remove();
            ArrayList<UndirectedGraphNode> curNei=cur.neighbors;
            for(UndirectedGraphNode neighbor:curNei){
                if(!map.containsKey(neighbor)){
                    UndirectedGraphNode copy=new UndirectedGraphNode(neighbor.label);
                    map.put(neighbor,copy);
                    queue.add(neighbor);
                    map.get(cur).neighbors.add(copy);
                }
                else{
                    map.get(cur).neighbors.add(map.get(neighbor));
                }
            }
        }
        return newNode;
    }
}
