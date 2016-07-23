package throttle;


import java.security.InvalidParameterException;

import junit.framework.TestCase;

import org.junit.Test;

public class TestRateLimit extends TestCase {

	interface RateLimit {
		/** Sets the rate, from 1 to 1000000 queries per second */
		void setQPS(int qps);

		/** accept or reject a request, called when request is received */
		boolean allowThisRequest();
	}

	public static class RateLimitImpl implements RateLimit {

		@Override
		public void setQPS(int qps) {
			if (qps < 1 || qps > 100000) {
				throw new InvalidParameterException(String.format(
						"QPS: %d is not valid", qps));
			}
			this.qps = qps;
			this.serviceTime = 1000.0 / this.qps;
			latestStart = MIN_TIME;
		}

		@Override
		public boolean allowThisRequest() {
			long crtTime = System.currentTimeMillis();
			if (crtTime - latestStart >= serviceTime) {
				latestStart = crtTime; // restart
				// launch a service here
				return true;
			} else {
				return false;
			}
		}

		private long latestStart;
		private int qps;
		private double serviceTime;
		private static long MIN_TIME = -1;
	}

	@Test
	public void testRateQps() throws Exception {
		RateLimit rLimit = new RateLimitImpl();
		rLimit.setQPS(1);

		long start = System.currentTimeMillis();
		assertTrue(rLimit.allowThisRequest()); // request 1 by user1
		long elapsed = System.currentTimeMillis() - start;
		Thread.sleep(10 - elapsed); // t + 0.01
		elapsed = System.currentTimeMillis() - start;
//		assertTrue(elapsed >= 10 && elapsed <= 11);
		assertFalse(rLimit.allowThisRequest()); // request 2 by user2
//
		elapsed = System.currentTimeMillis() - start;
		Thread.sleep(1000 - elapsed); // t + 1
		elapsed = System.currentTimeMillis() - start;
//
//		assertTrue(elapsed >= 1000 && elapsed <= 1001);
		assertTrue(rLimit.allowThisRequest()); // request 3 by user4
//
		elapsed = System.currentTimeMillis() - start;
		Thread.sleep(5000 - elapsed); // t + 5
		elapsed = System.currentTimeMillis() - start;
		System.out.println(elapsed);
		//assertTrue(elapsed >= 5000 && elapsed <= 5001);
		assertTrue(rLimit.allowThisRequest()); // request 4 by user3
	}
}