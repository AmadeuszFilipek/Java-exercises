package exercise2;

public class Faculty extends Employee {

	private int rank;
	private String faculty;
	
	public Faculty(Employee employee, int rank, String faculty) {
		super(employee, employee.getOffice(), employee.getSalary());
		
		this.rank = rank;
		this.faculty = faculty;
	}
	
	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public String getFaculty() {
		return faculty;
	}

	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}

	public String toString() {
		
		return super.toString() + "\n" + getName() + " is a teacher at faculty: " + faculty +
				" of rank " + rank;
	}
}
