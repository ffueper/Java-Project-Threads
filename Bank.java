package useThreads;

import java.util.concurrent.locks.*;

public class Bank {

	private final double[] accounts;
	private Lock bankClose = new ReentrantLock();
	//private Condition balanceEnough;
	
	public Bank() {
		
		accounts = new double[100];
		
		for(int i=0; i<accounts.length; i++) {
			
			accounts[i] = 2000;
		}
		//balanceEnough = bankClose.newCondition();
		
	}
	
	public synchronized void transfer(int accountOrigin, int accountDestination, double amount) throws InterruptedException {
		
		//bankClose.lock();
		
		//try {
			//Evalua que el saldo no es inferior a la cantidad que quiero sacar
			while(accounts[accountOrigin] < amount){
				//balanceEnough.await(); //Deja el hilo en espera
				wait();
			}
			//Imprime el hilo que está haciendo la transferencia.
			System.out.println(Thread.currentThread());
			
			//Descuenta el saldo que sale de la cuenta origen
			accounts[accountOrigin] -= amount;
			
			System.out.printf("%10.2f of %d for %d", amount,accountOrigin,accountDestination);
			
			accounts[accountDestination] += amount;
			
			System.out.printf(" --> Total balance : %10.2f%n", getTotalBalance());
			
			//balanceEnough.signalAll(); //Avisa al hilo en espera
			notifyAll();
		//}finally {
			//bankClose.unlock();
		//}
	}
	
	public double getTotalBalance() {
		
		double sum_accounts = 0;
		
		for(double a : accounts) {
			
			sum_accounts += a;
			
		}
		return sum_accounts;
	}
	
}
