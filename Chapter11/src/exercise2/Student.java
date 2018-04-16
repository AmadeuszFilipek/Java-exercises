package exercise2;

public class Student extends Person {

	private int status; 
	public static final int FRESHMAN = 0;
	public static final int SOPHOMORE = 1;
	public static final int JUNIOR = 2;
	public static final int SENIOR = 3;
	private static final String[] STATUS_NAMES = {"Freshman", "Sophomore", "Junuior", "Senior"};
	
	public Student(Person person, int status) {
		super(person.getName(), person.getAddress(), person.getPhoneNumber(), person.getEmailAddress());
		if (status < 0 || status > 3)
			status = FRESHMAN;		
	
		this.status = status;		
	}
	
	/** use static constants as status arguments */
	public Student(String name, String address, String phoneNumber, String email, int status) {
		super(name, address, phoneNumber, email);
		if (status < 0 || status > 3)
			status = FRESHMAN;		
	
		this.status = status;		
	}
	
	public int getStatus() {
		return status;
	}
	
	public String getStatusName() {
		
		return STATUS_NAMES[status];
	}
	
	public String toString() {
		return super.toString() + "\n" + getName() + " is a " + getStatusName() + " student.";
	}
}
