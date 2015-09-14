//AC
package implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B218 {
	public static void main(String args[])throws Exception {
		BufferedReader input = new BufferedReader(
				new InputStreamReader(System.in));
		
		String[] tokens = input.readLine().split(" ");
		int n = Integer.parseInt(tokens[0]);
		int m = Integer.parseInt(tokens[1]);
		int[] arr = new int[1001];
		int len = 1001;
		tokens = input.readLine().split(" ");
		for(int i=0;i<m;i++)
			arr[Integer.parseInt(tokens[i])]++;
		
		int i=1,rem=n;
		int minCost = 0;
		while(i<len && rem>0) {
			if(arr[i]==0) {
				i++;
				continue;
			}
			if((arr[i]*i)<=rem) {
				rem -= arr[i]*i;
				minCost += sum(i) * arr[i]; 
			} else {
				minCost += (rem / i)*sum(i);
				minCost += sum(i) - sum(i-(rem%i));
				rem  = 0;
			}
			i++;
		}
		
		i=len-1;
		rem=n;
		int maxCost = 0;
		
		while(i>0 && rem>0) {
			if(arr[i]==0) {
				i--;
				continue;
			}
			if(arr[i]<=rem) {
				rem -= arr[i];
				arr[i-1] += arr[i];
				maxCost += arr[i] * i;
			} else {
				maxCost += rem*i;
				rem = 0;
			}
			i--;
		} 
		System.out.println(maxCost +" "+ minCost);
	}
	
	public static int sum(int num) {
		return (num*(num+1))/2;
	}
}
