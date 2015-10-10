//AC
public class WidgetRepairs {
	public int days(int[] work, int perDay) {
		int n = work.length;
		int rem = 0;
		int total = 0;
		for(int i=0;i<n;i++) {
            if((work[i]+rem) <= perDay && (work[i]+rem) !=0) {
                total++;
                rem = 0;
            } else if(work[i]+rem!=0){
                rem = (work[i] + rem) - perDay;
                total++;
            }
		}
        total += (int)Math.ceil((double)rem/perDay);
		return total;
	}
}
