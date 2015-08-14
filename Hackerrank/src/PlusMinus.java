import java.io.BufferedReader;
import java.io.InputStreamReader;


public class PlusMinus {
	public static void main(String args[])throws Exception {
		BufferedReader input = new BufferedReader(
				new InputStreamReader(System.in));
		
		int n = Integer.parseInt(input.readLine());
		String[] tokens = input.readLine().split(" ");
		int[] arr = new int[n];
		
		int pos = 0, neg = 0, z = 0;
		for(int i=0;i<n;i++) {
			int num = Integer.parseInt(tokens[i]);
			if(num > 0) {
				pos++;
			} else if(num < 0) {
				neg++;
			} else {
				z++;
			}
		}
		System.out.println(String.format("%.3f",((double)pos/n)));
		System.out.println(String.format("%.3f",((double)neg/n)));
		System.out.println(String.format("%.3f",((double)z/n)));
	}
}
