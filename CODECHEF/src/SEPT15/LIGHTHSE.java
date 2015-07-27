// Discovered that the question meant that
// lighthouses are directional 
package SEPT15;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class LIGHTHSE {
	public static void main(String args[])throws Exception {
		BufferedReader input = new BufferedReader(
				new InputStreamReader(System.in));
		
		int t = Integer.parseInt(input.readLine());

		while(t-->0) {
			int n = Integer.parseInt(input.readLine());
			
			int count = 0;
			int[] ans = new int[4];
			boolean[] done = new boolean[4];
			int[] border = new int[5];
			
			for(int i=0;i<n;i++) {
				String[] tokens = input.readLine().split(" ");
				int x = Integer.parseInt(tokens[0]);
				int y = Integer.parseInt(tokens[1]);
				int bor = border(x,y);
				
				if(bor==0) {
					int q = quad(x,y);
					if(!done[q-1]) {
						done[q-1] = true;
						ans[q-1] = i + 1;
						count++;
					}
				} else {
					border[bor - 1] = i + 1;
				}
			}
			
			for(int i=0;i<4;i++) {
				if(border[i]!=0 && border[(i+1)%n]!=0 && !done[(i+1)%n]) {
					done[(i+1)%n] = true;
					ans[(i+1)%n] = i + 1;
					border[i] = 0;
					border[(i+1)%n] = 0;
					count++;
				}
			}
			
			for(int i=0;i<4;i++) {
				if(border[i]!=0 && !done[(i+1)%n]) {
					done[(i+1)%n] = true;
					ans[(i+1)%n] = i + 1;
					border[i] = 0;
					count++;
				}
			}
			
			if(count == 0) {
				System.out.println(1);
				System.out.println(border[5] + " " + "NE");
			} else {
				System.out.println(count);
				for(int i=0;i<4;i++) {
					if(done[i])
						System.out.print(ans[i] + " " + qlabel(i));
				}
			}
		}
		
		System.out.println();
	}
	
	public static String qlabel(int i) {
		switch(i) {
			case 0:
				return "NE";
			case 1:
				return "NW";
			case 2:
				return "SW";
			default:
				return "SE";
		}
	}
	
	public static int border(int x, int y) {
		
		if(x!=0 && y!=0)
			return 0;
		
		if(x==0 && y==0)
			return 5;
		if(x==0 && y>0)
			return 1;
		if(x<0 && y==0)
			return 2;
		if(x==0 && y<0)
			return 3;
		else
			return 4;
	}
	
	public static int quad(int x, int y) {
		if(x > 0 && y > 0)
			return 1;
		if(x < 0 && y > 0)
			return 2;
		if(x < 0 && y < 0)
			return 3;
		if(x > 0 && y < 0)
			return 4;
		return -1;
	}
}
