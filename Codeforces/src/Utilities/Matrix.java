package Utilities;

public class Matrix {
	public void print(int[][] arr) {
		int n = arr.length;
		if(n<0)
			return;
		int m = arr[0].length;
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++)
				System.out.print(String.format("%4d", arr[i][j]));
			System.out.println();
		}
	}
}
