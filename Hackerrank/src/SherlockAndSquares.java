import java.io.BufferedReader;
import java.io.InputStreamReader;


public class SherlockAndSquares {
	public static void main(String args[])throws Exception {
		BufferedReader input = new BufferedReader(
				new InputStreamReader(System.in));
		
		int t = Integer.parseInt(input.readLine());
		while(t-->0) {
			String[] tokens = input.readLine().split(" ");
			int a = Integer.parseInt(tokens[0]);
			int b = Integer.parseInt(tokens[1]);
			System.out.println((int)(Math.floor(Math.sqrt(b)) - Math.ceil(Math.sqrt(a)) + 1));
		}
	}
}
