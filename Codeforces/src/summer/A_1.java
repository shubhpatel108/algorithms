//AC
package summer;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class A_1 {
	public static void main(String args[])throws Exception
	{
		try {
			BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
			String tokens[];
			tokens = input.readLine().split(" ");
			long l = Long.valueOf(tokens[0]);
			long b = Long.valueOf(tokens[1]);
			long a = Long.valueOf(tokens[2]);
			long n = l/a;
			long m = b/a;
			if(l%a!=0)
				n+=1;
			if(b%a!=0)
				m+=1;
			
				System.out.println(n * m );
		} catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
}
