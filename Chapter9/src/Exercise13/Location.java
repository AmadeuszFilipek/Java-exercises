package Exercise13;
/** Location UML
 * --------------------
 * +row: int
 * +column: int
 * +maxValue: double
 * --------------------
 * +Location()
 * +Location(row: int, column: int, maxValue: double)
 * +_locateLargest(a: double[][]): Location
 * --------------------
 * @author Amadeusz
 *
 */
public class Location {

	public int row;
	public int column;
	public double maxValue;
	
	public Location() {}
	
	public Location(int row, int column, double maxValue) {
		this.row = row;
		this.column = column;
		this.maxValue = maxValue;
	}
	
	public static Location locateLargest(double[][] a) {
		Location result = new Location(0, 0, a[0][0]);
		for(int i = 0; i < a.length; i++) 
			for(int j = 0; j < a[i].length; j++)
				if(a[i][j] > result.maxValue) {
					result.maxValue = a[i][j];
					result.row = i;
					result.column = j;
				}
					
		return result;
	}
}
