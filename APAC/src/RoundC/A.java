package RoundC;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class A {
	public static void main(String args[])throws Exception {
		BufferedReader input = new BufferedReader(
				new InputStreamReader(System.in));
		
		int T = Integer.parseInt(input.readLine());
		
		for(int t=1;t<=T;t++) {
			String[] tokens = input.readLine().split(" ");
			int n = Integer.parseInt(tokens[0]);
			
			tokens = input.readLine().split(" ");
			int[] scores = new int[n];
			for(int i=0;i<n;i++) {
				scores[i] = Integer.parseInt(tokens[i]);
			}
			
			HashMap<String, Integer> hm = new HashMap<String, Integer>();
			ArrayList<Person> list = new ArrayList<Person>();

			int k = Integer.parseInt(input.readLine());
			
			while(k-->0) {
				tokens = input.readLine().split(" ");
				int weight = Integer.parseInt(tokens[0]);
				
				for(int i=1;i<=n;i++) {
					if(hm.containsKey(tokens[i])) {
						list.get(hm.get(tokens[i])).scores.add(weight*scores[i-1]);
					} else {
						Person newPerson = new Person(tokens[i]);
						newPerson.scores.add(weight*scores[i-1]);
						list.add(newPerson);
						hm.put(tokens[i], list.size()-1);
					}
				}
			}
			
			int m = Integer.parseInt(input.readLine());

			for(Person p: list) {
				int count=0;
				while(!p.scores.isEmpty() && count<m) {
					p.total += p.scores.poll();
					count++;
				}
			}

			Collections.sort(list, new Person.PersonCompare());
			
			System.out.println("Case #"+t+":");
			long lastscore = -1;
			int rank = 0;
			
			for(int i=0;i<list.size();i++) {
				if(list.get(i).total != lastscore)
					rank = i+1;

				System.out.println(rank + ": "+ list.get(i).name);
				lastscore = list.get(i).total;
			}			
		}
	}
}
