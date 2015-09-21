package summer;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B_158 {
	public static void main(String args[])throws Exception
	{
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(input.readLine());
		int arr[] = {0,0,0,0};
		int i=0;
		String tokens [] = input.readLine().split(" ");
		while(i<n) {
			arr[Integer.parseInt(tokens[i])-1]++;
			i++;
		}
		int ans = arr[3] + arr[1]/2;
		ans += arr[2];
		if(arr[0]>arr[2]) {
			ans += (arr[0] - arr[2])/4;
			if((arr[0] - arr[2])%4 > 2 && arr[1]%2!=0) {
				ans++;
			} else if((arr[0] - arr[2])%4!=0 && arr[1]%2==0){
				ans++;
			}
		}
		if(arr[1]%2!=0)
			ans++;
		System.out.println(ans);
	}
}
