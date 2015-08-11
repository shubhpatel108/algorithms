import java.io.BufferedReader;
import java.io.InputStreamReader;

public class DiagonalDifference {
	public static void main(String args[])throws Exception {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(input.readLine());
		int main = 0;
		int another = 0;
		for(int i=0;i<n;i++) {
			String[] t = input.readLine().split(" ");
			main += Integer.parseInt(t[i]);
			another += Integer.parseInt(t[n-1-i]);
		}
		System.out.println(Math.abs(main-another));
	}
}
