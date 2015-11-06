package RoundB;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B {
	public static void main(String args[])throws Exception {
		BufferedReader input = new BufferedReader(
				new InputStreamReader(System.in));
		int no = Integer.parseInt(input.readLine());

		for(int y=1;y<=no;y++) {
			input.readLine();
			String[] tokens = input.readLine().split(" ");
			int f = Integer.parseInt(tokens[0]);
			int s = Integer.parseInt(tokens[1]);
			int t = Integer.parseInt(tokens[2]);
			
			int first[] = new int[f];
			int second[] = new int[s];
			int third[] = new int[t];
			
			tokens = input.readLine().split(" ");
			for(int i=0;i<f;i++)
				first[i] = Integer.parseInt(tokens[i]);
			
			tokens = input.readLine().split(" ");
			for(int i=0;i<s;i++)
				second[i] = Integer.parseInt(tokens[i]);

			tokens = input.readLine().split(" ");
			for(int i=0;i<t;i++)
				third[i] = Integer.parseInt(tokens[i]);
			
			tokens = input.readLine().split(" ");
			int queries = Integer.parseInt(tokens[0]);
			
			System.out.println("Case #"+y+": ");
			for(int i=0;i<queries;i++) {
				tokens = input.readLine().split(" ");
				int p =Integer.parseInt(tokens[0]);
				int q =Integer.parseInt(tokens[1]);
				System.out.println(ans(possible(first, second, third, f,s,t,p,q)));
			}
			
		}
	}

	public static boolean possible(int[] first, int[] second, int[]third, int f, int s, int t, int p, int q) {
		double ratio = 1;
		double req = (double)p/(double)q;
		
		for(int i=0;i<f;i++) {
			for(int j1=0;j1<s;j1++) {
				for(int j2=0;j2<s;j2++) {
					if(j1==j2)
						continue;
					for(int k=0;k<t;k++) {
						
						double fr = (double)first[i]/(double)second[j1];
						double sr = (double)second[j2]/(double)third[k];
						if(fr*sr == req && first[i]*second[j2] >= p && third[k]*second[j2] >= q) {
//							System.out.println(first[i]);
//							System.out.println(second[j1]);
//							System.out.println(second[j2]);
//							System.out.println(third[k]);
							return true;

						}
					}
				}
			}
		}
		return false;
	}
	
	public static String ans(boolean possible) {
		if(possible)
			return "Yes";
		else
			return "No";
	}
}
