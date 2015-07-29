import java.util.HashMap;


public class contains_duplicate {
	public static void main(String args[]) throws Exception
	{
		int nums [] = {1,2};
		System.out.println(containDuplicate(nums));
		
	}
	public static boolean containDuplicate(int[] nums)
	{
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		for(int i=0; i<nums.length;i++)
		{
			if(!hm.containsKey(nums[i])){
				hm.put(nums[i], 1);
			}
			else
				return true;
		}
		return false;
	}
}
