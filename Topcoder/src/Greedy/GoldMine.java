//WA
package Greedy;

import java.util.Arrays;

public class GoldMine {
	int[][] probab;
	int[] profit;
	int[] allocation;
	int miners;
	int maxminiers = 6;
	public int[] getAllocation(String[] mines, int miners) {
		int n = mines.length;
		profit = new int[n];
		allocation = new int[n];
		probab = new int[n][maxminiers+1];
		this.miners = miners;
		
		for(int i=0;i<n;i++) {
			String[] tokens = mines[i].split(", ");
			for(int j=0;j<=maxminiers;j++) {
				probab[i][j] = Integer.parseInt(tokens[j]);
			}
		}
		
		for(int i=0;i<miners;i++) {
			int max = Integer.MIN_VALUE;
			int minIndex = 0;
			for(int j=0;j<n;j++) {
				int p = profit(j);
				if(p > max) {
					max = p;
					minIndex = j;
				}
			}
			allocation[minIndex]++;
			profit[minIndex] += max;
		}
		return allocation;
	}
	
	public int profit(int index) {
		int newprofit = 0;
		if(allocation[index] == maxminiers) {
			return Integer.MIN_VALUE;
		}
		int alotedminers = allocation[index] + 1;

		for(int i=0;i<=maxminiers;i++) {
			if(alotedminers < i) {
				newprofit += (alotedminers)*probab[index][i]*60/100;
			} else if(alotedminers > i) {
				newprofit += (i)*probab[index][i]*50/100;
				newprofit -= (i - alotedminers)*probab[index][i]*20/100;
			} else {
				newprofit += (alotedminers)*probab[index][i]*50/100;
			}
		}
		return (newprofit - profit[index]);
	}
	
	public void calcProfit(int[] allocation) {
		int n = allocation.length;
		int sum = 0;
		for(int j=0;j<n;j++) {
			int alotedminers = allocation[j];
			for(int i=0;i<=maxminiers;i++) {
				if(alotedminers < i) {
					sum += (alotedminers)*probab[j][i]*60/100;
				} else if(alotedminers > i) {
					sum += (i)*probab[j][i]*50/100;
					sum -= (alotedminers - i)*probab[j][i]*20/100;
				} else {
					sum += (alotedminers)*probab[j][i]*50/100;
				}
			}	
		}
		System.out.println(sum);
	}
}
