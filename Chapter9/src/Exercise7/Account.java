package Exercise7;

import java.util.Date;

/** Account
 * ------------------------------------
 * -id: int
 * -balance: double
 * -annualInterestRate: double
 * -dateCreated: Date
 * ------------------------------------
 * Account()
 * Account(id: int, balance: double)
 * +getId(): int
 * +getBalance(): double
 * +getAnnualInterestRate(): double
 * +getDateCreated(): Date
 * +setId(id: int): void
 * +setBalance(balance: int): void
 * +setAnnualInterestRate(annualInterestRate: double): void
 * +getMonthlyInterestRate(): double
 * +getMonthlyInterest(): double
 * +withdraw(amount: double): boolean
 * +deposit(amount: double): void
 * ------------------------------------
 * 
 * @author Amadeusz
 *
 */
public class Account {

	private int id;
	private double balance;
	private double annualInterestRate;
	private Date dateCreated = new Date();
	
	Account() {}
	
	Account(int id, double balance) {
		this.id = id;
		this.balance = balance;
	}
	
	int getId() { return this.id; }
	void setId(int id) { this.id = id; }
	
	double getBalance() { return this.balance; }
	void setBalance(double balance) { this.balance = balance; }
	
	double getAnnualInterestRate() { return this.annualInterestRate; }
	void setAnnualInterestRate(double annualInterestRate) {
		this.annualInterestRate = annualInterestRate;
	}
	
	Date getDateCreated() { return this.dateCreated; }
	
	double getMonthlyInterestRate() {
		return annualInterestRate / 12 / 100;
	}
	
	double getMonthlyInterest() {
		return balance * getMonthlyInterestRate();
	}
	
	boolean withdraw(double amount) {
		if (balance >= amount) {
			balance -= amount;
			return true;
		}
		return false;
	}
	
	void deposit(double amount) {
		balance += amount;
	}
}
