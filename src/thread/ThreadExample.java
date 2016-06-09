package thread;
import java.util.*;

public class ThreadExample extends Thread {
	int count = 0;

	public void run() {
		System.out.println("Thread starting");
		try{
			while (count < 5) {
				Thread.sleep(500);
				System.out.println("In Thread, count is " + count );
				count++;
			}
		} catch(InterruptedException exc) {
			System.out.println("Thread Interrupted.");
		}
		
		System.out.println("Thread terminating.");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	

}
