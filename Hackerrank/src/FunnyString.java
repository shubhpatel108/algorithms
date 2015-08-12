import java.io.BufferedReader;
import java.io.InputStreamReader;


public class FunnyString {
	public static void main(String args[])throws Exception {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(input.readLine());
		while(t-->0) {
			String line = input.readLine();
			boolean isFunny = true;
			int n = line.length();
			int i = 0, j= n - 1;
			while(i<j) {
				if(Math.abs(line.charAt(i) - line.charAt(i+1)) != Math.abs(line.charAt(j) - line.charAt(j-1))) {
					isFunny = false;
					break;
				}
				i++;
				j--;
			}
			if(isFunny)
				System.out.println("Funny");
			else
				System.out.println("Not Funny");
		}
	}
}
