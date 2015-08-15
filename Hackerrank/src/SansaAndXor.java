//AC
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SansaAndXor {
	public static void main(String args[])throws Exception {
		BufferedReader input = new BufferedReader(
				new InputStreamReader(System.in));
		String[] tokens = input.readLine().split(" ");
		
		int t = Integer.parseInt(tokens[0]);
		
		while(t-->0) {
			int n = Integer.parseInt(input.readLine());
			tokens = input.readLine().split(" ");
			int ans = 0;
			int total = total(n);
			for(int i=0;i<n;i++) {
				if((total - total(i) - total(n-1-i))%2 != 0) {
					ans = ans ^ Integer.parseInt(tokens[i]);
				}
			}
			System.out.println(ans);
		}
	}
	
	public static int total(int n) {
		return n*(n-1) / 2 + n;
	}
}
