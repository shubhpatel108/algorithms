package searching_sorting;

public class Heap {
	int[] arr;
	int length;
	
	public Heap(int[] a) {
		this.arr = a;
		this.length = a.length; 
	}
	
	public void maxHeapify(int index) {
		int largest = index;
		int left = index*2 + 1;
		int right = index*2 + 2;
		
		if(left<length && arr[left]>arr[largest]) {
			largest = left;
		}
		if(right<length && arr[right]>arr[largest]) {
			largest = right;
		}
		
		if(largest!=index) {
			int temp = arr[index];
			arr[index] = arr[largest];
			arr[largest] = temp;
			
			maxHeapify(largest);
		}
	}
	
	public void buildHeap() {
		for(int i = length - 2/2; i>=0; i--) {
			maxHeapify(i);
		}
	}
	
	public static int[] heapSort(Heap heap) {
		heap.buildHeap();
		for(int i = heap.length - 1; i>0; i--) {
			int temp = heap.arr[i];
			heap.arr[i] = heap.arr[0];
			heap.arr[0] = temp;
			heap.length--;
			heap.maxHeapify(0);
		}
		return heap.arr;
	}
}
