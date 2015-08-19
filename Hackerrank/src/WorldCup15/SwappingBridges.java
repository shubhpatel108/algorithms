package WorldCup15;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SwappingBridges {

	static int parents[];
	static int ranks[];
	
	public static void main(String args[])throws Exception {
		
		BufferedReader input = new BufferedReader(
				new InputStreamReader(System.in));
		String[] tokens = input.readLine().split(" ");
		
		int t = Integer.parseInt(tokens[0]);
		
		while(t-->0) {
			int n = Integer.parseInt(input.readLine());
			parents = new int[n + 1];
			ranks = new int[n + 1];

			for(int i=0;i<=n;i++)
				parents[i] = -1;
			
			tokens = input.readLine().split(" ");
			
			int arr[] = new int[n];
			for(int i=0;i<n;i++)
				arr[i] = Integer.parseInt(tokens[i]);
			
			for(int i=0;i<n;i++) {
				if(arr[i] != arr[arr[i]-1]) {
					union(arr[i], arr[arr[i]-1]);
				}
			}
			int count = 0;
			for(int i=1;i<=n;i++) {
				if(parents[i] == -1) {
					count++;
				}
			}
			System.out.println(count-1);
		}
	}
	
	public static boolean union(int i, int j) {
		int x = find(i);
		int y = find(j);
		
		if(x == y)
			return false;

		if(ranks[x] > ranks[y]) {
			parents[y] = x;
		} else if(ranks[x] < ranks[y]){
			parents[x] = y;
		} else {
			parents[y] = x;
			ranks[x]++;
		}
		return true;
	}
	
	public static int find(int i) {
		if(parents[i] == -1)
			return i;
		return find(parents[i]);
	}
}
