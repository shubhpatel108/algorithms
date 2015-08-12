import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Flowers {
	public static void main(String args[])throws Exception {
		BufferedReader input = new BufferedReader(
				new InputStreamReader(System.in));

		String[] ts = input.readLine().split(" ");
		int n = Integer.parseInt(ts[0]);
		int k = Integer.parseInt(ts[1]);

		int[] arr = new int[n];
		ts = input.readLine().split(" ");
		for(int i=0;i<n;i++)
			arr[i] = Integer.parseInt(ts[i]);
		
		Arrays.sort(arr);
		int i = n-1;
		int x = 1;
		int cost = 0;

		while(i>=0) {
			int j = 0;
			while(i>=0 && j<k) {
				cost += x*arr[i];
				i--;
				j++;
			}
			x++;
		}
		System.out.println(cost);
	}
}
