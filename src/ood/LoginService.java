package ood;

import java.util.*;

interface RateLimiter {
	public boolean allow();
}

public class LoginService {
	Map<Integer, UserRateLimiterImpl> map = new HashMap<>();

	public boolean checkShouldBlock(int uid, int pwd) {
		if (!map.containsKey(uid))
			return false;
		return map.get(uid).allow();
	}
}

class UserRateLimiterImpl implements RateLimiter {
	int userId;
	long lastLogin;
	double interval; // the interval between each login

	public UserRateLimiterImpl(int userId, int interval, int permits){
        this.userId = userId;
        lastLogin = 0;
        this.interval=((double)permits)/(interval*1000); 
    }

	public boolean allow() {
		long curLogin = System.currentTimeMillis();
		if (curLogin - lastLogin >= interval) {
			lastLogin = curLogin;
			return true;
		}
		return false;
	}
}
