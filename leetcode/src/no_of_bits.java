
public class no_of_bits {
	public static void main(String args[])throws Exception
	{
		long l = Integer.toUnsignedLong(2147483648);
		System.out.println(hammingWeight(l));
	}
	public static long hammingWeight(long n) {
        int count =0;
        long n1 = n;
		while(n1>0) {
            count += n1%2;
            n1/=2;
        }
		return count;
    }
}
