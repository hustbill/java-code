/*
 * 359. Logger Rate Limiter My Submissions QuestionEditorial Solution
Total Accepted: 1651 Total Submissions: 2947 Difficulty: Easy
Design a logger system that receive stream of messages along with its timestamps, each message should be printed if and only if it is not printed in the last 10 seconds.

Given a message and a timestamp (in seconds granularity), return true if the message should be printed in the given timestamp, otherwise returns false.

It is possible that several messages arrive roughly at the same time.

Example:

Logger logger = new Logger();

// logging string "foo" at timestamp 1
logger.shouldPrintMessage(1, "foo"); returns true; 

// logging string "bar" at timestamp 2
logger.shouldPrintMessage(2,"bar"); returns true;

// logging string "foo" at timestamp 3
logger.shouldPrintMessage(3,"foo"); returns false;

// logging string "bar" at timestamp 8
logger.shouldPrintMessage(8,"bar"); returns false;

// logging string "foo" at timestamp 10
logger.shouldPrintMessage(10,"foo"); returns false;

// logging string "foo" at timestamp 11
logger.shouldPrintMessage(11,"foo"); returns true;
Credits:
Special thanks to @memoryless for adding this problem and creating all test cases.

Hide Company Tags Google
Hide Tags Hash Table Design
Hide Similar Problems (M) Design Hit Counter

 */
package ood;
import java.util.*;

public class Logger {
	
		HashMap<String, Integer> map;
		

	    /** Initialize your data structure here. */
	    public Logger() {
	    	 map = new HashMap<String, Integer>();
	    }
	    
	    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
	        If this method returns false, the message will not be printed.
	        The timestamp is in seconds granularity. */
	    public boolean shouldPrintMessage(int timestamp, String message) {
	        if (map.containsKey(message)) {
	        	if ((timestamp - map.get(message))>= 10 ) {
	        		map.put(message, timestamp);
	        		return true;
	        	} else {
	        		return false;
	        	}
	        } else {
	        	map.put(message, timestamp);
	        	return true;
	        }
	    }
	

	/**
	 * Your Logger object will be instantiated and called as such:
	 * Logger obj = new Logger();
	 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
	 */

	public static void main(String[] args) {
		/**
		 * Your Logger object will be instantiated and called as such:
		 */
		 Logger logger = new Logger();

		// logging string "foo" at timestamp 1
		 boolean param_1 = logger.shouldPrintMessage(1, "foo"); // return true; 
		 System.out.println(param_1);
		 
		// logging string "bar" at timestamp 2
		 boolean param_2 = logger.shouldPrintMessage(2,"bar"); // return true;
		 System.out.println(param_2);

		// logging string "foo" at timestamp 3
		 boolean param_3 = logger.shouldPrintMessage(3,"foo"); // return false;
		 System.out.println(param_3);
		 
		// logging string "bar" at timestamp 8
		 boolean param_4 = logger.shouldPrintMessage(8,"bar"); // return false;
		 System.out.println(param_4);

		// logging string "foo" at timestamp 10
		 boolean param_5 = logger.shouldPrintMessage(10,"foo"); // return false;
		 System.out.println(param_5);

		// logging string "foo" at timestamp 11
		 boolean param_6 = logger.shouldPrintMessage(11,"foo"); // return true;
		 System.out.println(param_6);
		 
		 
		 
		
	}

}
