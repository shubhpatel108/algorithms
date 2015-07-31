//multiple transactions

public class max_profit {
	public static void main(String args[]) throws Exception
	{
		int array[] = {3,3,5,0,0,3,1,4};
		System.out.println(maxProfit(array));
	}
	public static int maxProfit(int[] prices) {
        if(prices.length < 2)
        	return 0;
        
        int index = 0;
        int len = prices.length;
        
        int min = prices[0];
        int max = prices[0];
        int profit = 0;
        
        for(;index<len;index++)
        {
        	if(prices[index]==0)
        		continue;
        	while(index<len && prices[index]<=min )
        	{
        		min = prices[index];
        		max = prices[index];
        		index++;
        	}
        	while(index<len && prices[index]>max)
        	{
        		max = prices[index];
        		index++;
        	}

        	profit += (max - min);
        	min = max;
        }
        return profit;
    }
}
