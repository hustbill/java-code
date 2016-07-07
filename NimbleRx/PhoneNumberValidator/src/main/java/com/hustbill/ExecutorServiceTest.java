package com.hustbill;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceTest {

	private static Future taskTwo = null;
	private static Future taskThree = null;
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService executor = Executors.newFixedThreadPool(2);
		
		  List<String> phoneNumbers = new ArrayList<String>();
	        phoneNumbers.add("360-553-2393");  // MOBILE
	        phoneNumbers.add("408.441.8300");  // LANDLINE
	        
	    
	        phoneNumbers.add("202-555-0142");
	        phoneNumbers.add("202-555-0104");
	        phoneNumbers.add("202-555-0197");
	        phoneNumbers.add("202-555-0156");
	        phoneNumbers.add("202-555-0117");
	        phoneNumbers.add("202-555-0169");
	        
	   
		// execute the Runnable
	    Runnable taskOne = new PhoneValidateThread("TaskOne", 2, 100, phoneNumbers );
	    executor.execute(taskOne);
	    for(int i = 0; i < 2; i++) {
	    	// if this task is not created or is canceled or is completed
			if ((taskTwo == null) || (taskTwo.isDone()) || (taskTwo.isCancelled())) {
				// submit a task and return a Future
				taskTwo = executor.submit(new PhoneValidateThread("TaskTwo", 4, 200, phoneNumbers));
			}
	
			if ((taskThree == null) || (taskThree.isDone()) || (taskThree.isCancelled())) {
				taskThree = executor.submit(new PhoneValidateThread("TaskThree", 5, 100, phoneNumbers));
			}
			// if null the task has finished
			if(taskTwo.get() == null) {
				System.out.println(i+1 + ") TaskTwo terminated successfully");
			}
//			else {
//				// if it doesn't finished, cancel it
//				taskTwo.cancel(true);
//			}
			if(taskThree.get() == null) {
				System.out.println(i+1 + ") TaskThree terminated successfully");
			} 
//			else {
//				taskThree.cancel(true);
//			}
	    }
	    executor.shutdown();
	    System.out.println("-----------------------");
	    // wait until all tasks are finished
	    executor.awaitTermination(1, TimeUnit.SECONDS);
	    System.out.println("All tasks are finished!");
	
	}

}
