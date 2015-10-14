//AC
package Greedy;

import java.util.ArrayList;
import java.util.Collections;

public class Boxing {
	public int maxCredit(int[] a, int[] b, int[] c, int[] d, int[] e) {
		int ca=0,cb=0,cc=0,cd=0,ce=0;
		int lena = a.length;
		int lenb = b.length;
		int lenc = c.length;
		int lend = d.length;
		int lene = e.length;
		
		int points = 0;
		while(ca < lena || cb < lenb || cc < lenc || cd < lend || ce < lene) {

			ArrayList<Integer> list = new ArrayList<Integer>();
			if(ca < lena)
				list.add(a[ca]);
			if(cb < lenb)
				list.add(b[cb]);
			if(cc < lenc)
				list.add(c[cc]);
			if(cd < lend)
				list.add(d[cd]);
			if(ce < lene)
				list.add(e[ce]);
			
			Collections.sort(list);
			while(list.size() > 3) {
				list.remove(list.size() - 1);
			}

			int min = 0;
			if(list.size() == 3) {
				if(list.get(1) - list.get(0) <= 1000) {
					if(list.get(2) - list.get(0) <= 1000) {
						min = list.get(2);
						points++;
						System.out.println(list.toString());
					} else {
						min = list.get(0);
					}
				} else {
					min = list.get(0);
				}
			}
			else
				break;
			
			if(ca < lena && a[ca]<=min) {
				while(ca < lena && a[ca]<=min) {
					ca++;
				}
			}
			if(cb < lenb && b[cb]<=min) {
				while(cb < lenb && b[cb]<=min) {
					cb++;
				}
			}
			if(cc < lenc && c[cc]<=min) {
				while(cc < lenc && c[cc]<=min) {
					cc++;
				}
			}
			if(cd < lend && d[cd]<=min) {
				while(cd < lend && d[cd]<=min) {
					cd++;
				}
			}
			if(ce < lene && e[ce]<=min) {
				while(ce < lene && e[ce]<=min) {
					ce++;
				}
			}
		}
		
		return points;
	}

}
