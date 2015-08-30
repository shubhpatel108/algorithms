package C318_574;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class D {
	public static void main(String args[])throws Exception {
		BufferedReader input = new BufferedReader(
				new InputStreamReader(System.in));
		
		int n = Integer.parseInt(input.readLine()) + 2;
		String[] tokens = input.readLine().split(" ");
		int[] arr = new int[n];
		arr[0] = 0;
		arr[n-1] = 0;
		for(int i=1;i<n-1;i++)
			arr[i] = Integer.parseInt(tokens[i-1]);
		int total = 0;
		int start = 1;
		while(true) {
			boolean dest = false;
			int prev = arr[start-1];

			for(int i=start;i<n-start;i++) {

				if(arr[i] == 0)
					continue;
				
				int min = Math.min(prev, arr[i+1]);
				prev = arr[i];
				if(arr[i] <= min) {
					arr[i] = arr[i] - 1;
				} else {
					arr[i] = min;
				}
				dest = true;
			}
			if(dest)
				total++;
			else
				break;
			start++;
//			System.out.println(Arrays.toString(arr));
		}
		
		System.out.println(total);
	}
}
