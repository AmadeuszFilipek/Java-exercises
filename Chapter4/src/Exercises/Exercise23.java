package Exercises;

import java.util.Scanner;

public class Exercise23 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		String employeeName;
		int hoursInWeek;
		double hourlyPayRate, federalTax, stateTax;
		
		System.out.print("Enter employee's name: ");
		employeeName = scanner.next();
		
		System.out.print("Enter number of hours worked in a week: ");
		hoursInWeek = scanner.nextInt();
		
		System.out.print("Enter hourly pay rate: ");
		hourlyPayRate = scanner.nextDouble();
		
		System.out.print("Enter federal tax withholding rate: ");
		federalTax = scanner.nextDouble();
		
		System.out.print("Enter state tax withholding rate: ");
		stateTax = scanner.nextDouble();
		scanner.close();
		
		double grossPay = hoursInWeek * hourlyPayRate;
		double federalWithholding = grossPay * federalTax / 100;
		double stateWithholding = grossPay * stateTax / 100;
		double netPay = grossPay - federalWithholding - stateWithholding;
		System.out.printf("Employee Name: %s \n"
									 + "Hours Worked: %d \n"
									 + "Pay Rate: $%.2f \n"
									 + "Gross Pay: $%.2f \n"
									 + "Deductions: \n"
									 + "\tFederal Withholding (%.1f%%): $%.2f \n"
									 + "\tState Withholding (%.1f%%): $%.2f \n"
									 + "\tTotal Deduction: $%.2f \n"
									 + "Net Pay: $%.2f",
			  employeeName,
			  hoursInWeek,
			  hourlyPayRate,
			  grossPay,
			  federalTax, federalWithholding,
			  stateTax, stateWithholding,
			  federalTax + stateTax,
			  netPay
				);
	}
}
