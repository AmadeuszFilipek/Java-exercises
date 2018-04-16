package Exercise9;

public class Course {
	private String courseName;
	private String[] students;// = new String[100];
	private int numberOfStudents;
	private static final int BUFFER_SIZE = 16;
	
	public Course(String courseName) {
		this.courseName = courseName;
		students = new String[BUFFER_SIZE];
	}

	public void addStudent(String student) {
		students[numberOfStudents] = student;
		numberOfStudents++;
		if (numberOfStudents >= students.length) {
			String[] temp = new String[students.length * 2];
			System.arraycopy(students, 0, temp, 0, students.length);
			students = temp;
		}			
	}

	public String[] getStudents() {
		return students;
	}

	public int getNumberOfStudents() {
		return numberOfStudents;
	}

	public String getCourseName() {
		return courseName;
	}

	/** There might be more students with a same name, this situation is not handled here */
	public void dropStudent(String student) {
		for(int i = 0; i < numberOfStudents; i++)
			if(students[i] == student) {
				students[i] = null;
				numberOfStudents--;
				break;
			}
	}
	
	public void clear() {
		students = new String[BUFFER_SIZE];
		numberOfStudents = 0;
	}
}