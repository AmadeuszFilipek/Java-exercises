package Exercise8;

public class test {

	public static void main(String[] args) {
	// TODO Auto-generated method stub

		Fan fan1 = new Fan();
		Fan fan2 = new Fan();
		
		fan1.setSpeed(Fan.FAST);
		fan1.setRadius(10);
		fan1.setColor("yellow");
		fan1.setOn(true);
		
		fan2.setSpeed(Fan.MEDIUM);
		fan2.setOn(false);
		
		System.out.println("Fan1 : " );
		System.out.println(fan1);
		System.out.println();
	
		System.out.println("Fan2: ");
		System.out.println(fan2);
	}
}
