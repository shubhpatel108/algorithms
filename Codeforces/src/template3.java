// T cases, each taking a digit and correspondsing no. of integers
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class template3 {
	public static void main(String args[])throws Exception {
		BufferedReader input = new BufferedReader(
				new InputStreamReader(System.in));
		
		int T = Integer.parseInt(input.readLine());
		for(int t=0; t<T;t++) {
			int n = Integer.parseInt(input.readLine());
			int[] arr = new int[n];
			String[] tokens = input.readLine().split(" ");
			for(int i=0;i<n;i++)
				arr[i] = Integer.parseInt(tokens[i]);
			
			//Rest of code
		}
		System.out.println();
	}
}
