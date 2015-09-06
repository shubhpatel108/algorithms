package competitions;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class A569 {
	public static void main(String args[])throws Exception {
		BufferedReader input = new BufferedReader(
				new InputStreamReader(System.in));
		String[] tokens = input.readLine().split(" ");
		
		int n = Integer.parseInt(tokens[0]);
		int min = Integer.parseInt(tokens[1]);
		int download = Integer.parseInt(tokens[2]) - 1;
		
		int buffered = 0;
		int present = 0;
		int started = 1;
		
		while(min>buffered) {
			buffered += download;
		}
		present = buffered % min;

		while(present<n) {
			while(present<n && present<buffered ) {
				present += download + 1;
				buffered += download;
			}
			
			if(present>=n)
				break;
			else {
				started++;
				present = present - buffered;
			}
		}
		System.out.println(started);
	}
}
