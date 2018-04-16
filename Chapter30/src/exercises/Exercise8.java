package exercises;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Exercise8 {

	private static Account account = new Account();

	public static void main(String[] args) {

		System.out.println("Thread 1\t\tThread 2\t\tBalance");	

		ExecutorService executor = Executors.newFixedThreadPool(2);
		executor.execute(new DepositTask());
		executor.execute(new WithdrawTask());
		executor.shutdown();

	}

	public static class DepositTask implements Runnable {
		public void run(){
			try {
				while(true) {
					account.deposit((int)(Math.random() * 10) + 1);
					Thread.sleep(1000);
				}


			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}

	public static class WithdrawTask implements Runnable {
		public void run() {
			while(true) {
				account.withdraw((int)(Math.random() * 10) + 1 );
			}
		}
	}

	private static class Account {
		//	private static Lock lock = new ReentrantLock();
		//create a condition 
		//	private static Condition newDeposit = lock.newCondition();

		private int balance = 0;

		public int getBalance() {
			return balance;
		}

		public void withdraw(int amount) {
			//lock.lock();
			synchronized(this) {
				try {
					while (balance < amount) {
						System.out.println("\t\t\tWait for a deposit");
						this.wait();
						//newDeposit.await(); // CAUTION : the thread may wait forever if u forget to signal
					}
					balance -= amount;
					System.out.println("\t\t\tWithdraw " + amount + "\t\t" + getBalance());
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					//	lock.unlock();
				}
			}
		}

		public void deposit(int amount) {
			//lock.lock();
			synchronized(this) {
				try {

					balance += amount;
					System.out.println("Deposit " + amount + "\t\t\t\t\t" + getBalance());

					//		newDeposit.signal(); // so i signal the other thread that some money has been deposited
				} finally {
					//		lock.unlock();
					this.notifyAll();
				}
			}
		}
	}
}
