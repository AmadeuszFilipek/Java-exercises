package exercise2;

public class test {

	public static void main(String[] args) {
	
		Person p = new Person("Krzysztof K.", "Sezamkowa 14/10", "123-456-789", "krzysiu.@gmail.com");
		Student s = new Student(p, Student.FRESHMAN);
		
		System.out.println(p + "\n");
		System.out.println(s + "\n");
		
		p.setName("Andrzej D.");
		p.setAddress("Belweder 1");
		
		Employee e = new Employee(p, 1, 9000);
		e.setName("Agnieszka K.");
		
		System.out.println(e);
		
		Faculty f = new Faculty(e, 1, "Faculty of Physics and Applied Computer Science");
		
		System.out.println(f);
		
		e.setName("Janusz");
		
		Staff st = new Staff(e, "Janitor");
		
		System.out.println(st);
		
		
	}
}
