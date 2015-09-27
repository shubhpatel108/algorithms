import java.util.Arrays;
import java.util.Scanner;

public class Pancakes {
	static int[] freq;
	static int[] effort;
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		int T = input.nextInt();
		
		for(int t=1; t<=T; t++) {
			int N = input.nextInt();
			
			int[] arr = new int[N];
			int max = 0;
			for(int i=0; i<N; i++) {
				int num = input.nextInt();
				arr[i] = num;
				if(num>max) 
					max = num;
			}
			int ans = 0;
			
			if(max<4)
				ans = max;
			else {
				freq = new int[max+1];
				effort = new int[max+1];
				effort[1] = 1;
				effort[2] = 2;
				effort[3] = 3;
				
				for(int num:arr)
					freq[num]++;
				ans = calcEffort(max, freq[max]);
			}

			System.out.println("Case #"+t+": "+ans);
		}
	}
	
	public static int calcEffort(int n, int fre) {
		System.out.println("n : "+ n +"fre:"+ fre + Arrays.toString(effort));
		
		if(effort[n]!=0)
			return effort[n];

		int e1 = calcEffort((int)Math.ceil((double)n/2), freq[(int)Math.ceil((double)n/2)] + fre);
		int e2 = calcEffort((int)Math.floor((double)n/2), freq[(int)Math.floor((double)n/2)] + fre);
		
		if(Math.max(e1, e2) + fre >= n){
			effort[n] = n;
		} else {
			effort[n] = Math.max(e1, e2) + fre;
			freq[n] += fre;
		}
		return effort[n];
	}
}
