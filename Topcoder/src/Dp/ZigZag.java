package Dp;

import java.util.Arrays;

public class ZigZag {
	public int longestZigZag(int[] arr) {
		int n = arr.length;
		if(n<3)
			return n;
		int pos = 0;
		int neg = 0;
		if(arr[n-2] < arr[n-1])
			pos = 2;
		else if(arr[n-2] > arr[n-1])
			neg = 2;
		else {
			pos = 1;
			neg = 1;
		}

		for(int i=n-3;i>=0;i--) {
			if(arr[i] > arr[i+1])
				neg = Math.max(pos + 1, neg);
			else if(arr[i] < arr[i+1])
				pos = Math.max(neg + 1, pos);
		}
		
		return (int)Math.max(pos, neg);
	}
}
