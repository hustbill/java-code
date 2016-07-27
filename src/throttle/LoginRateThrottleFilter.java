
package throttle;

import java.io.IOException;
import java.util.Date;
import java.util.Stack;

/**
 * A simple login filter that limits the request rate to a certain threshold
 * of requests per second. The default rate is 4 hits in 5 seconds. 
 */
public class LoginRateThrottleFilter {

	private int hits = 4;

	private int period = 5;

	private static final String HITS = "hits";

	private static final String PERIOD = "period";

	public LoginRateThrottleFilter(int x, int y) {
		hits = x;
		period = y;
	}

	/**
	 * Checks to see if it has exceeded the allowed number of requests in the
	 * specified time period. If the threshold has been exceeded, then a short
	 * error message is written to the output stream and no further processing
	 * is done on the request. Otherwise the request is processed as normal.
	 * 
	 * @param hits
	 * @param period
	 */
	public void doFilter(int hits, int period) {

		Stack<Long> times = new Stack<Long>();
		if (times == null) {
			times = new Stack<	>();
			times.push(new Date(0));

		}
		times.push(new Date());
		if (times.size() >= hits) {
			times.removeElementAt(0);
		}
		Date newest = times.get(times.size() - 1);
		Date oldest = times.get(0);
		long elapsed = newest.getTime() - oldest.getTime();
		if (elapsed < period * 1000) // seconds
		{
			System.out.println("Request rate too high");
			return;
		}
	}
	
	public static void main(String[] args) {
		int hits = 4;
		int period = 5; 
		LoginRateThrottleFilter ltf = new LoginRateThrottleFilter(hits, period);
		Stack<Date>  stack = new  Stack<Date>();
		
		for (int i = 0 ; i < 5; i++) {
			long time = System.currentTimeMillis() ;
			stack.add(time);
		}
		
		
	      

		ltf.doFilter(hits, period);
	}

}
