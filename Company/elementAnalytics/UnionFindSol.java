package elementAnalytics;

import java.util.*;
/*
 * solution from Yazhen 
 * date: 2016/7/12
 */
public class UnionFindSol {
	class DirectedGraphNode {
		int label;
		DirectedGraphNode[] neighbors;
	}
    class UnionFind{
        Map<Integer, Integer> map=new HashMap<>();
        public UnionFind(Set<Integer> set){
            for(int n : set) map.put(n, n);
        }
        public int find(int node){
            int p=map.get(node);
            while(p!=map.get(p)){
                p=map.get(p);
            }
            return p;
        }
        public void union(int p1, int p2){
            map.put(p1, p2);
        }
    }

    public List<List<Integer>> connectedSet2(ArrayList<DirectedGraphNode> nodes) {
        Set<Integer> set=new HashSet<>();
        
        for(DirectedGraphNode node : nodes){
            set.add(node.label);
            for(DirectedGraphNode nb : node.neighbors){
                set.add(nb.label);
            }
        }
        UnionFind uf=new UnionFind(set);
        
        for(DirectedGraphNode node : nodes){
            for(DirectedGraphNode nb : node.neighbors){
                int p1=uf.find(node.label);
                int p2=uf.find(nb.label);
                if(p1!=p2) uf.union(p1, p2);
            }
        }
        return helper(set, uf);
    }
    public List<List<Integer>> helper(Set<Integer> set, UnionFind uf){
        Map<Integer, List<Integer>> map=new HashMap<>();
        for(int node : set){
            int p=uf.find(node);
            if(!map.containsKey(p)) map.put(p, new ArrayList<Integer>());
            map.get(p).add(node);
        }
        
        List<List<Integer>> res=new ArrayList<>();
        for(List<Integer> list : map.values()){
            Collections.sort(list);
            res.add(list);
        }
        return res;
    }
    
}