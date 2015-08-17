//AC
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class TwoStrings {
	public static void main(String args[])throws Exception {
		BufferedReader input = new BufferedReader(
				new InputStreamReader(System.in));
		String[] tokens = input.readLine().split(" ");
		
		int t = Integer.parseInt(tokens[0]);
		
		while(t-->0) {
			String s1 = input.readLine();
			String s2 = input.readLine();
			int n1 = s1.length();
			int n2 = s2.length();
			
			int[] arr1 = new int[26];
			int[] arr2 = new int[26];

			boolean ans = false;
			
			for(int i=0;i<n1;i++)
				arr1[s1.charAt(i) - 97] ++;
			for(int i=0;i<n2;i++)
				arr2[s2.charAt(i) - 97] ++;
			
			for(int i=0;i<26;i++) {
				if(arr1[i] > 0 && arr2[i] > 0) {
					ans = true;
					break;
				}
			}
			
			if(ans)
				System.out.println("YES");
			else
				System.out.println("NO");
		}
	}

}
