//paintHouse1.java 

public class PaintHouse {
    
    
    public static int paint1 (int[][] costs)  {
        
        int m = costs.length;
        int n = costs[0].length; //  colors 3
        
        int[][] dp = new int[m][n];
        
        for ( int j=0; j< n; j++) dp[0][j] = costs[0][j];
        Arrays.fill(dp[i], Integer.MAX_VALUE);
        for(int cur_color =0; cur_color < n; cur_color++) {
            for (int pre_color =0 ; pre_color < n; pre_color++) {
                if ( cur_color  != pre_color) {
                    dp[i][cur_color] = Math.min(dp[i][cur_color], dp[i-1][pre_color]+ costs[i][cur_color]);
                }
            }
        }
        
        // 
        
        int min = Integer.MAX_VALUE;
        for (int n: dp[m-1])  min = Math.min(min, n);
        return min;
        
    }
}


// T (house * color^2)
// S (house * color)