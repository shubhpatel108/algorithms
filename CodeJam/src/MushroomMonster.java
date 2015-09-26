import java.util.Scanner;

// contest : https://code.google.com/codejam/contest/4224486/dashboard
// AC

public class MushroomMonster {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		int T = input.nextInt();
		
		for(int i=1; i<=T; i++) {
			int n = input.nextInt();
			int[] arr = new int[n];
			int maxDiff = 0;
			int ans1 = 0;
			
			arr[0] = input.nextInt();
			for(int j=1;j<n;j++) {
				arr[j] = input.nextInt();
				if(arr[j-1] - arr[j] > maxDiff)
					maxDiff = arr[j-1] - arr[j];
				if(arr[j] < arr[j-1])
					ans1 += arr[j-1] - arr[j];
			}
			
			int ans2 = 0;
			for(int j=0; j<n-1; j++) {
				ans2 += Math.min(arr[j], maxDiff);
			}
			System.out.println("Case #"+i+": " + ans1 + " " + ans2);
		}
	}
}
