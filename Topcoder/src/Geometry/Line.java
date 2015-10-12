package Geometry;

/*
 * Represented using equation
 * Ax + By = C
 * 
*/
public class Line {
	double A;
	double B;
	double C;
	
	public Line(double a, double b, double c) {
		A = a;
		B = b;
		C = c;
	}

	double slope() {
		if(B == 0)
			return Integer.MAX_VALUE;
		else
			return -A/B;
	}
	
	static Line linePassingThrough(Point p1, Point p2) {
		double A = p2.y - p1.y;
		double B = p1.x - p2.x;
		double C = A*p1.x + B*p1.y;
		return new Line(A, B, C);
	}
	
	double distOfPoint(Point p) {
		Line l = perpendicularLine(p);
		Point intersection = intersectionPoint(this, l);

		return Point.distanceBetween(p, intersection);
	}
	
	Line perpendicularLine(Point p) {
		double D = (-1*B)*p.x + A*p.y;
		return new Line(-1*B, A, D);
	}

	Point intersectionPoint(Line l1, Line l2) {
		double D = determinant(l1.A, l1.B, l2.A, l2.B);

		if(D == 0) {
			return null;
		}

		double Dx = determinant(l1.C, l1.B, l2.C, l2.B);
		double Dy = determinant(l1.A, l1.C, l2.A, l2.C);

		return new Point((Dx/D), (Dy/D));
	}
	
	boolean passthrough(Point p) {
		return (Math.round((A*p.x + B*p.y - C )) == 0);
	}

	double determinant(double a, double b, double c, double d) {
		return a*d - b*c;
	}
	
	boolean segmentIntersect(Point p1, Point p2,
							Point p3, Point p4) {
		Line l1 = linePassingThrough(p1, p2);
		Line l2 = linePassingThrough(p3, p4);
		Point intersection = intersectionPoint(l1, l2);
		if(intersection == null)
			return false;
		else if(l1.passthrough(intersection) && l2.passthrough(intersection))
			return true;
		
		return false;
	}

	void print() {
		System.out.print("A: " + A + ", ");
		System.out.print("B: " + B + ", ");
		System.out.println("C: " + C);
	}
}
