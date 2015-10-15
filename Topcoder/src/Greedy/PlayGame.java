//AC
package Greedy;

import java.util.Arrays;

public class PlayGame {
	public int saveCreatures(int[] you, int[] comp) {
		int ylen = you.length;
		int clen = comp.length;
		
		if(ylen==0 || clen==0)
			return 0;

		Arrays.sort(you);
		Arrays.sort(comp);
		int i=ylen-1, j=clen-1;
		int saved = 0;

		while(i>=0 && j>=0) {
			if(you[i] <= comp[j]) {
				j--;
			} else {
				saved += you[i];
				i--;
				j--;
			}
		}
		return saved;
	}
}
