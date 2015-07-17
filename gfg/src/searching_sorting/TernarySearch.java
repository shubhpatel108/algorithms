package searching_sorting;

public class TernarySearch {
	public int search(int[] arr, int l, int r, int key) {
		if(l>r)
			return -1;
		
		int mid1 = l + (r-l)/3;
		int mid2 = mid1 + (r-l)/3;
		
		if(key == arr[mid1])
			return mid1;
		else if(key == arr[mid2])
			return mid2;
		else if(key < arr[mid1])
			return search(arr, l, mid1-1, key);
		else if(key > arr[mid2])
			return search(arr, mid2+1, r, key);
		else
			return search(arr, mid1+1, mid2-1, key);
	}
}
