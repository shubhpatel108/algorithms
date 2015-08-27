//WA
package C316;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class B572 {
	public static void main(String args[])throws Exception {
		BufferedReader input = new BufferedReader(
				new InputStreamReader(System.in));
		
		String[] tokens = input.readLine().split(" ");
		int n = Integer.parseInt(tokens[0]);
		int s = Integer.parseInt(tokens[1]);
		PriorityQueue<Order> pqS = new PriorityQueue<Order>(1, new Order.OrderCompare());
		PriorityQueue<Order> pqB = new PriorityQueue<Order>(1, new Order.OrderCompare());
		
		for(int i=0;i<n;i++) {
			tokens = input.readLine().split(" ");
			Order o = new Order(Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]));
			if(tokens[0].equals("S")) {
				pqS.add(o);
			} else {
				pqB.add(o);
			}
		}
		pqS = merge(pqS);
		pqB = merge(pqB);
		printQ(pqS, 'S', s);
		printQ(pqB, 'B', s);
	}
	
	public static PriorityQueue<Order> merge(PriorityQueue<Order> pq) {
		PriorityQueue<Order> newpq = new PriorityQueue<Order>(1, new Order.OrderCompare());
		if(pq.isEmpty())
			return pq;
		Order last = pq.poll();
		int total = last.total;
		int lastval = last.val;
		while(!pq.isEmpty()) {
			Order neworder = pq.poll();
			if(neworder.val == lastval) {
				total += neworder.total;
			} else {
				Order anotherone = new Order(lastval, total);
				newpq.add(anotherone);
				total = neworder.total;
				lastval = neworder.val;
				last = neworder;
			}
		}
		Order anotherone = new Order(lastval, total);
		newpq.add(anotherone);
		
		return newpq;
	}
	
	public static void printQ(PriorityQueue<Order> pqS, char c, int s) {
		while(s-->0 && !pqS.isEmpty()) {
			Order o = pqS.poll();
			System.out.println(c + " " + o.val +" "+o.total);
		}
	}
}
