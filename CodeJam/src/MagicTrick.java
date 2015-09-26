import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
public class MagicTrick {
	public static void main(String args[])throws Exception
	{
		
		File file = new File("/home/shubham/filename.txt");
		 
		// if file doesnt exists, then create it
		if (!file.exists()) {
			file.createNewFile();
		}

		FileWriter fw = new FileWriter(file.getAbsoluteFile());
		BufferedWriter bw = new BufferedWriter(fw);
		
		BufferedReader input = new BufferedReader( new InputStreamReader(System.in));
		int n = Integer.parseInt(input.readLine());
		int row,i,j;
		String ans="";
		String line,line2="";
		String tok[];
		ArrayList<String> hm = new ArrayList<String>();
		int count=0;
		int test = 1;
		while(test<=n)
		{
			row = Integer.parseInt(input.readLine()) - 1;
			for(i=0;i<4;i++)
			{
				line = input.readLine();
				if(i==row)
					hm.addAll(Arrays.asList(line.split(" ")));
			}
			row = Integer.parseInt(input.readLine()) - 1;
			for(i=0;i<4;i++)
			{
				line = input.readLine();
				if(i==row)
					line2 = line;
			}
			tok = line2.split(" ");
			for(String t:tok)
			{
				if(hm.contains(t)) {
					count++;
					ans = t;
				}
			}
			if(count>1) bw.write("Case #" + (test) + ": Bad Magician!\n");
			else if(count==1) bw.write("Case #" + (test) + ": " + ans+"\n");
			else bw.write("Case #" + (test) + ": Volunteer cheated!"+"\n");
			hm.clear();
			count = 0;
			test++;
		}
		bw.close();
	}
}
