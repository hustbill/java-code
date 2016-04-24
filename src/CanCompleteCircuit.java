public class CanCompleteCircuit {
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        // Reference: https://leetcode.com/discuss/61660/simple-o-n-java-solution-with-comments
        int tank =0, total=0, index=0;
        
        for(int i=0; i< gas.length; i++) {
           int cur = gas[i]-cost[i];
           tank += cur;
           
            if(tank < 0) {  // if tank <0, index can only start from index+1;
                index=i+1;
                tank = 0;
            }
            total +=cur; 
        }
        
        return total < 0 ?  -1 : index;
    }
    
    /*
    public static void main(String[] args) {
        int[] gas = { 16,  20,  50, 45, 30};
        int[] cost = {25,  21,  30, 20, 40};
        
        System.out.println(canCompleteCircuit(gas, cost));
    
    }
    */
}