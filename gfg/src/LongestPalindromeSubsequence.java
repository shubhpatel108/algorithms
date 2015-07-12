
public class LongestPalindromeSubsequence {
	public static void main(String args[])throws Exception {
		int[] arr = {1,2,3};
		System.out.println(lps(arr));
	}

	public static int lps(int[] arr) {
		int n = arr.length;
		int[][] ans = new int[n+1][n+1];
		
		for(int i=0; i<n; i++) {
			ans[i][i] = 1;
		}

		for(int i=1;i<n;i++) {
			for(int j=2;j<n;j++) {
				if(arr[i]==arr[j]) {
					ans[i][j] = ans[i-1][j-1] + 1;
				} else {
					ans[i][j] = (int)Math.max(ans[i-1][j], ans[i][j-1]);
				}
			}
		}
		return ans[n-1][n-1];
	}
}
