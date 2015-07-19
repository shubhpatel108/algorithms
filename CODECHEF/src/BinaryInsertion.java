import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
public class BinaryInsertion {
	static ArrayList<Integer> num  = new ArrayList<Integer>();
public static void main(String args[]) throws IOException
{
//	BufferedReader input = new BufferedReader (new InputStreamReader(System.in));
	int n,k,x;
	int min = Integer.MAX_VALUE;
//	n = Integer.parseInt(input.readLine());
//	k = Integer.parseInt(input.readLine());
	Scanner input = new Scanner (System.in);
	n = input.nextInt();
//	k = input.nextInt();

	while(n>0)
	{
		x = (input.nextInt());
		insert(x);
		System.out.println(num.toString());
		n--;
	}
//	for(int i=0;i<num.size();i++)
//	{
//		System.out.println(num.get(i));
//	}
}

public static void insert(int number)
{
	if(num.isEmpty() || num.get(num.size()-1)<=number)
	{
	num.add(number);	
	}
	else if(num.get(0)>=number)
	{
		num.add(0, number);
	}
	else
	{
		int middle=0;
		int s = 0;
		int p = num.size() - 1;
		while(s<p)
		{
			middle = (s+p)/2;
			if(num.get(middle)<=number)
			{
				if(num.get(middle+1)>=number)
				{
					num.add(middle+1, number);
					return;
				}
				else
				{
					s = middle + 1;
					continue;
				}
			}
			else
			{
				if(num.get(middle-1)<=number)
				{
					num.add(middle, number);
					return;
				}
				else
				{
					p = middle - 1;
					continue;
				}
			}
		}
	}
	}
}