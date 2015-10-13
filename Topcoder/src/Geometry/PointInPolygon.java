// Problem from Topcoder
// Incorrect solution
package Geometry;

import java.util.Random;

public class PointInPolygon {

	public String testPoint(String[] vs, int testx, int testy) {
		int n = vs.length;
		Point[] arr = new Point[n];
		Point p = new Point(testx, testy);
		Random r = new Random();
		Point farPoint = new Point(14000, 10500);
		Line l = Line.linePassingThrough(p, farPoint);
		int count = 0;

		for(int i=0; i<n; i++) {
			arr[i] = Point.stringToPoint(vs[i]);
		}
		
		for(int i=0; i<n; i++) {
			Line l2 = Line.linePassingThrough(arr[i], arr[(i + 1)%n]);
			boolean withinRange = p.liesWithinRange(arr[i].x, arr[i].y, arr[(i+1)%n].x, arr[(i+1)%n].y);

			if(l2.passthrough(p) && withinRange) {
				return "BOUNDARY";
			}

			Point intersection = l.intersectionPoint(l, l2);

			intersection.print();
			if(intersection != null && 
					intersection.liesWithinRange(arr[i].x, arr[i].y, arr[(i+1)%n].x, arr[(i+1)%n].y) &&
					intersection.x >= p.x && intersection.y >= p.y) {
				count++;
			}
		}
		System.out.println(count);
		if(count % 2 == 0)
			return "EXTERIOR";
		else
			return "INTERIOR";
	}
	
}
