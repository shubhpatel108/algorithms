
public class search_insert_position {
	public static void main(String args[])throws Exception
	{
		int nums[] = {1};
		int ans = iterativeBinarySearchInsertion(nums, 2);
		System.out.println(ans);
	}
	
	public static int iterativeBinarySearchInsertion(int nums[], int key) 
	{
		int i = 0, j = nums.length-1;
		int middle = 0;
		while(i<=j)
		{
			middle = i + (j-i)/2;
			if(nums[middle]==key)
				return middle;
			else if(nums[middle] > key)
			{
				j = middle - 1;
			}
				
			else if(nums[middle] < key)
			{
				i = middle + 1;
			}
		}
		return i;
	}
}
