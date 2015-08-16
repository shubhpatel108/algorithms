import java.io.BufferedReader;
import java.io.InputStreamReader;


public class StairCase {
	public static void main(String args[])throws Exception {
		BufferedReader input = new BufferedReader(
				new InputStreamReader(System.in));
		
		int n = Integer.parseInt(input.readLine());
		
		for(int i=1;i<=n;i++) {
			for(int j=0;j<(n-i);j++)
				System.out.print(" ");
			for(int j=0;j<i;j++)
				System.out.print("#");
			System.out.println();
		}
		
	}
}
