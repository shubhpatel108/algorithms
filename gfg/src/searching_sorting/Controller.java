package searching_sorting;

import java.util.Arrays;

public class Controller {
	public static void main(String[] args)throws Exception {
		
		int[] arr = {1, 4, 3, 5, 6, 2};		
		double[] arr1 = {0.123, 0.344, 0.99, 0.5, 0.244, 0.7};
		int[] arr2 = {15,23,66,78,97,12};

//		InsertionSort insertionSort = new InsertionSort();
//		int[] ans = insertionSort.sort(arr);
		
//		MergeSort ms = new MergeSort();
//		int[] ans = ms.mergeSort(arr, 0, arr.length-1);
		
//		Heap heap = new Heap(arr);
//		int[] ans = Heap.heapSort(heap);
		
//		QuickSort qs = new QuickSort();
//		int[] ans = qs.sort(arr, 0, arr.length-1);
		
//		CountingSort cs = new CountingSort();
//		int[] ans = cs.sort(arr);
		
//		BucketSort bs = new BucketSort();
//		double[] ans = bs.sortDecimal(arr1);
		
//		ShellSort sc = new ShellSort();
//		int[] ans = sc.sort(arr2);
//			
//		System.out.println(Arrays.toString(ans));
	
		TernarySearch ts = new TernarySearch();
		Arrays.sort(arr2);
		System.out.println(Arrays.toString(arr2));
		int key = 78;
		System.out.println(ts.search(arr2, 0, arr2.length, key));
	}
}
