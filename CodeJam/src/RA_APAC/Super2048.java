//Correct
package RA_APAC;

import java.util.Arrays;
import java.util.Scanner;

public class Super2048 {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		int T = input.nextInt();
		
		
		for(int t=1; t<=T; t++) {
			int n = input.nextInt();
			String dir = input.next();
			int[][] arr = new int[n][n];
			
			for(int i=0; i<n; i++) {
				for(int j=0;j<n;j++)
					arr[i][j] = input.nextInt();
			}
			boolean reverse = false;
			if(dir.equals("left") || dir.equals("right") ) { 
				
				if(dir.equals("right"))
					reverse = true;
				
				for(int i=0;i<n;i++)
					arr[i] = move(arr[i], reverse);
			} else {
				if(dir.equals("down"))
					reverse = true;
				for(int i=0;i<n;i++) {
					setCol(arr, move(getCol(arr, i), reverse), i);
				}
			}
			System.out.println("Case #"+t+": ");
			printArr(arr);
		}
//		int[] arr = {8,4,2,2};
//		System.out.println(Arrays.toString(move(arr, false)));
	}
	
	public static int[] move(int[] arr, boolean reverse) {
		int n = arr.length;
		int i=0,j=1;
		int k = 0;
		if(reverse) {
			for(int m = 0; m < n/ 2; m++)
			{
			    int temp = arr[m];
			    arr[m] = arr[n- m - 1];
			    arr[n - m - 1] = temp;
			}
		}
		
		while(i<n && j<n) {
			if(arr[j]==0)
				j++;
			else {
				if(arr[i]==0)
				{
					arr[i] = arr[j];
					arr[j] = 0;
					j++;
				} else {
					if(arr[i]==arr[j])
					{
						arr[i] = arr[i] << 1;
						arr[j] = 0;
						i++;
						j++;
					} else {
						int temp = arr[j];
						arr[j] = 0;
						arr[i+1] = temp;
						i++;
						j++;
					}
				}
			}
		}

		if(reverse) {
			for(int m = 0; m < n/ 2; m++)
			{
			    int temp = arr[m];
			    arr[m] = arr[n- m - 1];
			    arr[n - m - 1] = temp;
			}
		}
		return arr;
	}
	
	public static int[] getCol(int[][] arr, int k) {
		int n = arr.length;
		int[] col = new int[n];
		for(int i=0;i<n;i++) {
			col[i] = arr[i][k];
		}
		return col;
	}
	
	public static void setCol(int[][] arr, int[] col, int k) {
		int n = arr.length;
		for(int i=0;i<n;i++) {
			arr[i][k] = col[i];
		}
	}
	
	public static void printArr(int[][] arr) {
		int n = arr.length;
		for(int i=0;i<n;i++) {
			int m = arr[i].length;
			for(int j=0;j<m;j++)
				System.out.print(arr[i][j] + " ");
			System.out.println();
		}
	}
}
