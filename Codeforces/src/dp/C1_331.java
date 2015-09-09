//AC
package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.Comparator;
import java.util.PriorityQueue;

public class C1_331 {
	public static void main(String args[])throws Exception {
		BufferedReader input = new BufferedReader(
				new InputStreamReader(System.in));
		long n = Long.parseLong(input.readLine());
		System.out.println(calc(n,(long)0));
	}

	public static long calc(Long n, Long steps) {
		if(n == 0)
			return steps;
		int highestDigit = highestNum(n);
		return calc(n-highestDigit, steps + 1);
	}
	
	public static int highestNum(Long n) {
		PriorityQueue<Integer> q = new PriorityQueue<Integer>(1, new reverseCompare());
		while(n > 0) {
			q.add((int)(n%10));
			n /= 10;
		}
		return q.poll();
	}

	public static class reverseCompare implements Comparator<Integer> {

		@Override
		public int compare(Integer i, Integer j) {
			if(i>j)
				return -1;
			else if(i<j)
				return 1;
			else
				return 0;
		}

	}
}
