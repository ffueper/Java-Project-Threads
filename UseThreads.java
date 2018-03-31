package useThreads;

public class UseThreads {
	
	public static void main(String[] args) {
		
		Bank bank = new Bank();
		
		for(int i=0; i<100; i++) {
			
			TranferExecution r = new TranferExecution(bank, i, 2000);
			
			Thread t = new Thread(r);
			
			t.start();
			
		}

	}

}
