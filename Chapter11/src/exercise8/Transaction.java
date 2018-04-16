package exercise8;

import java.util.Date;

public class Transaction {

	private java.util.Date date = new Date();
	private char type;
	
	private double amount;
	private double balance;
	private String description;
	
	public Transaction(char type, double amount, double balance, String description) {
		if (type == 'W' || type == 'D') {
			this.type = type;
			this.amount = amount;
			this.balance = balance;
			this.description = description;
		}
		else {
			this.description = "Incorrect transaction type. No balance change occured.";
			this.type = 'I';
		}
	}
	
	public Date getDate() {
		return date;
	}
	
	public char getType() {
		return type;
	}
	
	public String getTypeName() {
		if(type == 'W')
			return "withdraw";
		else if (type == 'D')
			return "deposit";
		else
			return "incorrect transaction";
	}
	
	public String toString() {
		if (type == 'W' || type == 'D')
		return "Transaction date: " + date.toString() + 
					"\nTransaction type: " + getTypeName() +
					"\nTransaction amount: " + amount +
					"\nAccount balance after transaction: " + balance +
					"\nTransaction description: " + description;
		else 
			return "Transaction date: " + date.toString() + 
							"\n" + description;			
	}
}
