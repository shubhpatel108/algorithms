package summer;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class A_50 {
	public static void main(String args[])throws Exception
	{
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		String tokens[] = input.readLine().split(" ");

		int m = Integer.parseInt(tokens[0]);
		int n = Integer.parseInt(tokens[1]);
		if(n<m)
		{
			int temp = m;
			m = n;
			n = temp;
		}
		int mul = n/2;
		System.out.println(m * mul + (n - mul*2)*(m/2));
	}
}
