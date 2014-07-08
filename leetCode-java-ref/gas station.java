/* There are N gas stations along a circular route, where the amount of gas at station i is gas[i].

You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station
(i+1). You begin the journey with an empty tank at one of the gas stations.

Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.

Note:
The solution is guaranteed to be unique.

/* The solution use two variables sum and total to record current gas and total gas. If sum <0, means if from start
station, the car can not get here. so the start station should change to next station. If total<0, means there is 
not enough gas for travel.*/

public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if(null==gas ||null==cost ||0==gas.length ||0==cost.length ||gas.length!=cost.length)
            return -1;
        int start=0,sum=0,total=0;
        for(int i=0;i<gas.length;++i){
            sum+=gas[i]-cost[i];
            total+=gas[i]-cost[i];
            if(sum<0){
                start=i+1;
                sum=0;
            }
        }
        return total>=0 ? start:-1;
    }
}
