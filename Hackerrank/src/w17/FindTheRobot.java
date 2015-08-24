package w17;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class FindTheRobot {
	public static void main(String args[])throws Exception {
		BufferedReader input = new BufferedReader(
				new InputStreamReader(System.in));
		
		int t = Integer.parseInt(input.readLine());
		
		while(t-->0) {
			int n = Integer.parseInt(input.readLine());
			int oddterms = (int)Math.ceil(n/2.0);
			int eventerms = (int)Math.floor(n/2.0);
			
			long nthodd = (long)Math.pow(-1, oddterms + 1) * ((long)2*oddterms - 1);
			long ntheven = (long)Math.pow(-1, eventerms + 1) * ((long)2*eventerms);

			long oddsum = nthodd + 1;
			long evensum = ntheven + 2;
//			System.out.println("terms " + oddterms + " " + eventerms);
//			System.out.println("nth term " + nthodd + " " + ntheven);
//			System.out.println("sum " + oddsum + " " + evensum);
			if(oddterms %2 == 0)
				oddsum -= 2;
			if(eventerms %2 == 0)
				evensum -= 2;
			
			System.out.println(oddsum/(long)2+" "+ evensum/(long)2);
		}
	}
}
