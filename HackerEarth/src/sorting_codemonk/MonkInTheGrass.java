package sorting_codemonk;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class MonkInTheGrass {
	public static void main(String args[])throws Exception {
		BufferedReader input = new BufferedReader(
				new InputStreamReader(System.in));
		String[] tokens = input.readLine().split(" ");
		
		int t = Integer.parseInt(tokens[0]);
		
		while(t-->0) {
			tokens = input.readLine().split(" ");
			int n = Integer.parseInt(tokens[0]);
			int k = Integer.parseInt(tokens[1]);
			
			PriorityQueue<Long> qcol = new PriorityQueue<Long>();
			PriorityQueue<Long> qrow = new PriorityQueue<Long>();
			
			long[] colsum = new long[n];

			for(int i=0;i<n;i++) {
				tokens = input.readLine().split(" ");
				long rowsum = 0;
				for(int j=0;j<n;j++) {
					int num =  Integer.parseInt(tokens[j]);
					colsum[j] += num;
					rowsum += num;
				}
				qrow.add(rowsum);
			}
			for(int i=0;i<n;i++)
				qcol.add(colsum[i]);
			
			long colset = 0;
			long rowset = 0;
			long min = 0;

			while(k-->0) {
				long numr = qrow.peek();
				long numc = qcol.peek();
				
				if(numr + rowset <= numc + colset) {
					min += rowset+numr;
					colset++;
					qrow.poll();
					qrow.add(numr+rowset+n);
				} else {
					min += colset+numc;
					rowset++;
					qcol.poll();
					qcol.add(numc+colset+n);
				}
			}
			System.out.println(min);
		}
	}
}
