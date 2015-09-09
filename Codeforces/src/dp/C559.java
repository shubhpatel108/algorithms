//Memory limit exceeded.
package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;


public class C559 {
	public static void main(String args[])throws Exception {
		BufferedReader input = new BufferedReader(
				new InputStreamReader(System.in));
		String[] tokens = input.readLine().split(" ");
		
		int h = Integer.parseInt(tokens[0]);
		int w = Integer.parseInt(tokens[1]);
		int n = Integer.parseInt(tokens[2]);

		int[][] arr = new int[h][w];

		for(int i=0;i<n;i++) {
			tokens = input.readLine().split(" ");
			int a = Integer.parseInt(tokens[0]) - 1;
			int b = Integer.parseInt(tokens[1]) - 1;
			arr[a][b] = -1;
		}
		arr[0][0] = 1;
		int val = 1;
		for(int i=1;i<w;i++) {
			if(arr[0][i] == -1) {
				val = -1;
				continue;
			}
			arr[0][i] = val;
		}
		val = 1;
		for(int i=1;i<h;i++) {
			if(arr[i][0] == -1) {
				val = -1;
				continue;
			}
			arr[i][0] = val;
		}
		
		int divisor = (int)Math.pow(10, 9) + 7;
		for(int i=1;i<h;i++) {
			for(int j=1;j<w;j++) {
				if(arr[i][j]==-1)
					continue;
				long ans = 0;
				if(arr[i-1][j]!=-1)
					ans += arr[i-1][j];
				
				if(arr[i][j-1]!=-1)
					ans += arr[i][j-1];
				arr[i][j] = (int)(ans%divisor);
			}
		}
//		for(int[]ar : arr)
//			System.out.println(Arrays.toString(ar));
		System.out.println(arr[h-1][w-1]);
	}
}
