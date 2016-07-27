package ood;


import java.security.InvalidParameterException;

public class LoginRateLimit {
	private long latestStart;
	private int qps;
	private double serviceTime;
	private static long MIN_TIME = -1;

	// sets the rate, from 1 to 1000000 queries per second
	public void setQPS(int qps) {
		if (qps < 1 || qps > 100000) {
			throw new InvalidParameterException(String.format("QPS: %d is not valid", qps));
		}
		this.qps = qps;
		this.serviceTime = 1000.0 / this.qps;
		latestStart = MIN_TIME;
	}

	// accept or reject a request, called when request is received
	public boolean allowThisRequest() {
		long currentTime = System.currentTimeMillis();
		synchronized(this) { 
			if (currentTime - latestStart >= serviceTime) {
				latestStart = currentTime; // restart
				// launch login service here
				return true;
			} else {
				return false;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		LoginRateLimit rLimit = new LoginRateLimit();
		rLimit.setQPS(1); // set QPS = 1

		long start = System.currentTimeMillis();
		System.out.println(0  + " ms, : " + rLimit.allowThisRequest()); // request 1 by user1 , true

		long elapsed = System.currentTimeMillis() - start;
		Thread.sleep(10 - elapsed); // t + 0.01
		elapsed = System.currentTimeMillis() - start;
		System.out.println(elapsed + " ms : " + rLimit.allowThisRequest()); // request 2 by user2, false

		elapsed = System.currentTimeMillis() - start;
		Thread.sleep(1000 - elapsed); // t + 1
		elapsed = System.currentTimeMillis() - start;
		System.out.println(elapsed + " ms : " + rLimit.allowThisRequest()); // request 3 by user3, true

		elapsed = System.currentTimeMillis() - start;
		Thread.sleep(1050 - elapsed); // t + 0.05
		elapsed = System.currentTimeMillis() - start;
		System.out.println(elapsed + " ms : " + rLimit.allowThisRequest()); // request 4 by user4 , false
	}
}

/*
Login Service (backend service)

input: (uid, pwd)
ouput: true/false

Add a new feature:
    within X seconds, Y failure login --> block the user

    5 seconds, 4 failures
|--------------------------------|
 x
  x
       x
        xxxx
0 1    56

[0, 1, 5, 6]

[]
[0]
[0, 1]
....

*/