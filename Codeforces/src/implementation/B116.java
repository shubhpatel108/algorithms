package implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B116 {
	static char[][] arr;
	static int ans = 0;
	public static void main(String args[])throws Exception {
		BufferedReader input = new BufferedReader(
				new InputStreamReader(System.in));
		
		String[] tokens = input.readLine().split(" ");
		
		int n = Integer.parseInt(tokens[0]);
		int m = Integer.parseInt(tokens[1]);

		arr = new char[n][m];
		for(int i=0;i<n;i++) {
			String line = input.readLine();
			for(int j=0;j<m;j++) {
				arr[i][j] = line.charAt(j);
			}
		}
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(arr[i][j] == 'P') {
					minPigsWolf(i, j, n, m, 'W');
				}
			}
		}
		
		System.out.println(ans);
	}

	public static int numPigs(int i, int j, int n, int m, char type) {
		int count = 0;
		if(i-1>=0)
			if(arr[i-1][j] == type)
				count++;
		if(j-1>=0)
			if(arr[i][j-1] == type)
				count++;
		if(i+1<n)
			if(arr[i+1][j] == type)
				count++;
		if(j+1<m)
			if(arr[i][j+1] == type)
				count++;
		return count;
	}
	
	public static void minPigsWolf(int i, int j, int n, int m, char type) {
		int min = 5;
		int minI = 0;
		int minJ = 0;

		if(i-1>=0 && arr[i-1][j] == type) {
			int pigs = numPigs(i-1, j, n, m, 'P');
			if(pigs < min && pigs > 0) {
				min = pigs;
				minI = i-1;
				minJ = j;
			}
		}
			
		if(j-1>=0 && arr[i][j-1] == type) {
			int pigs = numPigs(i, j-1, n, m, 'P');
			if(pigs < min && pigs > 0) {
				min = pigs;
				minI = i;
				minJ = j-1;
			}
		}
		if(i+1<n && arr[i+1][j] == type) {
			int pigs = numPigs(i+1, j, n, m, 'P');
			if(pigs < min && pigs > 0) {
				min = pigs;
				minI = i+1;
				minJ = j;
			}
		}

		if(j+1<m && arr[i][j+1] == type) {
			int pigs = numPigs(i, j+1, n, m, 'P');
			if(pigs < min && pigs > 0) {
				min = pigs;
				minI = i;
				minJ = j+1;
			}
		}
		//delete that wolf and the pig.
		if(min > 0 && min<5) {
			arr[minI][minJ] = '.';
			arr[i][j] = '.';
			ans++;
		}
	}
}
