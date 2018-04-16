package exercise11;

import java.util.ArrayList;

/**using inheritance instead of composition 
 * 
 * 	MyStack -> ArrayList<Object>
 * ----------------------------------------------
 * +MyStack()
 * +isEmpty(): boolean
 * +getSize(): int
 * +peek(): Object
 * +pop(): Object
 * +push(): Object
 * +toString(): String
 * ----------------------------------------------
 * 
 * @author Amadeusz
 * 
 * */
public class MyStack extends ArrayList<Object> {

	public int getSize() {
		return size();
	}
	
	public Object peek() {
		return get(size() - 1);
	}
	
	public Object pop() {
		Object o = get(size() - 1);
		remove(size() - 1);
		return o;
	}
	
	public void push(Object o) {
		add(o);
	}
	
	@Override
	public String toString() {
		return "stack: " + super.toString();
	}
}
