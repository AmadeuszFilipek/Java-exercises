package exercise2;

public class Staff extends Employee {

	private String title;
	
	public Staff(Employee employee, String title) {
		super(employee, employee.getOffice(), employee.getSalary());
		
		this.title = title;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String toString() {
		return super.toString() + "\n" + getName() + " is a " + title;
	}
}
