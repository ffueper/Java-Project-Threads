package useThreads;

public class TranferExecution implements Runnable{

	private Bank bank;
	private int accountO;
	private double maxAmount;
	
	
	public TranferExecution(Bank bank, int accountO, double maxAmount) {
		
		this.bank = bank;
		this.accountO = accountO;
		this.maxAmount = maxAmount;
		
	}
	
	public void run() {
		
		try{
			while(true){
				//Selecciono la cuenta de destino de manera aleatoria.
				int accountD = (int)(Math.random()*100);
				//Selecciono la cantidad a transferir de manera aleatoria.
				double amount = Math.random()*maxAmount;
				
				this.bank.transfer(accountO, accountD, amount);
			
				Thread.sleep((int) (Math.random()*10));
			}
			
		}catch (InterruptedException e) {
			
		}
	}

}
