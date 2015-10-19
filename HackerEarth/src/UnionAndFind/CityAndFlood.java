//AC - some inputs were in wrong format
package UnionAndFind;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CityAndFlood {
	static int parents[];
	static int ranks[];

	public static void main(String args[])throws Exception {
		BufferedReader input = new BufferedReader(
				new InputStreamReader(System.in));
		
		int n = Integer.parseInt(input.readLine());
		int k = Integer.parseInt(input.readLine());
		
		parents = new int[n];
		Arrays.fill(parents, -1);
		ranks = new int[n];
		
		while(k-->0) {
			String[] tokens = input.readLine().split(" ");
			union(Integer.parseInt(tokens[0])-1, Integer.parseInt(tokens[1])-1);
		}
		
		int count = 0;
		for(int num : parents) {
			if(num<0)
				count++;
		}
		System.out.println(count);
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
