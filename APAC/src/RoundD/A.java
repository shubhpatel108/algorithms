package RoundD;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class A {
	static boolean arr[][];
	static int ans;
	static boolean visited[][];
	static int r;
	static int c;
	
	public static void main(String args[])throws Exception {
		BufferedReader input = new BufferedReader(
				new InputStreamReader(System.in));
		
		int T = Integer.parseInt(input.readLine());
		
//		
		for(int t=1;t<=T;t++) {
			System.out.println("Case #"+t+":");
			String[] tokens = input.readLine().split(" ");
			r = Integer.parseInt(tokens[0]);
			c = Integer.parseInt(tokens[1]);
			arr = new boolean[r][c];
			visited = new boolean[r][c];

			for (int i = 0; i < r; i++) {
				char[] line = input.readLine().toCharArray();
				for (int j = 0; j < c; j++) {
					arr[i][j] = line[j] == '1';
				}
			}

			int n = Integer.parseInt(input.readLine());
			for (int i = 0; i < n; i++) {
				tokens = input.readLine().split(" ");
				
				if(tokens[0].equals("Q")) {
					System.out.println(getAns());
				} else {
					update(Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]), Integer.parseInt(tokens[3]));
				}
			}
		}
	}
	
	public static void getComp(int i, int j) {
		if(i<0 || j>=c || j<0 || i>=r)
			return;

		if(!arr[i][j] || visited[i][j])
			return;
		
		visited[i][j] = true;
		
		getComp(i+1, j);
		getComp(i, j+1);
		getComp(i-1, j);
		getComp(i, j-1);
	}
	
	public static int getAns() {
		
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				visited[i][j] = false;
			}
		}
		
		int count = 0;
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if(arr[i][j] && !visited[i][j]) {
					count++;
					getComp(i, j);
				}
			}
		}
		return count;
	}
	
	public static void update(int i, int j, int z) {
		boolean newv = z == 1;

		arr[i][j] = newv;
	}

}
