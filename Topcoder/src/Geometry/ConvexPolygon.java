package Geometry;

class ConvexPolygon {
	public double findArea(int[] x, int[] y) {
		int n = x.length;
		
		if(n<3)
			return 0.0;
		
		Point arr[] = new Point[n];
		
		for(int i=0;i<n;i++)
			arr[i] = new Point(x[i], y[i]);

		return area(arr);
	}
	
	public double area(Point[] arr) {
		int n = arr.length;

		Point s = arr[0];
		Point last = arr[1];
		double area = 0;

		for(int i=2;i<n;i++) {
			Point next = arr[i];
			area += (Point.crossProduct(Point.vector(last, s), Point.vector(next, s))) / 2.0;
			last = next;
		}
		return Math.abs(area);
	}
}
