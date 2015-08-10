package summer;

public class spiral_matrix {
	public static void main(String args[])throws Exception
	{
		int n = 4;
		int array[][] = generateMatrix(n);
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++)
				System.out.print(array[i][j] + "\t");
			System.out.println();
		}
			
	}
	public static int[][] generateMatrix(int n) {
        int layers = (n+1)/2;
        int[][] ans = new int[n][n];
        int fill = 1;
        for(int count = 0; count<layers;count++)
        {
        	int first = count;
        	int last = n - count-1;
        	for(int j=first;j<last;j++)
        		ans[first][j] = fill++;
        	for(int j=first;j<last;j++)
        		ans[j][last] = fill++;
        	for(int j=last;j>first;j--)
        		ans[last][j] = fill++;
        	for(int j=last;j>first;j--)
        		ans[j][first] = fill++;
        	if(first==last)
        		ans[first][last] = fill;
        }
        return ans;
    }
}
