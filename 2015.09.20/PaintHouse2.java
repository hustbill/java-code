// Min


public class PaintHouse2 {
    
    public static void main(String[] args) {
        
    }
    
    
    public static int paint2(int[][] costs) {
        int m = costs.length;
        
        int n = costs[0].length;   // color k
        
        for (int )
    }

}

/*
public class Solution {
    public int minCostII(int[][] costs) {
        if (costs.length == 0 || costs[0].length == 0) return 0; 
        int m=costs.length; 
        int n=costs[0].length; 
        
        int[] last_two_colors=new int[2];
        int[] last_two_costs=new int[2];
        findLastTwo(costs[0], last_two_colors, last_two_costs);
        
        for(int i=1; i<m; i++){
            for(int cur_color=0; cur_color<n; cur_color++){
                if(cur_color!=last_two_colors[0]) costs[i][cur_color]=last_two_costs[0]+costs[i][cur_color];
                else if(cur_color!=last_two_colors[1]) costs[i][cur_color]=last_two_costs[1]+costs[i][cur_color];
            }
            findLastTwo(costs[i], last_two_colors, last_two_costs);
        }
        return last_two_costs[0];
    }
    
    public void findLastTwo(int[] arr, int[] last_two_colors, int[] last_two_costs){
        Arrays.fill(last_two_colors, -1);
        
        for(int i=0; i<arr.length; i++){
            if(last_two_colors[0]==-1 || arr[i]<arr[last_two_colors[0]]){
                last_two_colors[1]=last_two_colors[0];
                last_two_costs[1]=last_two_costs[0];
                last_two_colors[0]=i; 
                last_two_costs[0]=arr[i]; 
            }
            else if(last_two_colors[1]==-1 || arr[i]<arr[last_two_colors[1]]){
                last_two_colors[1]=i; 
                last_two_costs[1]=arr[i];
            }
        }
    }
}

*/