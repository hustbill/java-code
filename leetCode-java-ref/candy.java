/* There are N children standing in a line. Each child is assigned a rating value.

You are giving candies to these children subjected to the following requirements:

Each child must have at least one candy.
Children with a higher rating get more candies than their neighbors.
What is the minimum candies you must give?*/

/* create a new array to store the candies given to each child. Initialization to 1 candy. Traverse from left to right,
if current rate is greater than previous one, give one more candy. Then traverse from right to left, if current rating
is greater than next one, give one more candy. At last add the array up.*/

public class Solution {
    public int candy(int[] ratings) {
        if(null==ratings || 0==ratings.length)
            return 0;
        int[] candy=new int[ratings.length];
        int minCandy=0;
        //meet the requirement:each child has at least one candy
        for(int i=0;i<candy.length;++i){
            candy[i]=1;
        }
        //left to right
        for(int i=1;i<candy.length;++i){
            if(ratings[i]>ratings[i-1])
                candy[i]=candy[i-1]+1;
        }
        //right to left
        for(int i=candy.length-2;i>=0;--i){
            if(ratings[i]>ratings[i+1] && candy[i]<=candy[i+1])
                candy[i]=candy[i+1]+1;
            minCandy+=candy[i];
        }
        minCandy+=candy[candy.length-1];
        return minCandy;
    }
}

/* DP solution, just traverse once, when current rating is greater than previous one, give one more candy. When the
previous just has 1 candy, also need to give one more candy. */

/*currently cannot pass the large set test.*/

public class Solution {
    public int candy(int[] ratings) {
        if(null==ratings || 0==ratings.length)
            return 0;
        int[] candy=new int[ratings.length];
        candy[0]=1;
        int minCandy=0;
        //meet the requirement:each child has at least one candy
        for(int i=1;i<candy.length;++i){
            if(ratings[i]>ratings[i-1])
                candy[i]=candy[i-1]+1;
            else if(ratings[i]==ratings[i-1])
                candy[i]=1;
            else{
                candy[i]=1;
                if(candy[i-1]==1){
                    int j=i-1;
                    while(j>=0 && ratings[j]>ratings[j+1] &&candy[j]==candy[j+1]){
                        candy[j]++;
                        j--;
                    }
                }
            }
        }
        for(int i=0;i<candy.length;++i){
            minCandy+=candy[i];
        }
        return minCandy;
    }
}
