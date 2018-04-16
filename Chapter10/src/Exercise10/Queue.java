package Exercise10;
/** Queue UML
 * ------------------------------
 * -elements: int[]
 * -size: int
 * -_DEFAULT_CAPACITY: int
 * ------------------------------
 * +Queue()
 * +enqueue(v: int): void
 * +dequeue(): int
 * +empty(): boolean
 * +getSize(): int
 * ------------------------------
 *  
 * @author Amadeusz
 *
 */
public class Queue {

	private int[] elements;
	private int size;
	private static final int DEFAULT_CAPACITY = 8;
	
	public Queue() {
		elements = new int[DEFAULT_CAPACITY];
		size = 0;
	}
	
	public void enqueue(int v) {
		elements[size] = v;
		size++;
		//check if the queue is full, and extend it if necessary
		if (size >= elements.length) {
			int[] temp = new int[elements.length * 2];
			System.arraycopy(elements, 0, temp, 0, elements.length);
			elements = temp;
		}
	}
	
	public int dequeue() {
		if (size == 0)
			return 0;
		
		int result = elements[0];
		
		//move all the elements one place to the left
		for(int i = 1; i <= size; i++) {
			elements[i - 1] = elements[i];
		}
		
		size--;
		// check if queue is small enough to let go of some memory resources
		if (size < elements.length / 2) {
			int[] temp = new int[elements.length / 2];
			System.arraycopy(elements, 0, temp, 0, elements.length / 2);
			elements = temp;
		}
		
		return result;
	}	
	
	public boolean empty() {
		return size == 0;
	}
	
	public int getSize() {
		return size;
	}
}

