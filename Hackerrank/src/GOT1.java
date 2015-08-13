import java.io.BufferedReader;
import java.io.InputStreamReader;


public class GOT1 {
	public static void main(String args[])throws Exception {
		BufferedReader input = new BufferedReader(
				new InputStreamReader(System.in));
		String s = input.readLine();
		
		if(hasPalinPermutation(s))
			System.out.println("YES");
		else
			System.out.println("NO");
	}
	
	public static boolean hasPalinPermutation(String s) {
		int[] arr = new int[26];
		int n = s.length();
		
		for(int i=0;i<n;i++) {
			(arr[s.charAt(i) - 97])++;
		}
		boolean allow;
		
		if(n%2 == 0)
			allow = false;
		else
			allow = true;

		for(int i=0;i<26;i++) {
			if(arr[i]%2 != 0) {
				if(allow)
					allow = false;
				else 
					return false;
			}
		}
		return true;
	}
}
