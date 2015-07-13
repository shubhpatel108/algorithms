//Character which appears in a string.
// Has frequency of its appearance as its attribute. 
package greedy;

import java.util.Comparator;

public class HuffmanNode {
	char character;
	int freq;
	String code;
	HuffmanNode left;
	HuffmanNode right;

	public HuffmanNode(char c, int freq) {
		this.character = c;
		this.freq = freq;
		left = null;
		right = null;
		code = null;
	}
	
	public HuffmanNode(int freq) {
		this.freq = freq;
	}
	
	public void incrementFreq() {
		this.freq++;
	}
	
	public static class HuffmanNodeCompare implements Comparator<HuffmanNode>{

		@Override
		public int compare(HuffmanNode n1, HuffmanNode n2) {
			if(n1.freq > n2.freq)
				return 1;
			if(n1.freq < n2.freq)
				return -1;
			
			return 0;
		}
		
	}
}
