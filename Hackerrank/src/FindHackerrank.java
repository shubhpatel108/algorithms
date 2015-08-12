import java.io.BufferedReader;
import java.io.InputStreamReader;


public class FindHackerrank {
	public static void main(String args[])throws Exception {
		BufferedReader input = new BufferedReader(
				new InputStreamReader(System.in));
		
		int t = Integer.parseInt(input.readLine());
		while(t-->0) {
			String s = input.readLine();
			boolean start = s.startsWith("hackerrank");
			boolean end = s.endsWith("hackerrank");
			if(start && end)
				System.out.println(0);
			else if(start)
				System.out.println(1);
			else if(end)
				System.out.println(2);
			else
				System.out.println(-1);
		}
		System.out.println();
	}
}
