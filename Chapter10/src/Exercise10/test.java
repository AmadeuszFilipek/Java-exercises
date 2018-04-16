package Exercise10;

public class test {

	public static void main(String[] args) {
	
		Queue q = new Queue();
		
		for(int i = 1; i <= 2000; i++)
			q.enqueue(i);
		
		while(!q.empty()) {
			System.out.println(q.dequeue());
		}
			
		
	}

}
