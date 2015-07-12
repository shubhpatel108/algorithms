import java.util.Arrays;
import java.util.Iterator;
import java.util.PriorityQueue;

public class test {
	public static void main(String args[]) {
		String[] tokens = {"1"};
		long startTime = System.nanoTime();
		System.out.println(Integer.parseInt(tokens[0]) == 1);
		long endTime = System.nanoTime();
		System.out.println((endTime - startTime) / Math.pow(10, 6));
		
		startTime = System.nanoTime();
		System.out.println(tokens[0].equals("1"));
		endTime = System.nanoTime();
		System.out.println((endTime - startTime) / Math.pow(10, 6));
		System.out.println(Runtime.getRuntime().totalMemory());
	}
}
