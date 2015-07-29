
import java.util.HashMap;

public class happy_number {
	public static void main(String args[])throws Exception
	{
		int n = 7;
		System.out.println(isHappy(n));
	}
	
	static boolean isHappy(int n)
	{
		HashMap<Integer, Boolean> hm = new HashMap<Integer, Boolean>();
		while(n>1 && !hm.containsKey(n))
		{
			hm.put(n, true);
			n = sumOfDigits(n);
		}
		if(n==1) return true;
		return false;
	}
	
	static int sumOfDigits(int n)
	{
		int sum = 0;
		while(n>0)
		{
			sum += (int)Math.pow(n%10, 2);
			n /=10;
		}
		return sum;
	}
}
