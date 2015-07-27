//AC
package SEPT15;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MSTEP {
	public static void main(String[] args)throws Exception {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(input.readLine());
		
		while(t-->0) {
			int n = Integer.parseInt(input.readLine());
			Node[] arr = new Node[n*n];
			int count = 0;
			for(int i=0;i<n;i++) {
				String[] ts = input.readLine().split(" ");
				for(int j=0;j<n;j++) {
					Node node = new Node(i, j, Integer.parseInt(ts[j]));
					arr[count++] = node;
				}
			}
			
			Arrays.sort(arr, new Node.NodeCompare());
			int ans = 0;
			for(int i=1;i<count;i++) {
				ans += Math.abs(arr[i].x - arr[i-1].x) + Math.abs(arr[i].y - arr[i-1].y);
			}
			System.out.println(ans);
		}
	}
}
