//AC

import java.io.*;
public class TLG {
	public static void main(String args[]) throws Exception
	{
		try{
			BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
			int n = Integer.parseInt(input.readLine());
			int max = Integer.MIN_VALUE;
			int score1=0, score2=0;
			String tokens[];
			int winner = 0;
			while(n-->0)
			{
				tokens = input.readLine().split(" ");
				score1 += Integer.parseInt(tokens[0]);
				score2 += Integer.parseInt(tokens[1]);
				if(max<Math.abs(score1-score2))
				{
					if(score1>score2)
					{
						winner = 1;
						max = score1-score2;
					}
					else
					{
						winner = 2;
						max = score2-score1;
					}
				}
			}
			System.out.println(winner +" "+max);
		}catch(Exception e)
		{
			return;
		}
	}
}
