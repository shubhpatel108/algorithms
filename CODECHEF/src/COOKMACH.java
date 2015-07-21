//AC
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class COOKMACH {
	public static void main(String args[])throws Exception {
		BufferedReader input = new BufferedReader(
				new InputStreamReader(System.in));
		String[] tokens = input.readLine().split(" ");
		int n = Integer.parseInt(tokens[0]);
		while(n-->0) {
			tokens = input.readLine().split(" ");
			int a = Integer.parseInt(tokens[0]);
			int b = Integer.parseInt(tokens[1]);
			int ans = 0;
			
			while(a != b) {
				if(a < b && isPower(a)) {
//					System.out.println(b +"->"+log2(b));
//					System.out.println(a +"->"+log2(a));
					ans += log2(b) - log2(a);
					break;
				} else {
					ans++;
					a /=2;
				}
			}
			System.out.println(ans);
		}
	}
	
	public static boolean isPower(int value) {
		return ((value & -value) == value);
	}
	
	public static int log2(int num) {
		return (int)(Math.log10(num) / Math.log10(2));
	}
}
