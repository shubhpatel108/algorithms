package summer;
//Ac

public class single_number {
	public static void main(String args[])throws Exception
	{
		int num[] = {1,1,1,1,2,3,4,4,3};
		int x=0;
        for(int i=0; i<num.length;i++)
        {
            x ^=num[i];
        }
        System.out.println(x);
	}
}
