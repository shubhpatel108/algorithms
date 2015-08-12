import java.io.BufferedReader;
import java.io.InputStreamReader;


public class FlippingBits {
	public static void main(String args[])throws Exception {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(input.readLine());

		while(t-->0) {
			String s = input.readLine();
			long n = Long.parseLong(s);
			System.out.println(flipBits(n));
		}
	}
	
	static long flipBits(long n) {
	    String binary = Long.toBinaryString(n);
	    int len = binary.length();
	    int bits = 0;
	    long ans = 0;
	    while(bits < len) {
	    	if(binary.charAt(len - 1 - bits) == '0') {
	    		ans += (long)Math.pow(2, bits);
	    	}
	    	bits++;
	    }
	    while(bits < 32) {
	    	ans += (long)Math.pow(2, bits);
	    	bits++;
	    }
	    return ans;
	}
}
