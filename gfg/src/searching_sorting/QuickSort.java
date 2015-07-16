package searching_sorting;

import java.util.Random;

public class QuickSort {
	public int partition(int arr[], int l, int r) {
		int i = l;
		
		Random rand = new Random();
		int randInd = l + rand.nextInt(r - l + 1);
		swap(arr, r, randInd);

		int x = arr[r];

		for(int j=l; j<r; j++) {
			if(arr[j]<=x) {
				swap(arr, i, j);
				i++;
			}
		}
		swap(arr, i, r);
		return i;
	}

	public int[] sort(int arr[], int l, int r){
		if(l < r) {
			int p = partition(arr, l, r);
			sort(arr, l, p-1);
			sort(arr, p+1, r);
		}
		return arr;
	}

	public void swap(int arr[], int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
