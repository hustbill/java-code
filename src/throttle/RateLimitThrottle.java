package throttle;

public class RateLimitThrottle {
	long time = -1;
	int hits;    // unit: requests
	long period;  // unit: seconds
	
	public void init(int hits, int period) {
		this.hits = hits;
		this.period = period;
	}

	public boolean allowCurrentRequest() {
		int allowance = hits; // unit: messages

		long lastTime = System.currentTimeMillis(); 
		
		while (allowance > 0) {
			long currentTime = System.currentTimeMillis();
			long timeElapsed = (currentTime - lastTime) / 1000;
			lastTime = currentTime;
			allowance += timeElapsed * (hits / period);
			if (allowance > hits) {
				allowance = hits; // throttle
			}
			if (allowance < 1) {
				System.out.println("request times too high");
				return false;
			} else {
				System.out.println("Send login request");
				allowance -= 1;
				return true;
			}
		}
		return false;
	}



	public static void main(String[] args) throws InterruptedException {

		RateLimitThrottle rLimit = new RateLimitThrottle();
		int hits = 2;
		int period = 5;
		rLimit.init(hits, period);
		
		long start = System.currentTimeMillis();
		// System.out.println(rLimit.allowThisRequest()); // request 1 by user1
		System.out.println(rLimit.allowCurrentRequest()); // request 1 by user1
		long elapsed = System.currentTimeMillis() - start;
		Thread.sleep(10 - elapsed); // t + 0.01
		elapsed = System.currentTimeMillis() - start;
	
		System.out.println(rLimit.allowCurrentRequest()); // request 2 by user2

		elapsed = System.currentTimeMillis() - start;
		Thread.sleep(1000 - elapsed); // t + 1
		elapsed = System.currentTimeMillis() - start;
		System.out.println(elapsed);
		System.out.println(rLimit.allowCurrentRequest()); // request 3 by user4

		elapsed = System.currentTimeMillis() - start;
		Thread.sleep(5000 - elapsed); // t + 5
		elapsed = System.currentTimeMillis() - start;
		System.out.println(elapsed);
		System.out.println(rLimit.allowCurrentRequest()); // request 4 by user3
		System.out.println(rLimit.allowCurrentRequest()); // request 4 by user3
		System.out.println(rLimit.allowCurrentRequest()); // request 4 by user3
		
		
	}

}
