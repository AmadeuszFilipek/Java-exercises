package Exercises;

import java.util.Scanner;

public class Exercise7 {

	public static void main(String[] args) {
	
		Scanner scanner = new Scanner(System.in);
		Account[] accounts = new Account[10];
		for(int i = 0; i < accounts.length; i++)
			accounts[i] = new Account(i, 100);

		System.out.print("Enter an id: ");
		int id = scanner.nextInt();
		System.out.println();
		
		int control = 0;
		while(control != 4) {
			printControl();
			control = scanner.nextInt();
			
			switch(control) {
			case 1: System.out.println("The balance is: " + accounts[id].getBalance()); break;
			case 2: {
					System.out.print("Enter a withdraw amount: ");
					double withdraw = scanner.nextInt();
					accounts[id].withdraw(withdraw);
					break;
				}
			case 3:  {
					System.out.print("Enter a deposit amount: ");
					double withdraw = scanner.nextInt();
					accounts[id].deposit(withdraw);
					break;
				}
			case 4: System.out.println("Goodbye and have a nice day.");
			default: break;
			}
			
			System.out.println();
		}
		scanner.close();
	}
	
	public static void printControl() {
		System.out.println("Main menu");
		System.out.println("1: check balance");
		System.out.println("2: withdraw");
		System.out.println("3: deposit");
		System.out.println("4: exit");
		System.out.print("Enter a choice: ");
	}
}
