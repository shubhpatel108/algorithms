package summer;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class A_231 {
	public static void main(String args[])throws Exception
	{
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(input.readLine());
		int i = 0, ans=0, temp=0;
		String tokens[];
		while(i<n) {
			tokens = input.readLine().split(" ");
			temp = 0;
			for(int j=0;j<3;j++) {
				if(tokens[j].compareTo("1")==0)
					temp++;
			}
			if(temp>=2)
				ans++;
			i++;
		}
		System.out.println(ans);
	}
}
