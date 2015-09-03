//fails for larger inputs
package C335_586;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class C {
	static ArrayList<Node> arr = new ArrayList<Node>();

	public static void main(String args[])throws Exception {
		BufferedReader input = new BufferedReader(
				new InputStreamReader(System.in));
		
		String[] tokens = input.readLine().split(" ");
		long o = Long.parseLong(tokens[0]) - 1;
		long a = Long.parseLong(tokens[1]) - 1;
		
		if(solve(a, o, 0, 1, 1, 0)) {
			for(Node node : arr) {
				System.out.print(node.count + String.valueOf(node.c));
			}
			System.out.println();
		} else {
			System.out.println("Impossible");
		}
	}

	public static boolean solve(long a, long o, long aa, long ba, long ao, long bo) {
		if(a==0 && o==0) {
			return true;
		}

		if(ao <= o && aa <= a) {
			if(arr.size() > 0 && arr.get(arr.size()-1).c == 'A') {
				arr.get(arr.size()-1).count++;
			} else {
				arr.add(new Node('A'));
			}

			boolean possible = solve(a-aa, o-ao, aa, ba+aa, ao, bo+ao);
			if(possible)
				return true;
			
			if(arr.get(arr.size()-1).c == 'A') {
				if(arr.get(arr.size()-1).count == 1)
					arr.remove(arr.get(arr.size()-1));
				else
					arr.get(arr.size()-1).count--;
			}
		}

		if(bo <= o && ba <= a) {
			
			if(arr.size() > 0 && arr.get(arr.size()-1).c == 'B') {
				arr.get(arr.size()-1).count++;
			} else {
				arr.add(new Node('B'));
			}
			
			boolean possible = solve(a-ba, o-bo, aa+ba, ba, ao+bo, bo);
			if(possible)
				return true;
			
			if(arr.get(arr.size()-1).c == 'B') {
				if(arr.get(arr.size()-1).count == 1)
					arr.remove(arr.get(arr.size()-1));
				else
					arr.get(arr.size()-1).count--;
			}	
		}
		return false;
	}

	public static String compress(String s) {
		StringBuilder buff = new StringBuilder();
		int n = s.length();
		int i = 0;
		char last = s.charAt(0);
		int count = 0;

		while(i<n) {
			char c = s.charAt(i);
			if(c==last)
				count++;
			else {
				buff.append(count);
				buff.append(last);
				last = c;
				count = 1;
			}
			i++;
		}
		buff.append(count);
		buff.append(last);
		return buff.toString();
	}
}
