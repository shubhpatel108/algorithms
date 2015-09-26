//WA - algorithm is wrong! some scenarios not considered.
import java.io.*;
public class Minesweeper {
	public static void main(String args[])throws Exception
	{
		
		File file = new File("/home/shubham/filename.txt");
		 
		// if file doesnt exists, then create it
		if (!file.exists()) {
			file.createNewFile();
		}

		FileWriter fw = new FileWriter(file.getAbsoluteFile());
		BufferedWriter bw = new BufferedWriter(fw);
		
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(input.readLine());
		String t[];
		int count=0;
		int r,c,mines;
		int i,j;
		int flag=0;
		while(count<n)
		{
			bw.write("Case #" + (count+1)+":" + "\n");
			t = input.readLine().split(" ");
			r = Integer.parseInt(t[0]);
			c = Integer.parseInt(t[1]);
			mines = Integer.parseInt(t[2]);
			if(r==1){
				if(c==1)
					if(mines>0)
						bw.write("Impossible\n");
					else
						bw.write("c\n");
				else{
					if(c-mines>0)
					{
						bw.write("c");
						for(i=0;i<c-mines-1;i++)
							bw.write(".");
						for(i=0;i<mines;i++)
							bw.write("*");
						bw.write("\n");
					}
				}
			}
			else if(c==1)
			{
				if(r-mines>0)
				{
					bw.write("c\n");
					for(i=0;i<r-mines-1;i++)
						bw.write(".\n");
					for(i=0;i<mines;i++)
						bw.write("*\n");
				}
				else
					bw.write("Impossible\n");
			}
			else
			{
				int cells = r*c-mines -1;
				if(r*c-mines==1 || r*c-mines>=4)
				{
					if (r*c-mines>=4)
					{
						cells -=3;
						flag=1;
					}
						
					for(i=0;i<r;i++)
					{
						for(j=0;j<c;j++)
						{
							if(i==0 && j==0)
								bw.write("c");
							else if((i==0 || i==1) && (j==0 || j==1) && flag==1)
							{
								bw.write(".");
							}
							else if(cells>0)
							{
								bw.write(".");
								cells--;
							}
							else
								bw.write("*");
						}
						bw.write("\n");
					}
				}
				else
					bw.write("Impossible\n");
			}
			flag =0;
			count++;
		}
		bw.close();
	}
}
