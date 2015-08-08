package summer;
//AC
import java.io.*;
import java.util.Arrays;

public class plus_one {
	public static void main(String args[])throws Exception
	{
		try{
			BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
			String n = (input.readLine());
			int number[] = new int[n.length()];
			for(int i=0;i<n.length();i++)
			{
				number[i] = Character.getNumericValue(n.charAt(i));
			}
			System.out.println(Arrays.toString(plus(number)));
		}catch(Exception e)
		{
			
		}
	}
	
	public static int[] plus(int number[]){
		int add = 1;
		int index = number.length - 1;
		int ans;
		while(index>=0)
		{
			ans = number[index] + add;
			add = ans/10;
			number[index] = ans%10;
			index--;
			if(add==0) break;
		}
		if(add!=0)
		{
			int new_length = number.length + 1;
			int array[] = new int[new_length];
			array[0] = add;
			for(int i=1;i<new_length;i++)
			{
				array[i] = number[i-1];
			}
			return array;
		}
		return number;
	}
}
