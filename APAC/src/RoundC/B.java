package RoundC;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class B {
	public static void main(String args[])throws Exception {
		BufferedReader input = new BufferedReader(
				new InputStreamReader(System.in));
		
		int T = Integer.parseInt(input.readLine());
		
		for(int t=1;t<=T;t++) {
			System.out.print("Case #"+t+": ");

			int n = Integer.parseInt(input.readLine());
			HashMap<Long, Integer> hm = new HashMap<Long, Integer>();

			boolean flag = true;
			for(int i=0;i<n;i++) {
				
				String[] tokens = input.readLine().split(" ");
				
				Long p = Long.parseLong(tokens[0]);
				Long k = Long.parseLong(tokens[1]);
			
				if(p==0)
					continue;

				long files = (k*100)/p;
				long num = files;

				while(((k*100)/num) == p) {
					if(flag || hm.containsKey(num))
						hm.put(num, hm.get(num) + 1);
					else
						hm.put(num, 1);
				}
				
				num = files-1;
				while(((k*100)/num) == p && num>=0) {
					if(flag || hm.containsKey(num))
						hm.put(num, hm.get(num) + 1);
					else
						hm.put(num, 1);
				}

				flag = false;
	
//				for(long mum : list) {
//					System.out.println(mum);
//				}

				
//			    System.out.println("=====");
			}

			int ans = -1;
			Iterator it = hm.entrySet().iterator();
		    while (it.hasNext()) {
		        Map.Entry pair = (Map.Entry)it.next();

		       if((int)pair.getValue() == n && ans == -1) {
		    	   ans = (int)pair.getValue();
		       } else if((int)pair.getValue() == n && ans != -1) {
		    	   ans = -1;
		    	   break;
		       }
		    }
			
			System.out.println(ans);
		}
	}
}
