package summer;
//Assume array is sorted

public class remove_duplicates {
	public static void main(String args[])throws Exception
	{
		int[] array = {1,1,1,2};
		System.out.println(removeDupsII(array));
		
	}
	
	public static int removeDups(int[] array)
	{
		int len = array.length;
		if(len<=1)
			return len;
		
		int deserving = 2, i=1;
		while(i<len)
		{
			if(array[i]>array[i-1])
			{
				i++;
			}
			
			else
			{
				if(deserving<len)
				{
					array[i] = array[deserving++];
				}
				else break;
			}
		}
		
		return i;
	}
	
	public static int removeDupsII(int[] array)
	{
		int len = array.length;
		int last_count = 0;
		int limit = 2;
		
		if(len<=1)
			return len;
		
		int deserving = 2, i=1;
		while(i<len)
		{
			if(array[i]>array[i-1])
			{
				i++;
				last_count = 0;
			}
			else if(array[i]==array[i-1])
			{
				last_count++;
				if(last_count==limit)
				{
					if(deserving<len)
					{
						array[i] = array[deserving++];
					}
					else break;
					last_count--;
				}
				else {
					i++; deserving++;
				}
			}
			else
			{
				if(deserving<len)
				{
					array[i] = array[deserving++];
				}
				else break;
				last_count = 0;
			}
		}
		
		for(int j=0;j<i;j++)
			System.out.print(array[j]);
		
		System.out.println();
		return i;
	}
}
