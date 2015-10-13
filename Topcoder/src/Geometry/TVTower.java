// AC - Successfully Completed
package Geometry;

public class TVTower {
	double best = Double.MAX_VALUE;
	int[] x;
	int[] y;
	int n;
	
	public double minRadius(int[]x1, int[]y1) {
		this.x = x1;
		this.y = y1;
		this.n = x1.length;
		
		if(n==1)
			return 0;

		for(int i=0;i<n;i++) {
			for(int j=i+1;j<n;j++) {
				calcMinDist((x[i]+x[j])/2.0, (y[i]+y[j])/2.0);
				Point a = new Point(x[i], y[i]);
				Point b = new Point(x[j], y[j]);

				for(int k=j+1;k<n;k++) {
					Point c = new Point(x[k], y[k]);
					Circle circle = Circle.circleThrough(a, b, c);
					calcMinDist(circle.centre.x, circle.centre.y);
				}
			}
		}
		
		return best;
	}

	public void calcMinDist(double x1, double y1) {
		double dist = 0;

		for(int i=0;i<n;i++) {
			dist = Math.max(dist, Math.sqrt((Math.pow(x1-x[i], 2)) + (Math.pow(y1-y[i], 2))));
		}

		best = Math.min(best, dist);
	}
}
