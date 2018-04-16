package exercise8;

public class test {

	public static void main(String[] args) {
		MyStack stack = new MyStack();
		stack.add(new Integer(5));
		stack.add(new Double(5.5));
		
		MyStack stack2 = (MyStack) stack.clone();
		
		// as defined by Object .clone() method contract:
		System.out.println(stack == stack2); // false
		System.out.println(stack.equals(stack2)); // true 
		System.out.println(stack.clone().getClass() == stack.getClass()); // true
		
	}
}
