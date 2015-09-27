//AC
import java.util.Scanner;

public class StandingOvation {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		int T = input.nextInt();
		
		for(int i=1; i<=T; i++) {
			int n = input.nextInt();
			String s = input.next();
			
			int required = 0;
			int total = 0;
			
			for(int j=0; j<=n; j++) {
				int k = Character.getNumericValue(s.charAt(j));

				if(total < j) {
					required += j - total;
					total += j - total;
				}
				total += k;
			}
			System.out.println("Case #"+i+": "+required);
		}
	}
}