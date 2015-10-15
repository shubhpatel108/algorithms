//AC
package Greedy;

import java.util.Arrays;

public class WorldPeace {
	public long numGroups(int k, int[] countries) {
		int n = countries.length;
		long total = 0;
		if(k>n)
			return 0;
		
		Arrays.sort(countries);

		while(countries[n-k] != 0) {
			long group = (countries[n-k]+999)/1000;
			total += group;
			for(int i=n-k; i<n;i++) {
				countries[i] -= group;
			}
			Arrays.sort(countries);
		}
		
		return total;
	}
}
