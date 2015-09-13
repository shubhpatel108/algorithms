package implementation;

//AC
import java.util.Scanner;

public class A567 {
	public static void main(String[] args)throws Exception {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int[] arr = new int[n];
		for(int i=0;i<n;i++)
			arr[i] = input.nextInt();
		
		int i=0;
		
		System.out.println((arr[i+1] - arr[i]) +" "+ (arr[n-1] - arr[i]));
		i++;
		
		for(;i<n-1;i++)
			System.out.println(Math.min((arr[i+1]-arr[i]), (arr[i]-arr[i-1])) + " "+
					Math.max((arr[n-1]-arr[i]), (arr[i]-arr[0])));
		System.out.println((arr[n-1] - arr[n-2]) +" "+ (arr[n-1] - arr[0]));
	}
}
