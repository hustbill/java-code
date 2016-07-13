package elementAnalytics;
import java.util.*;

public class GetSeqNum2 {
	
	public int getSeqNum(int numOfEov, int lifeSpan) {
		
		List<List<Integer>> lists = new ArrayList<List<Integer>>();
		int result = 0;
		int i = 0;
		List<Integer> temp = new ArrayList<>();
		temp.add(0);
		lists.add(temp); // init 
		
		while (i < numOfEov) {
			List<Integer> cur = lists.get(i); //[0]
			List<Integer> newCur = new ArrayList<Integer>();
			
			//for (int j = 0; j <= cur.size(); j++) {
				for(int j = 0; j < cur.size(); j++) {
					// plus one for each ele
					int num = cur.get(j) + 1;
					if (num < lifeSpan) {
						newCur.add(num);
						if (num >= 2) {
							newCur.add(0);
						}
					}
//					cur.set(j, num);
//					cur.remove(j);
//					cur.add(j,num);
					//System.out.println("cur inside" + cur);
				} // [ 0] - > [1]
				
			//}
				Iterator<Integer> iter = cur.iterator();
				while (iter.hasNext()) {
					int num = iter.next();
					if (num >= lifeSpan) {
						iter.remove();
					}
				}
				
//				int count  = 0;
//				for (int num : cur) {
//					if (num >= 2) {
//						count = count + 1;
////						cur.add(0);
//					}
////					if (num >= lifeSpan) {
////						cur.remove (num);  // [3,1,0]  -> [ 2, 1, 0]
////					}
//				}  // [3, 1, 0]
//				
//				for (int j = 0; j < count; j++) {
//					cur.add(0);
//				}

			i++;
			System.out.println(newCur);
			lists.add(newCur); //[[0], [1]]
		}
		
		result = lists.get(lists.size() - 1).size();
		//System.out.println(result);
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		GetSeqNum2 gsn = new GetSeqNum2();
		int numOfEov = 7;
		int lifeSpan = 4;
		System.out.println(gsn.getSeqNum(numOfEov, lifeSpan));

	}

}
