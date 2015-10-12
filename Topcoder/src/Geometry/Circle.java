package Geometry;

public class Circle {
	Point centre;
	double radius;
	
	public Circle(Point c, double r) {
		this.centre = c;
		this.radius = r;
	}
	
	static Circle circleThrough(Point a, Point b, Point c) {
		Point p1 = new Point((a.x + b.x)/2, (a.y + b.y)/2);
		Point p2 = new Point((c.x + b.x)/2, (c.y + b.y)/2);

		Line l1 = Line.linePassingThrough(a, b).perpendicularLine(p1);
		Line l2 = Line.linePassingThrough(b, c).perpendicularLine(p2);

		Point centre = l1.intersectionPoint(l1, l2);
		
		double radius = Point.distanceBetween(centre, a);
		Circle circle = new Circle(centre, radius);
		
		return circle;
	}
	
}
