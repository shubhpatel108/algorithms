import java.io.BufferedReader;
import java.io.InputStreamReader;


public class ValidPanFormat {
	public static void main(String args[])throws Exception {
		BufferedReader input = new BufferedReader(
				new InputStreamReader(System.in));
		
		int t = Integer.parseInt(input.readLine());
		while(t-->0) {
			String s = input.readLine();
			int len = s.length();
			
			if(len!=10) {
				System.out.println("NO");
				continue;
			}
			boolean valid = true;
			for(int i=0;i<5 && valid;i++) {
				if(!Character.isUpperCase(s.charAt(i)))
					valid = false;
			}
			if(valid && Character.isUpperCase(s.charAt(9)) ) {
				for(int i=5;i<8 && valid;i++)
					if(!Character.isDigit(s.charAt(i)))
						valid = false;
			} else
				valid = false;
			
			if(valid)
				System.out.println("YES");
			else
				System.out.println("NO");
		}
	}
}
