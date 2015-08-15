//AC
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SherlockAndArray {
	public static void main(String args[])throws Exception {
		BufferedReader input = new BufferedReader(
				new InputStreamReader(System.in));
		String[] tokens = input.readLine().split(" ");
		
		int t = Integer.parseInt(tokens[0]);
		
		while(t-->0) {
			int n = Integer.parseInt(input.readLine());
			int[] arr = new int[n];
			tokens = input.readLine().split(" ");
			for(int i=0;i<n;i++) {
				arr[i] = Integer.parseInt(tokens[i]);
			}
			for(int i=1;i<n;i++) {
				arr[i] += arr[i-1];
			}
			
			int i=0;
			for(i=0;i<n;i++) {
				int left = 0;
				int right = 0;
				
				if(i>0) {
					left = sum(arr, 0, i-1, n);
				}

				if(i<n-1) {
					right = sum(arr, i+1, n-1, n);
				}
//				System.out.println(left + " === " + right);
				if(left == right) {
					System.out.println("YES");
					break;
				}
			}
			if(i==n)
				System.out.println("NO");
		}
	}
	
	public static int sum(int[] arr, int i, int j, int n) {
		int sum = arr[j]-arr[i];
		if(i>0) {
			sum += (arr[i]-arr[i-1]);
		} else {
			sum += arr[0];
		}

		return sum;
	}
}
