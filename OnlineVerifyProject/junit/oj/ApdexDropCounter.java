package oj;

import java.util.ArrayList;
import java.util.List;

class DataPoint {
	public String environment;
	public String service;
	public double val;
	public int ts;

	public DataPoint(String environment, String service, double val, int ts) {
		this.environment = environment;
		this.service = service;
		this.val = val;
		this.ts = ts;
	}
}

public class ApdexDropCounter {

	public int getApdexDropCounter(List<DataPoint> dps) {
		int count = 0;
		boolean isLowerApdex = false;
		
		double preVal = 0.0f;

		for (DataPoint dp : dps) {
			if (dp.val >= 0.99) {
				isLowerApdex = false;
			}
			
			if (dp.val < 0.99) {
				isLowerApdex = true;
			}
			
			if (isLowerApdex && dp.val < preVal) {
				count++; // If dp < preVal, it means the val drop down. Skip count dp.val == preval.
				System.out.printf("\nApdex Drop down at: ts = %d\t val = %f\t\n",dp.ts, dp.val);
			}
			preVal = dp.val; // Save the value for current dp for next round compare
		}
		return count;
	}

	public static void main(String[] args) {
		ApdexDropCounter apc = new ApdexDropCounter();
		double[] dpVals = { 1.0, 1.0, 1.0, 0.90, 0.90, 0.90, 0.99, 1.0, 0.99, 0.87, 0.87, 0.99, 0.99, 0.99, 0.91, 0.91, 0.91,
				0.99, 0.99, 0.99 };
		List<DataPoint> dps = new ArrayList<DataPoint>();
		
		int ts = 0;
		for (int i = 0;  i < dpVals.length; i++) {
		     ts  = 10 * i;
			DataPoint dp = new DataPoint("E1", "S1", dpVals[i], ts);
			System.out.printf("ts = %d\t val = %f\n",dp.ts, dp.val);
			dps.add(dp);
		}
		
		int count = apc.getApdexDropCounter(dps);
		System.out.printf("\nApdex drop down count is %d", count);
	}
}