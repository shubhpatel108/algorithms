//find the kth row of Pascal triangle
//Accepted

import java.util.*;

public class kth_pascal {

	public static void main(String args[])throws Exception
	{
		System.out.println(Row(3));
	}
	
	public static ArrayList<Integer> Row(int n) {
		int k;
		ArrayList<Integer> ans = new ArrayList<Integer>();
		ans.add(1);
		for(k=0;k<n;k++)
		{
			ans.add((ans.get(k)* (n-k)) / (k+1));
		}
		return ans;
	}
}
