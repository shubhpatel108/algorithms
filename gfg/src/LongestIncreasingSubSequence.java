
public class LongestIncreasingSubSequence {
	static int[] endElements;
	
	public static void main(String[] args)throws Exception {
		int[] arr = {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15};
		System.out.println(lisLen(arr));
	}
	
	public static int lisLen(int[] arr) {
		int n = arr.length;
		endElements = new int[n];
		
		endElements[0] = arr[0];
		int len = 1;
		
		for(int i=1;i<n;i++) {
			if(endElements[0] > arr[i]) {
				endElements[0] = arr[i];
			} else if(endElements[len-1] < arr[i]) {
				endElements[len++] = arr[i];
			} else {
				endElements[ceilIndex(-1, len-1, arr[i])] = arr[i];
			}
		}
		return len;
	}
	
	public static int ceilIndex(int l, int r, int key) {
		while(r-l > 1) {
			int m = l + (r-l)/2;
			if(endElements[m] >= key)
				r = m;
			else
				l = m;
		}
		return r;
	}
}
