package RA_APAC;

import java.util.Arrays;
import java.util.Scanner;

public class CutTiles {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		int T = input.nextInt();
		
		for(int t=1; t<=T; t++) {
			int n = input.nextInt();
			long m = input.nextLong();
			int[] arr = new int[33];
			
			for(int i=0; i<n; i++) {
				arr[input.nextInt()]++;
			}
			int tiles = 0;
			for(int i=arr.length - 1; i>=0; i--) {
				while(arr[i]>0) {
					cover(arr, m, m);
					tiles++;
				}
			}
			System.out.println("Case #"+t+": " + tiles);
		}
	}
	
	public static void cover(int[] arr, long l, long h) {
		int largest = (int)Math.floor((Math.log10(l) / Math.log10(2)));
		if (largest==0 || l==0 || h==0)
			return;

		while(largest>=0) {
			if(arr[largest]>0) {
				arr[largest]--;
				break;
			} else {
				largest--;
			}
		}
		
		if(largest<0)
			return;
		
		long length = (long)Math.pow(2, largest);
		
		cover(arr, l-length, h);
		if(h-length > l)
			cover(arr, l, h - length);
		else
			cover(arr, h-length,l);
	}
}
