package thread;

public class MultiThreadDemoTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		int val = 1;
		MultiThreadDemo t1 = new MultiThreadDemo(val);
		val++;
		MultiThreadDemo t2 = new MultiThreadDemo(val);
		val++;
		MultiThreadDemo t3 = new MultiThreadDemo(val);
		val++;

		t1.start();
		t1.join();
		t2.start();
		t2.join();
		t3.start();
		t3.join();

	}

}
