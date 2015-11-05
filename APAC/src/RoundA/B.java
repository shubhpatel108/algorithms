package RoundA;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B {
	public static void main(String args[])throws Exception {
		BufferedReader input = new BufferedReader(
				new InputStreamReader(System.in));
		
		int T = Integer.parseInt(input.readLine());
		
		for(int t=0;t<T;t++) {
			String[] tokens = input.readLine().split(" ");
			int n = Integer.parseInt(tokens[0]);
			int m = Integer.parseInt(tokens[1]);
			
			double[] arr = new double[n];

			tokens = input.readLine().split(" ");
			arr[0] = Double.parseDouble(tokens[0]);
			for(int i=1;i<n;i++)
				arr[i] = Double.parseDouble(tokens[i]) * arr[i-1];
			
			System.out.println("Case #"+(t+1)+":");
			while(m-->0) {
				tokens = input.readLine().split(" ");
				int l = Integer.parseInt(tokens[0]);
				int r = Integer.parseInt(tokens[1]);
				
				double vol = arr[r];
				if(l!=0) {
					vol /= arr[l-1];
				}
				
				System.out.printf("%.9f%n",Math.pow(vol, 1.0/(r-l+1)));
			}
		}
		
		
		System.out.println();
	}
}
