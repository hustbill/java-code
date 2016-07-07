/*
 * 332. Reconstruct Itinerary
Total Accepted: 12089 Total Submissions: 48765 Difficulty: Medium
Given a list of airline tickets represented by pairs of departure and arrival airports [from, to], reconstruct the itinerary in order. All of the tickets belong to a man who departs from JFK. Thus, the itinerary must begin with JFK.

Note:
If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order when read as a single string. For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
All airports are represented by three capital letters (IATA code).
You may assume all tickets form at least one valid itinerary.
Example 1:
tickets = [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
Return ["JFK", "MUC", "LHR", "SFO", "SJC"].
Example 2:
tickets = [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
Return ["JFK","ATL","JFK","SFO","ATL","SFO"].
Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"]. But it is larger in lexical order.

Credits:
Special thanks to @dietpepsi for adding this problem and creating all test cases.

Hide Company Tags Google
Hide Tags Depth-first Search Graph

 */
package dfs;

import java.util.*;

public class FindItinerary {

	/*
	 * 有向图 欧拉回路 DFS解法， 
	 * 数据结构： HashMap<String, PriorityQueue<Strinig>> flights,  queue记录arrivals
	 * 每次终点 就是下一次的起点
	 *  https://leetcode.com/discuss/84702/share-my-solution
	 * All the airports are vertices and tickets are directed edges. Then all
	 * these tickets form a directed graph.
	 * 
	 * The graph must be Eulerian since we know that a Eulerian path exists.
	 * 
	 * Thus, start from "JFK", we can apply the Hierholzer's algorithm to find a
	 * Eulerian path in the graph which is a valid reconstruction.
	 * 
	 * Since the problem asks for lexical order smallest solution, we can put
	 * the neighbors in a min-heap. In this way, we always visit the smallest
	 * possible neighbor first in our trip.
	 */
	HashMap<String, PriorityQueue<String>> flights;
	LinkedList<String> path;

	public List<String> findItinerary(String[][] tickets) {
		flights = new HashMap<>();
		path = new LinkedList<>();

		for (String[] ticket : tickets) {
			flights.putIfAbsent(ticket[0], new PriorityQueue<String>());
			flights.get(ticket[0]).add(ticket[1]);
		}

		dfs("JFK");
		return path;
	}

	public void dfs(String departure) {
		PriorityQueue<String> arrivals = flights.get(departure);
		while (arrivals != null && !arrivals.isEmpty()) {
			dfs(arrivals.poll()); // 每次终点 就是下一次的起点
		}
		path.addFirst(departure);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[][] tickets = { { "JFK", "SFO" }, { "JFK", "ATL" }, { "SFO", "ATL" }, { "ATL", "JFK" },
				{ "ATL", "SFO" } };
		FindItinerary fi = new FindItinerary();
		List<String> path = fi.findItinerary(tickets);
		System.out.println(path);
	}

}
