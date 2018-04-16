package Exercise9;

public class test {

	public static void main(String[] args) {

		Course course = new Course("An introduction to Quantum Optics.");
		course.addStudent("Piotrek");
		course.addStudent("Krzysztof");
		course.addStudent("Kamil");
		
		course.dropStudent("Kamil");
		
		String[] students = course.getStudents();
		for(int i = 0; i < course.getNumberOfStudents(); i++)
			System.out.println(students[i]);
	}
}
