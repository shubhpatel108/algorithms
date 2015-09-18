package sortings;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class D286 {
	public static void main(String args[])throws Exception {
		BufferedReader input = new BufferedReader(
				new InputStreamReader(System.in));
		
		String[] tokens = input.readLine().split(" ");
		int n = Integer.parseInt(tokens[0]);
		int m = Integer.parseInt(tokens[1]);
		int[] arr = new int[n];
		Wall[] walls = new Wall[m];
		for(int i=0;i<n;i++) {
			tokens = input.readLine().split(" ");
			Wall wall = new Wall(Integer.parseInt(tokens[0]),
					Integer.parseInt(tokens[1]),
					Integer.parseInt(tokens[2]));
			walls[i] = wall;
		}
		Arrays.sort(walls, new Wall.WallCompare());

		tokens = input.readLine().split(" ");
		for(int i=0;i<m;i++) {
			int t = Integer.parseInt(tokens[i]);
			int curr = 0;
			int ans = 0;
			int laststart = 0;
			int lastend = 0;

			for(int j=0;j<n;j++) {
				if(walls[j].end <= curr)
					continue;

				int diff = walls[j].start - curr;
				if(diff >= 0) {
					curr += diff;
				}

				diff = walls[j].arrivalTime - (curr - t);
				if(diff > 0) {
					laststart = curr;
					curr += Math.min((walls[j].end - curr), diff);
					lastend = curr;
				} else {
					if(diff > last) {
						ans -= (diff - last);
						last = (diff - last);
					}
				}
				
				if(curr < walls[j].end) {
					ans += walls[j].end - curr;
					last = walls[j].end - curr;
				}
				curr = walls[j].end;
				System.out.println(ans);
			}
			System.out.println(ans);
		}
	}
}
