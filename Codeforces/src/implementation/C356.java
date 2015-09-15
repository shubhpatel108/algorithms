package implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class C356 {
	static int[] arr;
	public static void main(String args[])throws Exception {
		BufferedReader input = new BufferedReader(
				new InputStreamReader(System.in));
		String[] tokens = input.readLine().split(" ");
		
		int n = Integer.parseInt(tokens[0]);
		
		arr = new int[5];
		tokens = input.readLine().split(" ");
		for(int i=0;i<n;i++)
			arr[Integer.parseInt(tokens[i])]++;
		
		int count = 0;
		count += adjust(1, 2, 3);
		
		if(arr[1]>0) {
			count += adjust(1,3,4);
			if(arr[1]>0) {
				int adjust_among = arr[1] / 3;
				arr[3] += adjust_among*3 - adjust_among;
				arr[1] = arr[1]%3;
				count += adjust(1,3,4);
			}
			if(arr[1]%2==0) {
				arr[2] += arr[1] / 2;
				count += arr[1] / 2;
				arr[1] = 0;
			}
		}
		if(arr[2]>0) {
			count += adjust(2,4,3);
			if(arr[2]>0) {
				int adjust_among = arr[2]/2;
				arr[3] += adjust_among;
				arr[1] += adjust_among;
				count += adjust_among;
				arr[2] = arr[2]%2;
				
				count += adjust(1,2,3);
				count += adjust(1,3,4);
				count += adjust(2,4,3);
			}
		}
		if(arr[1]!=0 || arr[2]!=0)
			count = -1;
		System.out.println(count);
	}
	
	public static int adjust(int i, int j, int in) {
		int min = Math.min(arr[i], arr[j]);
		arr[i] -= min;
		arr[j] -= min;
		arr[in] += min;
		return min;
	}
}
