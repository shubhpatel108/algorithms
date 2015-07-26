//AC and TLE
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class WOUT {
	public static void main(String[] args)throws Exception {
		BufferedReader input = new BufferedReader(
				new InputStreamReader(System.in));
		int t = Integer.parseInt(input.readLine());
		while(t-->0) {
			String tokens[] = input.readLine().split(" ");
			int n = Integer.parseInt(tokens[0]);
			int h = Integer.parseInt(tokens[1]);
			
			int[] blocks = new int[n];
			for(int i=0;i<n;i++) {
				tokens = input.readLine().split(" ");
				int up = Integer.parseInt(tokens[1]);
				int down = Integer.parseInt(tokens[0]);
				
				for(int j=0;j<down;j++)
					blocks[j]++;
				for(int j=up+1;j<n;j++)
					blocks[j]++;
			}
			
			int ans = 0;
			
//			System.out.println(Arrays.toString(blocks));
			
			for(int i=1;i<n;i++) {
				blocks[i] += blocks[i-1];
			}
			
			int min = blocks[h-1];
			for(int i=h;i<n;i++) {
				if(blocks[i]-blocks[i-h] < min) {
					min = blocks[i]-blocks[i-h];
				}
			}
			System.out.println(min);
		}
	}
}
