package exercise10;

public class Rectangle extends SimpleGeometricObject implements Comparable<Rectangle> {
		private double width;
		private double height;

		public Rectangle() {
		}

		public Rectangle(
				double width, double height) {
			this.width = width;
			this.height = height;
		}

		public Rectangle(
				double width, double height, String color, boolean filled) {
			this.width = width;
			this.height = height;
			setColor(color);
			setFilled(filled);
		}

		public int compareTo(Rectangle obj) {
			if (this.getArea() > obj.getArea())
				return 1;
			else if(Math.abs(this.getArea() - obj.getArea()) < Math.pow(10, -8))
				return 0;
			
			return -1;
		}
		
		@Override
		public boolean equals(Object obj) {
			if (obj instanceof Rectangle)
				return Math.abs(this.getArea() - ((Rectangle)obj).getArea()) < Math.pow(10, -8);
			
			return false;
		}
		
		/** Return width */
		public double getWidth() {
			return width;
		}

		/** Set a new width */
		public void setWidth(double width) {
			this.width = width;
		}

		/** Return height */
		public double getHeight() {
			return height;
		}

		/** Set a new height */
		public void setHeight(double height) {
			this.height = height;
		}

		/** Return area */
		public double getArea() {
			return width * height;
		}

		/** Return perimeter */
		public double getPerimeter() {
			return 2 * (width + height);
		}
	}
