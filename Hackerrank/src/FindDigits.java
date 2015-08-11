import java.io.BufferedReader;
import java.io.InputStreamReader;


public class FindDigits {
	public static void main(String args[])throws Exception {
		BufferedReader input = new BufferedReader(
				new InputStreamReader(System.in));
		
		int t = Integer.parseInt(input.readLine());
		
		while(t-->0) {
			long n = Long.parseLong(input.readLine());
			System.out.println(digitsDivisor(n));
		}
		System.out.println();
	}
	
	public static int digitsDivisor(long num) {
		long x= num;
		int count = 0;
		while(x > 0) {
			long d = x%10;
			if(d!=0 && num%d==0) {
				count++;
			}
			x /= 10;
		}
		return count;
	}
}
