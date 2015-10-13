package Geometry;

public class Travel {
	double r;

	int shortest(String[] cities, int radius) {
		this.r = radius;
		int n = cities.length;
		
		Point[] arr = new Point[n];
		for(int i=0;i<n;i++) {
			String[] tokens = cities[i].split(" ");
			arr[i] = new Point(Math.toRadians(Integer.parseInt(tokens[0])), 
					Math.toRadians(Integer.parseInt(tokens[1])));
		}
		
		boolean[] visited = new boolean[n];
		visited[0] = true;
		int last = 0;
		double totalDistance = 0;
		int minIndex = 0;

		for(int i=1;i<n;i++) {
			double dist = Double.MAX_VALUE;

			for(int j=0;j<n;j++) {
				if(visited[j] || last == j)
					continue;

				Double d = getDistance(arr[last].x, arr[last].y,
						arr[i].x, arr[i].y);

				if(d < dist) {
					dist = d;
					minIndex = j;
				}
			}
			totalDistance += dist;
			visited[minIndex] = true;
			last = minIndex;
		}
		totalDistance += getDistance(arr[0].x, arr[0].y, arr[minIndex].x, arr[minIndex].y);
		return (int)Math.round(totalDistance);
	}
	
	double getDistance(double lati1, double longi1,
						double lati2, double longi2) {
		return r * Math.acos(Math.cos(lati1)*Math.cos(lati2)*
				Math.cos(longi1 - longi2) + Math.sin(lati1)*Math.sin(lati2));
	}
}
