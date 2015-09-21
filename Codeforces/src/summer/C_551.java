package summer;
//WA
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class C_551 {
	public static void main(String args[])throws Exception
	{
		String[] toks;
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		
		toks = input.readLine().split(" ");
		int n = Integer.parseInt(toks[0]);
		int m = Integer.parseInt(toks[1]);
		
		int[] boxes = new int[n];
		int[] students = new int[n];
		int time = 0;
		
		toks = input.readLine().split(" ");
		for(int i=0;i<n;i++)
			boxes[i] = Integer.parseInt(toks[i]);
		
		students[0] = m;
		time++;
		
		int first_stud = 0, last_stud = 0;
		while(first_stud<n && last_stud<n)
		{
			if(first_stud==n-1 && last_stud==n-1 && boxes[n-1]==0)
				break;
			for(int i=last_stud;i>=first_stud;i--)
			{
				if(boxes[i]<students[i]) {
					if(i+1<n)
					{
						students[i+1] += students[i] - boxes[i];
						students[i] = boxes[i];
						if(i+1>last_stud)
							last_stud++;
					}
					boxes[i] = 0;
					if(i==first_stud && students[i]==0)
						first_stud++;
				}
				else {
					boxes[i] -= students[i];
				}
				
			}
			time++;
		}
		System.out.println(time);
	}
}
