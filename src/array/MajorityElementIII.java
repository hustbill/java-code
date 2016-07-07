package array;

public class MajorityElementIII {

	  public List<Integer> majorityElement(int[] nums) {
	        List<Integer> res=new ArrayList<>();
	        if(nums==null || nums.length==0) return res;
	        
	        Map<Integer, Integer> map=new HashMap<>(3);
	        for(int i=0; i<nums.length; i++){
	            int count=map.containsKey(nums[i])?map.get(nums[i]):0;
	            map.put(nums[i], count+1);
	            
	            if(map.size()==3){
	                for(Iterator<Map.Entry<Integer, Integer>> it=map.entrySet().iterator(); it.hasNext();){
	                    Map.Entry<Integer, Integer> entry=it.next();
	                    if(entry.getValue()==1) it.remove();
	                    else map.put(entry.getKey(), entry.getValue()-1);
	                }
	            }
	        }
	        for(int key : map.keySet()){
	            if(helper(nums,key)) res.add(key);
	        }
	        return res;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean helper(int[] nums, int key){
        int count=0; 
        for(int n : nums) if(n==key) count++;
        return count>nums.length/3;
    }
}
}
