import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;


public class IcecreamParlor {
	public static void main(String args[])throws Exception {
		BufferedReader input = new BufferedReader(
				new InputStreamReader(System.in));
		
		int t = Integer.parseInt(input.readLine());
		
		while(t-->0) {
			int m = Integer.parseInt(input.readLine());
			int n = Integer.parseInt(input.readLine());
			String ts[] = input.readLine().split(" ");
			
			Node[] arr = new Node[n];
			for(int i=0;i<n;i++) {
				arr[i] = new Node(Integer.parseInt(ts[i]), i+1);
			}
			
			Arrays.sort(arr, new Node.NodeCompare());
			
			int i=0, j=n-1;
			while(i<j) {
				if(arr[i].val + arr[j].val == m) {
					int min = Math.min(arr[i].index,arr[j].index);
					int max = (arr[i].index + arr[j].index) - min;
					System.out.println(min + " " + max);
					break;
				} else if(arr[i].val + arr[j].val < m) {
					i++;
				} else
					j--;
			}
		}
	}
}
