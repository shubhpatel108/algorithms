import java.io.BufferedReader;
import java.io.InputStreamReader;


public class CavityMap {
	static int[][] arr;
	static char[][] ans;
	public static void main(String args[])throws Exception {
		BufferedReader input = new BufferedReader(
				new InputStreamReader(System.in));
		
		int n = Integer.parseInt(input.readLine());
		arr = new int[n][n];
		ans = new char[n][n];
		
		for(int i=0;i<n;i++){
			String s = input.readLine();
			for(int j=0;j<n;j++)
				arr[i][j] = Character.getNumericValue(s.charAt(j));
		}
		prefill(n);
		for(int i=1;i<n-1;i++){
			for(int j=1;j<n-1;j++) {
				if(isCavity(i,j)) {
					ans[i][j] = 'X';
				} else {
					ans[i][j] = (char) ('0' + arr[i][j]);
				}
			}
		}
		print(n);
	}
	
	public static void print(int n){
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++)
				System.out.print(ans[i][j]);
			System.out.println();
		}
	}
	
	public static void prefill(int n) {
		for(int i=0;i<n;i++)
			ans[0][i] = (char) ('0' + arr[0][i]);
		for(int i=0;i<n;i++)
			ans[n-1][i] = (char) ('0' + arr[n-1][i]);
		for(int i=0;i<n;i++)
			ans[i][0] = (char) ('0' + arr[i][0]);
		for(int i=0;i<n;i++)
			ans[i][n-1] = (char) ('0' + arr[i][n-1]);
	}
	
	public static boolean isCavity(int x, int y) {
		int num = arr[x][y];
		if(num <= arr[x-1][y])
			return false;
		if(num <= arr[x][y-1])
			return false;
		if(num <= arr[x+1][y])
			return false;
		if(num <= arr[x][y+1])
			return false;
		
		return true;
	}
}
