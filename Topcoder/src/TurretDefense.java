import java.util.Arrays;

public class TurretDefense {
    public int firstMiss(int[] xs, int[] ys, int[] times) {
        int n = times.length;
        for(int i=n-1;i>0;i--)
            times[i] = times[i] - times[i-1];
        
        int[] dist = new int[n];
        dist[0] = xs[0] + ys[0];
        for(int i=1;i<n;i++) {
            dist[i] = Math.abs(xs[i] - xs[i-1]) + Math.abs(ys[i] - ys[i-1]);
        }
        int i=0;
        while(i<n && times[i] >= dist[i]) {
            i++;
        }
        
        if(i==n)
            return -1;
        else
        	return i;
    }
}