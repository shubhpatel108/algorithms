//WA

import java.io.*;
public class DPC103 {
	public static void main(String args[]) throws Exception
	{
		try{
			BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
			String line;
			int i,j,c,r,k;
			int count = 0;
			String num[] = new String[2];
			char mine[][] = new char[1024][1024];
			int dx[] = {-1, 0, 1,-1,1, -1,0, 1};
			int dy[] = {-1, -1, -1,0,0, 1,1,1};
			while((line = input.readLine())!=null)
			{
				input.readLine();
				num = line.split(" ");
				r = Integer.parseInt(num[0]);
				c = Integer.parseInt(num[1]);
				if(r==0 && c==0)
					break;
				count++;
				int ans[][] = new int[r][c];
				for(i=0;i<r;i++)
				{
					line = input.readLine();
					for(j=0;j<c;j++)
					{
						mine[i][j] = line.charAt(j);
					}
				}
				
				for(i=0;i<r;i++)
				{
					for(j=0;j<c;j++)
					{
						if(mine[i][j]!='.')
						{
							for(k=0;k<8;k++)
							{
								if( i+ dx[k] >=0 && j + dy[k]>=0)
								if(mine[i+ dx[k]][j+dy[k]]=='.')
								ans[i+ dx[k]][j+dy[k]] += 1;
							}
							ans[i][j]=-1;
						}
						
					}
				}
				System.out.println("Field #" + count + ":");
				for(i=0;i<r;i++)
				{
					for(j=0;j<c;j++)
						if(ans[i][j]==-1)
							System.out.print("*");
						else
							System.out.print(ans[i][j]);
					System.out.println();
				}
			}
		}catch(Exception e){
			return;
		}
	}
}
