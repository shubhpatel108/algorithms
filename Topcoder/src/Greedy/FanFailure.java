//AC
package Greedy;

import java.util.Arrays;

public class FanFailure {
	public int[] getRange(int[] arr, int minCool) {
		int n = arr.length;
		int[] ans = {0,0};
		
		if(n == 0)
			return ans;

		Arrays.sort(arr);
		
		int i=n-1;
		int min = minCool;
		while(i>=0 && min > 0) {
			min -= arr[i];
			i--;
		}
		
		ans[0] = i + 1;
		
		i=0;
		min = 0;
		while(i<n && min < minCool) {
			min += arr[i];
			i++;
		}
		ans[1] = n - i;
		
		return ans;
	}
}
