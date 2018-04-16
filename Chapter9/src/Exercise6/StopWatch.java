package Exercise6;
/** StopWatch
 * --------------------------
 * -startTime: long
 * -stopTime: long
 * --------------------------
 * StopWatch(): StopWatch
 * +start(): void
 * +stop(): void
 * +getElapsedTime(): long
 * --------------------------
 * 
 * @author Amadeusz
 *
 */
public class StopWatch {

	private long startTime;
	private long stopTime;
	
	StopWatch() {}
	
	public void start() {
		startTime = System.nanoTime();
	}
	
	public void stop() {
		stopTime = System.nanoTime();
	}
	
	public long getElapsedTime() {
		return stopTime - startTime;
	}
}
