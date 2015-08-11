import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;


public class CutTheStick {
	public static void main(String args[])throws Exception {
		BufferedReader input = new BufferedReader(
				new InputStreamReader(System.in));
		
		int n = Integer.parseInt(input.readLine());
		String[] tokens = input.readLine().split(" ");
		int[] arr = new int[n];
		for(int i=0;i<n;i++)
			arr[i] = Integer.parseInt(tokens[i]);
		
		Arrays.sort(arr);
		
		int count = n;
		int i=0;
		int num = arr[0];
		while(count>0) {
			System.out.println(count);
			num = arr[i];
			while(i<n && num==arr[i])
				i++;
			count = n - i;
		}

	}
}
