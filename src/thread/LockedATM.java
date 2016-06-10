package thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockedATM extends Thread {
	private Lock lock;
	
	private int balance = 100;
	
	public LockedATM() {
		lock = new ReentrantLock();
	}
	
	public int withdraw(int value) {
		lock.lock();
		int temp = balance;
		try {
			Thread.sleep(100);
			temp = temp - value;
			Thread.sleep(100);
			balance = temp;
			
		} catch(InterruptedException e) {
			System.out.println(e.toString());
		}
		System.out.println("balance: " + balance);
		lock.unlock();
		return temp;
	}
	
	public int deposit(int value) {
		lock.lock();
		int temp = balance;
		try {
			Thread.sleep(100);
			temp = temp + value;
			Thread.sleep(300);
			balance = temp;
			
		} catch(InterruptedException e) {
			System.out.println(e.toString());
		}
		lock.unlock();
		return temp;
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
