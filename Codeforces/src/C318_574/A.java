//AC
package C318_574;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class A {
	public static void main(String args[])throws Exception {
		BufferedReader input = new BufferedReader(
				new InputStreamReader(System.in));
		
		String[] tokens = input.readLine().split(" ");
		int n = Integer.parseInt(tokens[0]);

		tokens = input.readLine().split(" ");
		int orig = Integer.parseInt(tokens[0]);
		PriorityQueue<Integer> q = new PriorityQueue<Integer>(1,new A.reverseCompare());
		
		int bribes = 0;
		for(int i=1;i<n;i++)
			q.add(Integer.parseInt(tokens[i]));

		while(true) {
			int x = q.poll();
			
			if(x>=orig) {
				q.add(x-1);
				orig++;
			}
			else
				break;
			
			bribes++;
		}
		System.out.println(bribes);
	}
	
	public static class reverseCompare implements Comparator<Integer>{

		@Override
		public int compare(Integer arg0, Integer arg1) {
			if(arg0 > arg1)
				return -1;
			if(arg0 < arg1)
				return 1;
			return 0;
		}
	}
}
