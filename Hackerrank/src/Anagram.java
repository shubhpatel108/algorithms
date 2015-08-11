//AC
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Anagram {
	public static void main(String args[])throws Exception {
		BufferedReader input = new BufferedReader(
				new InputStreamReader(System.in));
		String[] tokens = input.readLine().split(" ");
		
		int t = Integer.parseInt(tokens[0]);
		
		while(t-->0) {
			String line = input.readLine();
			int n = line.length();
			
			if(n%2!=0) {
				System.out.println(-1);
			} else {
				int[] arr1 = new int[26];
				int[] arr2 = new int[26];
				int i=0;
				for(;i<n/2;i++) {
					arr1[Character.toLowerCase(line.charAt(i)) - 97]++;
				}
				for(;i<n;i++) {
					arr2[Character.toLowerCase(line.charAt(i)) - 97]++;
				}
				
				int count = 0;
				for(i=0;i<26;i++) {
					if(arr1[i] > arr2[i]) {
						count += arr1[i] - arr2[i];
					}
				}
				System.out.println(count);
			}
		}
	}
}
