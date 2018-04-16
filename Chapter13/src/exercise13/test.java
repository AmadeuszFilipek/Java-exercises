package exercise13;

import java.util.Arrays;

public class test {

	public static void main(String[] args) {
		
		try {
		Course crs = new Course("kurs j.p.");
		
		crs.addStudent("Krzysztof");
		crs.addStudent("Pszemek");
		
		Course crs2 = (Course) crs.clone();
		
		System.out.println(crs == crs2);
		crs.addStudent("Piotr");
		System.out.println(crs.getStudents() == crs2.getStudents());
		System.out.println(crs.getCourseName() == crs2.getCourseName());
		System.out.println(Arrays.toString(crs2.getStudents()));
		
		} catch(CloneNotSupportedException e) {
			System.out.println(e);
		}
		
	}
}
