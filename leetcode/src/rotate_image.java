
public class rotate_image {
	public static void main(String args[])throws Exception
	{
		int[][] matrix = {{1,1,1,1},{2,2,2,2},{3,3,3,3},{4,4,4,4}};
		rotate(matrix);
	}
	public static void rotate(int[][] matrix) {
		if(matrix.length==0)
			return;
        int max = matrix.length-1;
        int min = 0;
        int temp;
        
        while(min<max)
        {
        	int length = max - min;
        	for(int i=0;i<length;i++)
        	{
        		temp = matrix[min][min+i];
        		matrix[min][min+i] = matrix[max-i][min];
        		matrix[max-i][min] = matrix[max][max-i];
        		matrix[max][max-i] = matrix[min+i][max];
        		matrix[min+i][max] = temp;
    		}
        	min++;
        	max--;
        }
    }
}
