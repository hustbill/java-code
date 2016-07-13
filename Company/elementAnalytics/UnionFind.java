package elementAnalytics;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

class Node {
	int name;
	Node[] neibors;
}

public class UnionFind {
	int[] parent ;
	int[] size;

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
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
