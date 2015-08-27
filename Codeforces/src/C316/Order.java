package C316;

import java.util.Comparator;

public class Order {
	int val;
	int total;
	
	public Order(int val, int total) {
		this.val = val;
		this.total = total;
	}
	
	public static class OrderCompare implements Comparator<Order>{
		
		@Override
		public int compare(Order p1, Order p2) {
			if(p1.val < p2.val)
				return 1;
			else if(p1.val > p2.val)
				return -1;
			else
				return 0;
		}

	}
}
