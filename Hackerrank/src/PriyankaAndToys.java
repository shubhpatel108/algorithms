import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;


public class PriyankaAndToys {
	public static void main(String args[])throws Exception {
		BufferedReader input = new BufferedReader(
				new InputStreamReader(System.in));
		
		int n = Integer.parseInt(input.readLine());
		String[] tokens = input.readLine().split(" ");
		int[] arr = new int[n];
		for(int i=0;i<n;i++)
			arr[i] = Integer.parseInt(tokens[i]);
		
		Arrays.sort(arr);
		int i=0;
		int cost = 0;
		while(i<n) {
			int max = arr[i] + 4;
			while(i<n && arr[i] <= max)
				i++;
			cost++;
		}
		System.out.println(cost);
	}
}
