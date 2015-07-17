package searching_sorting;

import java.util.Arrays;

public class ShellSort {
	public int[] sort(int[] arr) {
		int n = arr.length;
		
		int h = 0;
		
		while(h < n/3)
			h = h*3 + 1;
		
		while(h>0) {
			for(int i=h; i<n; i++) {
				for(int j=i; j>=h && arr[j]<arr[j-h]; j-=h) {
					swap(arr, j, j-h);
				}
			}
			h = h/3;
		}
		return arr;
	}
	
	public void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
