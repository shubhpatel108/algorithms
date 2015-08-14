import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Pangrams {
	public static void main(String args[])throws Exception {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		String line = input.readLine();
		if(isPangram(line))
			System.out.println("pangram");
		else
			System.out.println("not pangram");
	}
	
	public static boolean isPangram(String s) {
		boolean arr[] = new boolean[26];
		int n = s.length();
		for(int i=0;i<n;i++) {
			char c = Character.toLowerCase(s.charAt(i));
			if(c==' ')
				continue;
			arr[c-97] = true;
		}
		for(int i=0;i<26;i++)
			if(!arr[i])
				return false;
		return true;
	}
}
