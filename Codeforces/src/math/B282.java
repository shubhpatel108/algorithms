//INC
package math;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class B282 {
	public static void main(String args[])throws Exception {
		BufferedReader input = new BufferedReader(
				new InputStreamReader(System.in));
		
		int n = Integer.parseInt(input.readLine());
		
		
		Egg[] arr = new Egg[n];
		for(int i=0;i<n;i++) {
			String[] tokens = input.readLine().split(" ");
			arr[i] = new Egg(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1]), i);
		}
		Arrays.sort(arr, new Egg.EggCompare());
		
		if(n == 1) {
			if(Math.abs(arr[0].a - arr[0].b) <= 500) {
				
			}
		}
		
		int i=1, j=n-2;
		int at = arr[0].a;
		int bt = arr[n-1].b;
		
		while(i<n) {
			if(at + arr[i].a <= bt + 500) {
				
			}
		}
		
		System.out.println();
	}
	
	public static class Egg {
		int a;
		int b;
		boolean toa;
		int index;
		
		public Egg(int a, int b, int index) {
			this.a = a;
			this.b = b;
			this.index = index;
		}
		
		public static class EggCompare implements Comparator<Egg> {

			@Override
			public int compare(Egg e1, Egg e2) {
				if(e1.a < e2.a)
					return -1;
				return 1;
			}
			
		}
		
		public static class EggIndexCompare implements Comparator<Egg> {

			@Override
			public int compare(Egg e1, Egg e2) {
				if(e1.index < e2.index)
					return -1;
				return 1;
			}
			
		}
	}
}
