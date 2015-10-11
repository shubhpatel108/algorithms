package Dp;

public class Controller {
	public static void main(String args[])throws Exception {
		ZigZag zg = new ZigZag();
		int[] seq = { 70, 55, 13, 2, 99, 2, 80, 80, 80, 80, 100, 19, 7, 5, 5, 5, 1000, 32, 32 };

		System.out.println(zg.longestZigZag(seq));
	}
}
