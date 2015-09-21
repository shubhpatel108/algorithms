package summer;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class A_71 {
	public static void main(String args[])throws Exception
	{
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(input.readLine());
		int i = 0;
		int len = 0;
		String line;
		while(i<n) {
			line = input.readLine();
			len = line.length();
			if(line.length()>10){
				System.out.println(line.charAt(0) + String.valueOf(len-2) + line.charAt(len-1));
			} else {
				System.out.println(line);
			}
			i++;
		}
	}
}
