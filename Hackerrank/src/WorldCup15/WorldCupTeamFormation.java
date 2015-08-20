//https://www.hackerrank.com/contests/worldcup/challenges/world-cup-team-formation
package WorldCup15;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class WorldCupTeamFormation {
	public static void main(String args[])throws Exception {
		BufferedReader input = new BufferedReader(
				new InputStreamReader(System.in));
		
		int n = 10;
		int[] arr = new int[n];

		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(input.readLine());
		}
		Arrays.sort(arr);
		System.out.println(arr[n-1]+arr[n-3]+arr[n-5]);
	}
}
