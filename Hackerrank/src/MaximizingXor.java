import java.io.BufferedReader;
import java.io.InputStreamReader;


public class MaximizingXor {
	public static void main(String args[])throws Exception {
		BufferedReader input = new BufferedReader(
				new InputStreamReader(System.in));
		
		int l = Integer.parseInt(input.readLine());
		int r = Integer.parseInt(input.readLine());
		int max = 0;
		for(int i=l;i<r;i++) {
			for(int j=i;j<r;j++) {
				int xor = i ^ j;
				if(max < xor)
					max = xor;
			}
		}
		System.out.println(max);
	}
}
