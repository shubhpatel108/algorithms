import java.io.BufferedReader;
import java.io.InputStreamReader;


public class SherlockAndWatson {
	static int[] arr;
	public static void main(String args[])throws Exception {
		BufferedReader input = new BufferedReader(
				new InputStreamReader(System.in));
		
		String[] tokens = input.readLine().split(" ");
		int n = Integer.parseInt(tokens[0]);
		int k = Integer.parseInt(tokens[1]);
		int q = Integer.parseInt(tokens[2]);
		
		tokens = input.readLine().split(" ");
		arr = new int[n];
		for(int i=0;i<n;i++)
			arr[i] = Integer.parseInt(tokens[i]);
		
		rotate(k%n);
		
		while(q-->0) {
			System.out.println(arr[Integer.parseInt(input.readLine())]);
		}
	}
	
	public static void rotate(int k) {
		int n = arr.length;
		reverse(0, n-1);
		reverse(0, (k-1));
		reverse(k, n-1);
	}
	
	public static void reverse(int i, int j) {
		while(i<j) {
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
			i++;
			j--;
		}
	}
}
