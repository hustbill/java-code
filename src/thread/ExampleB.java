package thread;

public class ExampleB {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreadExample instance = new ThreadExample();
		instance.start();
		
		while (instance.count != 5 ) {
			try {
				Thread.sleep(250);
				
			} catch(InterruptedException exc) {
				exc.printStackTrace();
			}
		}
	}

}
