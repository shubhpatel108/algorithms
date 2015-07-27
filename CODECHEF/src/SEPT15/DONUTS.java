//AC
package SEPT15;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class DONUTS {
	public static void main(String args[])throws Exception {
		BufferedReader input = new BufferedReader(
				new InputStreamReader(System.in));
		
		int t = Integer.parseInt(input.readLine());
		
		while(t-->0) {
			String[] ts = input.readLine().split(" ");
			int n = Integer.parseInt(ts[0]);
			int m = Integer.parseInt(ts[1]);
			PriorityQueue<Integer> q = new PriorityQueue<Integer>();
			
			ts = input.readLine().split(" ");
			for(int i=0;i<m;i++)
				q.add(Integer.parseInt(ts[i]));	
			
			int rgps = m-1;
			int cuts = 0;

			while(rgps > 0 && !q.isEmpty()) {
				int num = q.poll();
				if(rgps < num) {
					cuts += rgps;
					rgps = 0;
				} else {
					cuts += num;
					rgps -= (num + 1);
				}
			}
			
			System.out.println(cuts);
		}
		
	}
}
