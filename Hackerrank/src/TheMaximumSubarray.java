import java.io.BufferedReader;
import java.io.InputStreamReader;


public class TheMaximumSubarray {
	public static void main(String args[])throws Exception {
		BufferedReader input = new BufferedReader(
				new InputStreamReader(System.in));
		
		String[] tokens = input.readLine().split(" ");
		int t = Integer.parseInt(tokens[0]);
		
		while(t-->0) {
			tokens = input.readLine().split(" ");
			int n = Integer.parseInt(tokens[0]);
			
			tokens = input.readLine().split(" ");
			int[] arr = new int[n];
			for(int i=0;i<n;i++) {
				arr[i] = Integer.parseInt(tokens[i]);
			}
			System.out.println(maxSubArraySum(arr) +" "+ maxSubSeqSum(arr));
		}
	}
	
	public static int maxSubSeqSum(int[] arr) {
		int sum = 0;
		int max = Integer.MIN_VALUE;
		for(int num : arr) {
			if(num>0)
				sum += num;
			if(num > max)
				max = num;
		}
		if(sum == 0)
			sum = max;
		return sum;
	}
	
	/*
	 * Kadane's Algo
	*/
	public static int maxSubArraySum(int[] arr) {
		int n = arr.length;
		
		if(n<1)
			return 0;
		
		int max_so_far = arr[0];
		int max_till_last = arr[0];
		
		for(int i=1;i<n;i++) {
			max_till_last = Math.max(max_till_last + arr[i], arr[i]);
			max_so_far = Math.max(max_till_last, max_so_far);
		}
		
		return max_so_far;
	}
}
