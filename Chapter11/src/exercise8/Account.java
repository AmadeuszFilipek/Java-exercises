package exercise8;

import java.util.ArrayList;
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

	private String name;
	private int id;
	private double balance;
	private double annualInterestRate;
	private Date dateCreated = new Date();
	private ArrayList<Transaction> transactions = new ArrayList<>();
	
	public Account() {}
	
	public Account(int id, double balance) {
		this.id = id;
		this.balance = balance;
	}
	
	public Account(String name, int id, double balance) {
		this.name = name;
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
	
	public void withdraw(double amount, String description) {
			
		balance -= amount;
		transactions.add(new Transaction('W', amount, balance, description));	
	}
	
	public void deposit(double amount, String description) {
		balance += amount;
		
		transactions.add(new Transaction('D', amount, balance, description));	
	}
	
	public String toString() {
	StringBuilder temp = new StringBuilder();
	
		temp.append(
				"Account owner: " + name +
				"\nAccount id: " + id +
				"\nBalance: " + balance +
				"\nAnnual interest: " + annualInterestRate + 
				"\nCreation date: " + dateCreated.toString()
				);
		temp.append('\n');
		
		for(int i = 0; i < transactions.size(); i++)
			temp.append("\nTransaction ").append(i + 1).append(" :")
			.append('\n').append(transactions.get(i)).append('\n');
			
		 return temp.toString();
	} 
}
