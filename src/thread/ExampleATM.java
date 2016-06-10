package thread;

public class ExampleATM {
	public static void main(String[] args) {
		LockedATM t1 = new LockedATM();
		LockedATM t2 = new LockedATM();
		LockedATM t3 = new LockedATM();
		
		t1.start();
		t2.start();
		t3.start();
		
		t1.deposit(100);
		t2.deposit(100);
		t3.deposit(100);
		
		t1.withdraw(20);
		t2.withdraw(20);
		t3.withdraw(20);
		
	}
	
}
