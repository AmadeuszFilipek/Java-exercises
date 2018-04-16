package exercise2;

public class Employee extends Person {

	private int office; 
	private double salary;
	private MyDate dateHired;
	
	public Employee(Person person, int office, double salary) {
		super(person.getName(), person.getAddress(), person.getPhoneNumber(), person.getEmailAddress());
		
		this.salary = salary;
		this.office = office;
		dateHired = new MyDate();
	}
	
	public Employee(String name, String address, String phoneNumber, String email,
									int office, double salary) {
		super(name, address, phoneNumber, email);
		
		this.office = office;
		this.salary = salary;
		dateHired = new MyDate();		
	}
	
	public Employee(String name, String address, String phoneNumber, String email, int office, double salary, MyDate dateHired) {
		super(name, address, phoneNumber, email);
		
		this.office = office;
		this.salary = salary;
		this.dateHired = dateHired;
	}

	public int getOffice() {
		return office;
	}

	public void setOffice(int office) {
		this.office = office;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public MyDate getDateHired() {
		return dateHired;
	}
	
	public String toString() {
		return super.toString() + "\n" + getName() + " is an employee.\n" + getName() + " resides in office number: "
				+ office + "\nSalary: " + salary + "\nHire date: " + dateHired.toString(); 
	}
	
	
}
