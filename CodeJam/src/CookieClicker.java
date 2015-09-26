//Not Working

import java.io.BufferedReader;
import java.io.InputStreamReader;
public class CookieClicker {
	static Double farm;
	public static void main(String args[]) throws Exception
	{
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(input.readLine());
		String line[];
		Double rate, target,ans =0.0;
		while(n-- >0)
		{
			line = input.readLine().split(" ");
			farm = Double.parseDouble(line[0]);
			rate = Double.parseDouble(line[1]);
			target = Double.parseDouble(line[2]);
			ans = calc(ans, target, 0.0, rate);
			System.out.println(ans);
			ans = 0.0;
		}
	}
	
	static Double calc(Double ans, Double target, Double pbal, Double rate)
	{	
		Double d_cost = (target-pbal)/rate;
		if(d_cost <= farm/rate)
		{
			ans += d_cost;
			return ans;
		}
		else
		{
			Double kharcho = farm/rate;
			ans = ans +kharcho;
			return ans + calc(ans, target, pbal-farm + kharcho*rate, rate+2);
		}
		
	}
}
