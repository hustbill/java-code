package thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MultiThreadDemo extends Thread {
	int val;
	private Lock lock;

	public MultiThreadDemo(int i) {
		val = i;
		lock = new ReentrantLock();
	}

	public void run() {
		lock.lock();
		 
		 while (val < 100) { 
			int name = val % 3 == 0 ? 3 : val % 3;
			System.out.println("T" + name + " : " + val++);
		}
		lock.unlock();

	}

}
