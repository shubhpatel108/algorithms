//AC
package implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class A349 {
	public static void main(String args[])throws Exception {
		BufferedReader input = new BufferedReader(
				new InputStreamReader(System.in));
		
		int n = Integer.parseInt(input.readLine());
		String[] tokens = input.readLine().split(" ");
		int[] arr = new int[n];
		for(int i=0;i<n;i++)
			arr[i] = Integer.parseInt(tokens[i]);
		
		int change[] = new int[3];
		boolean flag = true;
		
		for(int i=0;i<n;i++) {
			if(arr[i] == 25)
				change[0]++;
			else if(arr[i]==50) {
				if(change[0]>0) {
					change[0]--;
					change[1]++;
				}
				else {
					flag = false;
					break;
				}
			} else {
				if(change[1]>0 && change[0]>0) {
					change[2]++;
					change[0]--;
					change[1]--;
				} else if(change[0]>2) {
					change[0] -= 3;
					change[2]++;
				} else {
					flag = false;
					break;
				}
			}
		}
		
		if(flag)
			System.out.println("YES");
		else 
			System.out.println("NO");
	}
}
