//AC
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class GRGUY {
	public static void main(String args[])throws Exception {
		BufferedReader input = new BufferedReader(
				new InputStreamReader(System.in));
		String[] tokens = input.readLine().split(" ");
		int n = Integer.parseInt(tokens[0]);
		while(n-->0) {
			String line = input.readLine();
			char[][] lane = new char[2][line.length()];
			lane[0] = line.toCharArray();
			line = input.readLine();
			lane[1] = line.toCharArray();
			int length = line.length();
			int ans = 0;
			boolean possible = true;
			int i=0;
			int last = -1;
			
			while(i<length) {
				if(lane[0][i]=='.' && lane[1][i]=='.') {
					i++;
					continue;
				}
				else if(lane[0][i]=='#' && lane[1][i]=='#') {
					possible = false;
					break;
				} else {
					if(lane[0][i]=='.') {
						if(last==1)
							ans++;
						last = 0;
					} else {
						if(last==0)
							ans++;
						last = 1;
					}
				}
				i++;
			}
			if(possible) {
				System.out.println("Yes");
				System.out.println(ans);
			} else {
				System.out.println("No");
			}
			
		}
	}

}
