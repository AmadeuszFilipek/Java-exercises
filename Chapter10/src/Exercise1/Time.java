package Exercise1;
/** Time UML
 * -------------------
 * -hour: long
 * -minute: long
 * -second: long
 * -------------------
 * +Time()
 * +Time(milis: long)
 * +Time(hour: long, minute: long, second: long)
 * +getHour(): long
 * +getMinute(): long
 * +getSecond(): long
 * +setTime(elapseTime: long): void
 * +toString(): String
 * ------------------
 *
 * @author Amadeusz
 *
 */
public class Time {

	private long hour;
	private long minute;
	private long second;
	
	public Time() {
		second = (System.currentTimeMillis() / 1000) % 100;
		minute = System.currentTimeMillis() / 1000 / 60 % 60;
		hour = System.currentTimeMillis() / 1000 / 60 / 60 % 24;
	}
	
	public Time(long milis) {
		second = milis / 1000 % 100;
		minute = milis / 1000 / 60 % 60;
		hour = milis / 1000 / 60 / 60 % 24;		
	}
	
	public Time(long hour, long minute, long second) {
		this.hour = hour;
		this.minute = minute;
		this.second = second;
	}

	public long getHour() {
		return hour;
	}

	public long getMinute() {
		return minute;
	}

	public long getSecond() {
		return second;
	}
	
	public void setTime(long elapseTime) {
		this.second = elapseTime / 1000 % 100;
		this.minute = elapseTime / 1000 / 60 % 60;
		this.hour = elapseTime / 1000 / 60 % 24;
	}
	
	public String toString() {
		return hour + ":" + minute + ":" + second;
	}
}
