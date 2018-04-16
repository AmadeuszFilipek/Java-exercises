package Exercise8;
/** Fan
 * -------------------------------------
 * _SLOW: int
 * _MEDIUM: int
 * _FAST: int
 * -speed: int
 * -on: boolean
 * -radius: double
 * -color: String
 * -------------------------------------
 * +Fan()
 * +getSpeed(): int
 * +isOn(): boolean
 * +getRadius(): double
 * +getColor(): String
 * +setSpeed(newSpeed: int): void
 * +setOn(newOn: boolean): void
 * +setRadius(newRadius: double): void
 * +setColor(newColor: String): void
 * +toString(): String
 * -------------------------------------
 * 
 * @author Amadeusz
 *
 */
public class Fan {

	public static final int SLOW = 1;
	public static final int MEDIUM = 2;
	public static final int FAST = 3;
	
	private int speed = 1;
	private boolean on;
	private double radius = 5;
	private String color = "blue";
	
	public int getSpeed() {
		return speed;
	}
	/** use with static values Fan.SLOW etc. */
	public void setSpeed(int speed) {
		if(speed < Fan.SLOW || speed > Fan.FAST)
			return;
		this.speed = speed;
	}
	public boolean isOn() {
		return on;
	}
	public void setOn(boolean on) {
		this.on = on;
	}
	public double getRadius() {
		return radius;
	}
	public void setRadius(double radius) {
		this.radius = radius;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	public String toString() {
		StringBuilder message = new StringBuilder();

		message.append("Radius: ").append(radius).append("\nColor: ").append(color);	
		
		if(on) {
			message.append("\nSpeed: ");
			switch (speed) {
			case Fan.FAST: message.append("FAST"); break;
			case Fan.MEDIUM: message.append("MEDIUM"); break;
			case Fan.SLOW: message.append("SLOW"); break;
			default: message.append("NONE"); break;
			}
		}
		else
			message.append("\nThe fan is turned off.");
		
		return message.toString();
	}
	
}
