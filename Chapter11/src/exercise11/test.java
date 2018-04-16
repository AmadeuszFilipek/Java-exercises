package exercise11;

public class test {

	public static void main(String[] args) {
	
		
		MyStack stack = new MyStack();
		stack.push("Andreas");
		stack.push("Kalvin");
		stack.push("Tomas");
		stack.push("Karina");
		stack.push("Angelica");
		
		while(!stack.isEmpty())
			System.out.println(stack.pop());
		
		
	}

}
