import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
class check {
	public static void main(String args[]) throws Exception {
		BufferedReader input = new BufferedReader
				(new InputStreamReader(System.in));
		String line = (input.readLine());
		String new_num = "";
		String num = String.valueOf(line);

		int length = num.length();
		int pow = length - 1;

		for(int i=0; i<length; i++) {
			new_num += String.valueOf(((Integer.parseInt(
					String.valueOf(num.charAt(i))) + 1)%10));
			pow--;
		}
		System.out.println(new_num);
	}
}
