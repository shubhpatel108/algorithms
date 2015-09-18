package sortings;

import java.util.Comparator;

public class Wall {
	int start;
	int end;
	int arrivalTime;
	
	public Wall(int s, int e, int at) {
		this.start = s;
		this.end = e;
		this.arrivalTime = at;
	}
	
	public int length() {
		return end - start;
	}
	
	public static class WallCompare implements Comparator<Wall>{

		@Override
		public int compare(Wall w1, Wall w2) {
			if(w1.start < w2.start)
				return -1;
			if(w1.start > w2.start)
				return 1;
			return 0;
		}
	}
}
