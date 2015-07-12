
public class LongestCommonSubsequence {
	public static void main(String args[]) throws Exception {
		int[] arr1 = {4,3,4};
		int[] arr2 = {1,2,3};
		System.out.println(lcs(arr1, arr2));
	}
	public static int lcs(int[] arr1, int[] arr2) {
		int n1 = arr1.length;
		int n2 = arr2.length;
		int[][] ans = new int[n1+1][n2+1];

		for(int i=0;i<=n1;i++) {
			for(int j=0;j<=n2;j++) {
				if(i==0 || j==0)
					ans[i][j] = 0;
				else if(arr1[i-1]==arr2[j-1])
					ans[i][j] = ans[i-1][j-1] + 1;
				else {
					ans[i][j] = (int)Math.max(ans[i-1][j], ans[i][j-1]);	
				}
			}
		}
		return ans[n1][n2];
	}
}
