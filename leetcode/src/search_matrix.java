
public class search_matrix {
	public static void main(String args[])throws Exception
	{
		int[][] array = {{1, 3,  5,  7}, {10, 11, 16, 20}, {23, 30, 34, 50}};
		System.out.println(searchMatrix(array, 3));
	}
	
    public static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if(m==0)
        	return false;
        
        int n = matrix[0].length;
        int i=0,j=n-1;
        while(i<m && j>=0)
        {
        	if(matrix[i][j]==target)
        		return true;
        	else if(matrix[i][j]>target)
        		j--;
        	else if(matrix[i][j]<target)
        		i++;
        }
        return false;
    }
}
