package Geometry;

public class Point {
	double x;
	double y;
	
	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	static double distanceBetween(Point p1, Point p2) {
		return Math.sqrt(Math.pow(p2.x - p1.x, 2) + 
				Math.pow(p2.y - p1.y, 2));
	}

	static double distanceBetween3D(Point p1, Point p2) {
		return Math.sqrt(Math.pow(p2.x - p1.x, 2) + 
				Math.pow(p2.y - p1.y, 2));
	}
	
	/*
	 * Vector here, is represented by the head
	 * tail is the origin.
	 * 
	*/
	static Point vector(Point src, Point dest) {
		return new Point(dest.x - src.x,
						dest.y - src.y);
	}
	
	double vectorMagnitude() {
		return Math.sqrt(Math.pow(x, 2) + 
				Math.pow(y, 2));
	}
	
	/*
	 * return magnitude of
	 * A X B
	 * Direction is assumed to along z axis
	*/
	static double crossProduct(Point A, Point B) {
		return (A.x*B.y) - (A.y*B.x);
	}
	
	/*
	 * Assuming x2 >= x1
	 * and y2 >= y1
	*/
	boolean liesWithinRange(double x1, double y1,
							double x2, double y2) {
		int x = (int)this.x;
		int y = (int)this.y;
		
		if(x >= x1 && x <= x2 && y >= y1 && y <= y2)
			return true;
		
		return false;
	}
	
	static Point stringToPoint(String line) {
		String[] t = line.split(" ");
		return new Point(Double.parseDouble(t[0]), 
				Double.parseDouble(t[1]));
	}
	
	void print() {
		System.out.print("x: " + x + ", ");
		System.out.println("y: " + y);
	}
}
