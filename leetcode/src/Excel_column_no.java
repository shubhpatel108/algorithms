
public class Excel_column_no {
	public static void main(String args[])throws Exception
	{
		System.out.println(titleToNumber("BA"));
	}
	public static int titleToNumber(String s) {
		int len = s.length();
		int ans = 0;
		for(int i=1;i<len;i++) {
			ans += (int) Math.pow(26, i);
		}
		for(int i=0;i<len;i++)
		{
			ans += (totalBack(s.charAt(i)) * (int)Math.pow(26, len-1-i));
		}
		return ans + 1;
	}
	public static int charToNo(char c) {
		return (int)(c)-64;
	}
	public static int totalBack(char c) {
		return charToNo(c) - 1 ;
	}
	
}
