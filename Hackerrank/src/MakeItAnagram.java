import java.io.BufferedReader;
import java.io.InputStreamReader;


public class MakeItAnagram {
	public static void main(String args[])throws Exception {
		BufferedReader input = new BufferedReader(
				new InputStreamReader(System.in));
		
		String s1 = input.readLine();
		int len1 = s1.length();
		int arr1[] = new int[26];
		
		for(int i=0;i<len1;i++)
			arr1[s1.charAt(i) - 97]++;
		
		String s2 = input.readLine();
		int len2 = s2.length();
		int arr2[] = new int[26];
		
		for(int i=0;i<len2;i++)
			arr2[s2.charAt(i) - 97]++;
		
		int count = 0;
		for(int i=0;i<26;i++)
			count += Math.abs(arr1[i] - arr2[i]);
		System.out.println(count);
	}
}
