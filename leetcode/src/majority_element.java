//implemented using Moore's voting algorithm

public class majority_element {
	public static void main(String args[])throws Exception
	{
		int nums[] = {8,8,7,7,7};
		int ans = majorityElementIndex(nums);
		if(ans == -1)
			System.out.println("No Majority element present");
		else
			System.out.println(nums[ans]);
	}
	public static int majorityElementIndex(int nums[])
	{
		int majorityIndex = 0;
		int len = nums.length;
		int count =1;
		for(int i=1;i<len;i++)
		{
			if(nums[i]==nums[majorityIndex])
				count++;
			else
			{
				count--;
				if(count==0)
				{
					majorityIndex = i;
					count = 1;
				}
			}
		}
		if(count>0)
			return majorityIndex;
		else
			return -1;
	}
}
