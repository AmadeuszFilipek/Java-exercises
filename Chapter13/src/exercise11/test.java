package exercise11;

public class test {

	public static void main(String[] args) {

		try {
			Octagon oct = new Octagon(1);

			Octagon oct2 = (Octagon) oct.clone();

			System.out.println(oct == oct2);
			System.out.println(oct.compareTo(oct2));
			System.out.println(oct.getClass() == oct.clone().getClass());
			
			System.out.println(oct2.getArea());

		} catch(CloneNotSupportedException e) {
			System.out.println(e);
		}
	}
}
