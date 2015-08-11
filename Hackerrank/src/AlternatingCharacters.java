import java.io.BufferedReader;
import java.io.InputStreamReader;


public class AlternatingCharacters {
	public static void main(String args[])throws Exception {
		BufferedReader input = new BufferedReader(
				new InputStreamReader(System.in));
		
		int t = Integer.parseInt(input.readLine());
		while(t-->0) {
			String s = input.readLine();
			int count = 0;
			int len = s.length();
			for(int i=0;i<len-1;) {
				int j=i+1;
				while(j<len && s.charAt(i)==s.charAt(j))
					j++;
				count += (j-i-1);
				i = j;
			}
			System.out.println(count);
		}
	}
}
