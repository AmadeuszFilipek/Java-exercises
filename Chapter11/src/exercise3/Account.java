package exercise3;

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
	
	public int getId() { return this.id; }
	public void setId(int id) { this.id = id; }
	
	public double getBalance() { return this.balance; }
	public void setBalance(double balance) { this.balance = balance; }
	
	public double getAnnualInterestRate() { return this.annualInterestRate; }
	public void setAnnualInterestRate(double annualInterestRate) {
		this.annualInterestRate = annualInterestRate;
	}
	
	public Date getDateCreated() { return this.dateCreated; }
	
	public double getMonthlyInterestRate() {
		return annualInterestRate / 12 / 100;
	}
	
	public double getMonthlyInterest() {
		return balance * getMonthlyInterestRate();
	}
	
	public void withdraw(double amount) {
			balance -= amount;
	}
	
	public void deposit(double amount) {
		balance += amount;
	}
	
	public String toString() {
		return "Account id: " + id + "\nBalance: " + balance +
				"\nAnnual interest: " + annualInterestRate + "\nCreation date: " + dateCreated.toString();
	} 
}
