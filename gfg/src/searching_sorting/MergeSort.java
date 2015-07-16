package searching_sorting;

public class MergeSort {
	public int[] mergeSort(int[] arr, int l, int r) {
		if(l<r) {
			int m = l + (r-l)/2;
			mergeSort(arr, l, m);
			mergeSort(arr, m+1,r);
			merge(arr, l, m, r);
		}
		return arr;
	}
	
	public int[] merge(int[] arr, int l, int m, int r) {
		int n1 = m - l + 1;
		int n2 = r - m;
		int[] leftArr = new int[n1];
		int[] rightArr = new int[n2];
		
		for(int i=0; i<n1 ;i++)
			leftArr[i] = arr[i+l];
		for(int i=0; i<n2; i++)
			rightArr[i] = arr[i+m+1];
		
		int i=0;
		int j=0;
		int k=l;
		while(i<n1 && j<n2) {
			if(leftArr[i]<rightArr[j]) {
				arr[k] = leftArr[i];
				i++;
			} else {
				arr[k] = rightArr[j];
				j++;
			}
			k++;
		}
		while(i<n1) {
			arr[k] = leftArr[i];
			i++;
			k++;
		}
		while(j<n2) {
			arr[k] = rightArr[j];
			j++;
			k++;
		}
		return arr;
	}
}
