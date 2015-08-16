import java.io.BufferedReader;
import java.io.InputStreamReader;


public class TaumAndBday {
	public static void main(String args[])throws Exception {
		BufferedReader input = new BufferedReader(
				new InputStreamReader(System.in));
		
		int t = Integer.parseInt(input.readLine());
		
		while(t-->0) {
			String[] ts = input.readLine().split(" ");
			long b = Long.parseLong(ts[0]);
			long w = Long.parseLong(ts[1]);
			
			ts = input.readLine().split(" ");
			long x = Long.parseLong(ts[0]);
			long y = Long.parseLong(ts[1]);
			long z = Long.parseLong(ts[2]);
			
			long cost = 0;
			if(x+z < y) {
				cost = b*x + w*(x+z);
			} else if (y+z < x) {
				cost = w*y + b*(y+z);
			} else {
				cost = w*y + b*x;
			}
			System.out.println(cost);
		}
	}
}
