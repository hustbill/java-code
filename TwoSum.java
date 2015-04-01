// TwoSum.java

/*
Given an array of integers, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

You may assume that each input would have exactly one solution.

Input: numbers={2, 7, 11, 15}, target=9
Output: index1=1, index2=2

test case: 

Input:	[3,2,4], 6
Expected:	2, 3
*/

import java.util.*;

public class TwoSum {
    //Status: Time Limit Exceeded
	public static int[] twoSum0(int[] numbers, int target) {
		int index1=0, index2=0;
		int[] output= new int[2];
		for(int i=0 ; i < numbers.length; i++) {
			for(int j=i+1; j< numbers.length; j++) {
				if ( numbers[i] == target - numbers[j]) {
					index1 = i;
					index2 = j;
				}
			}
		}
		output[0] = index1;
		output[1] = index2;
        
		return output;
    }
	
	// reference:  http://www.lifeincode.net/programming/leetcode-two-sum-3-sum-3-sum-closest-and-4-sum-java/
	/*
		We could reduce the runtime complexity of looking up a value to O(1) using a hash map
		that maps a value to its index.
		*/
	//use hashmap
	public static int[] twoSum(int[] numbers, int target) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i=0; i< numbers.length; i++) {
			map.put(target- numbers[i], i);
		}
		for(int i=0; i< numbers.length; i++) {
			if(map.containsKey(numbers[i])){
				if(map.get(numbers[i]) != i) {
					return new int[] { i+1, map.get(numbers[i])+1};
				}
			}
		}

		return new int[2];
    }

	public static void main(String args[]) {
		int[]  numbers= {0,2,4,6,8,10,12,14,16,18,20,22,24,26,28,30,32,34,36,38,40,42,44,46,48,50,52,54,56,58,60,62,64,66,68,70,72,74,76,78,80,82,84,86,88,90,92,94,96,98,100,102,104,106,108,110,112,114,116,118,120,122,124,126,128,130,132,134,136,138,140,142,144,146,148,150,152,154,156,158,160,162,164,166,168,170,172,174,176,178,180,182,184,186,188,190,192,194,196,198,200,202,204,206,208,210,212,214,216,218,220,222,224,226,228,230,232,234,236,238,240,242,244,246,248,250,252,254,256,258,260,262,264,266,268,270,272,274,276,278,280,282,284,286,288,290,292,294,296,298,300,302,304,306,308,310,312,314,316,318,320,322,324,326,328,330,332,334,336,338,340,342,344,346,348,350,352,354,356,358,360,362,364,366,368,370,372,374,376,378,380,382,384,386,388,390,392,394,396,398,400,402,404,406,408,410,412,414,416,418,420,422,424,426,428,430,432,434,436,438,440,442,444,446,448,450,452,454,456,458,460,462,464,466,468,470,472,474,476,478,480,482,484,486,488,490,492,494,496,498,500,502,504,506,508,510,512,514,516,518,520,522,524,526,528,530,532,534,536,538,540,542,544,546,548,550,552,554,556,558,560,562,564,566,568,570,572,574,576,578,580,582,584,586,588,590,592,594,596,598,600,602,604,606,608,610,612,614,616,618,620,622,624,626,628,630,632,634,636,638,640,642,644,646,648,650,652,654,656,658,660,662,664,666,668,670,672,674,676,678,680,682,684,686,688,690,692,694,696,698,700,702,704,706,708,710,712,714,716,718,720,722,724,726,728,730,732,734,736,738,740,742,744,746,748,750,752,754,756,758,760,762,764,766,768,770,772,774,776,778,780,782,784,786,788,790,792,794,796,798,800,802,804,806,808,810,812,814,816,818,820,822,824,826,828,830,832,834,836,838,840,842,844,846,848,850,852,854,856,858,860,862,864,866,868,870,872,874,876,878,880,882,884,886,888,890,892,894,896,898,900,902,904,906,908,910,912,914,916,918,920,922,924,926,928,930,932,934,936,938,940,942,944,946,948,950,952,954,956,958,960,962,964,966,968,970,972,974,976,978,980,982,984,986,988,990,992,994,996,998,1000,1002,1004,1006,1008,1010,1012,1014,1016,1018,1020,1022,1024,1026,1028,1030,1032,1034,1036,1038,1040,1042,1044,1046,1048,1050,1052,1054,1056,1058,1060,1062,1064,1066,1068,1070,1072,1074,1076,1078,1080,1082,1084,1086,1088,1090,32014,32016,32018,32020,32022,32024,32026,32028,32030,32032,32034,32036,32038,32040,32042,32044};
		int target =18;
		int[] output = new int[2];
		output = twoSum(numbers, target);
		for(int i=0; i< 2; i++)
			System.out.print(String.format("%d ", output[i]));
	}
}