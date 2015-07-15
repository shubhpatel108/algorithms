package searching_sorting;

public class CountingSort {
	public int[] sort(int arr[]) {
		if(arr == null) 
			return null;
		int max = Integer.MIN_VALUE;
		for(int num:arr)
			if(num>max)
				max = num;
		int[] freq = new int[max+1];
		for(int num:arr)
				freq[num]++;
		
		int j=arr.length - 1;
		for(int i = max; i>=0 && j>=0; i--) {
			while(freq[i]!=0){
				arr[j] = i;
				j--;
				freq[i]--;
			}
		}
		return arr;
	}
}
