import java.io.BufferedReader;
import java.io.InputStreamReader;


public class StringReduction {
	public static void main(String args[])throws Exception {
		BufferedReader input = new BufferedReader(
				new InputStreamReader(System.in));
		
		int t = Integer.parseInt(input.readLine());
		
		while(t-->0) {
			String s = input.readLine();
			int[] arr = new int[3];
			int n = s.length();
			int ans = 0;
			for(int i=0;i<n;i++) {
				arr[s.charAt(i) - 97]++;
			}
			if(arr[0]==n || arr[1]==n ||arr[2]==n)
				ans = n;
			else if(arr[0]%2==0 && arr[1]%2==0 && arr[2]%2==0)
				ans = 2;
			else if(arr[0]%2==1 && arr[1]%2==1 && arr[2]%2==1)
				ans = 2;
			else
				ans = 1;
			System.out.println(ans);
		}
	}
}
