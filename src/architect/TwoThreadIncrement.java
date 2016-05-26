package architect;

class IncrementThread implements Runnable {
	public String threadName;
	public IncrementThread(String name) {
		this.threadName = name;
	}
	public void run() {
		for (int i = 0; i < TwoThreadIncrement.N; i++) {
			System.out.println(threadName + " " + TwoThreadIncrement.counter);
			TwoThreadIncrement.counter++;
		}
	}
}



public class TwoThreadIncrement {

	public static int counter;
	public static int N;
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		N = (args.length > 0 ) ? new Integer(args[0]) : 100;
		Thread T1 = new Thread(new IncrementThread("T1"));
		Thread T2 = new Thread(new IncrementThread("T2"));

		T1.start();  T2.start();
		T1.join();   T2.join();
		System.out.println(counter);
	}

}
