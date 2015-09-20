//AC
package summer;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class A_4 {
	public static void main(String args[]) throws Exception
	{
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(input.readLine());
		if(n==1 || n==2)
			System.out.println("NO");
		else if(n%2==0)
			System.out.println("YES");
		else
			System.out.println("NO");
	}
}
