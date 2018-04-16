package exercise5;

import java.util.ArrayList;
/** Course UML
 * -------------------------------------------
 * -courseName: String
 * -students: ArrayList<String>
 * -numberOfStudents: int
 * -------------------------------------------
 * +Course(courseName: String)
 * +addStudent(student: String): void
 * +getStudents(): String[]
 * +getNumberOfStudents(): int
 * +getCourseName(): String
 * +dropStudent(student: String): void
 * -------------------------------------------
 * 
 * @author Amadeusz
 *
 */
public class Course {
	private String courseName;
	private ArrayList<String> students = new ArrayList<>();
	private int numberOfStudents;

	public Course(String courseName) {
		this.courseName = courseName;
	}

	public void addStudent(String student) {
		students.add(student);
		numberOfStudents++;
	}

	public String[] getStudents() {
		return students.toArray(new String[numberOfStudents]);
	}

	public int getNumberOfStudents() {
		return numberOfStudents;
	}

	public String getCourseName() {
		return courseName;
	}

	public void dropStudent(String student) {
		// Left as an exercise in Programming Exercise 10.9
	}
}