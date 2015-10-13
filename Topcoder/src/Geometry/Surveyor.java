package Geometry;

public class Surveyor {
	public int area(String direction, int[] lengths) {
		int n = lengths.length;
		
		if(n<3)
			return 0;
		
		Point arr[] = new Point[n];
		Point last = new Point(0,0);

		for(int i=0;i<n;i++) {
			int vertimul = 0;
			int horimul = 0;
			char c = direction.charAt(i);
			
			if(c=='N')
				vertimul = 1;
			else if(c=='S')
				vertimul = -1;
			else if(c=='E')
				horimul = 1;
			else if(c=='W')
				horimul = -1;
			
			arr[i] = new Point(last.x + horimul*lengths[i], last.y + vertimul*lengths[i]);
			last.x = last.x + horimul*lengths[i];
			last.y = last.y + vertimul*lengths[i];
		}
		
		ConvexPolygon cv = new ConvexPolygon();
		return (int)cv.area(arr);
	}
}
