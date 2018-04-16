package exercise7;

public class test {

	public static void main(String[] args) {
		
		Colorable rec = new MyRectangle2D();
		rec.howToColor();
		
		Object rec2 = new String("1");
																		
		((Colorable)rec2).howToColor(); //Compiles but throws a runtime Exception
		
	}
}
