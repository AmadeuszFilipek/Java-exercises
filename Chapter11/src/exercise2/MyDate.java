package exercise2;
/** MyDate UML
 * --------------------------------------------------
 * -year: int
 * -month: int
 * -day: int
 * --------------------------------------------------
 * +MyDate()
 * +MyDate(milis: long)
 * +MyDate(year: int, month: int, day: int)
 * +getYear(): int
 * +getMonth(): int
 * +getDay(): int
 * +setDate(long elapsedTime): void
 * --------------------------------------------------
 * 
 * 
 * @author Amadeusz
 *
 */
public class MyDate {

	private int year;
	private int month;
	private int day;

	public MyDate() {
		this(System.currentTimeMillis());
	}

	public MyDate(long milis) {
		setDate(milis);
	}

	public MyDate(int year, int month, int day) {
		this.year = year;
		this.month = month;
		this.day = day;
	}

	public int getYear() {
		return year;
	}

	public int getMonth() {
		return month;
	}

	public int getDay() {
		return day;
	}
	
	public void setDate(long elapsedTime) {
		// because using GregorianCalendar is cheating at this point
		int[] daysInMonth = 	  {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		int[] daysInMonthLeap = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		
		year = 1970;
		month = 0;
		day = 1;
		boolean isLeapYear = false;

		long hours = elapsedTime / 1000 / 60 / 60;

		for(long days = 0; days < hours / 24; days++) {
			day++;
			if (!isLeapYear) {
				if(day > daysInMonth[month]) {
					day = 1;
					month++;
					if (month >= 12) {
						month = 0;
						year++;
						isLeapYear = year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
					}
				}
			}
			else {
				if(day > daysInMonthLeap[month]) {
					day = 1;
					month++;
					if (month >= 12) {
						month = 0;
						year++;
						isLeapYear = year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
					}
				}
			}
		}
	}
	
	public String toString() {
		
		return day + " " + month + " " + year;
	}
}
