package old;
// Peernova onsite interview questions

// [ 2, 5, 3, 12, 2, 5, 3, 12, 7, 12, 7]  
// output :  the item which occuar odd times
import java.util.*;

public class OccuarOddTimes {
    
    static final int[] nums = {2, 5, 3, 12, 2, 5, 3, 12, 7, 12, 7};
    
    public static void main(String[] args){
        
        System.out.println(findOddItem(nums));
    }
    
    
    public static int findOddItem(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(Integer num: nums) {
            if(map.containsKey(num)) {
                int val = map.get(num);
                val++;
                int v = map.put(num, val);
                //System.out.println("v=" +v);
            } else {
                map.put(num, 1);
            }
        }
        
        int count =0;
        for (Integer k : map.keySet()) {
            if( map.get(k) % 2 == 1) {
                return k;
            }
        }
        
        return 0;
    }

}