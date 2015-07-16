package searching_sorting;

import java.util.Arrays;

public class InsertionSort {
	public int[] sort(int[] arr) {
		if(arr==null)
			return null;
		
		int length = arr.length;
		if(length<2)
			return arr;
		
		for(int i=1;i<length;i++) {
			int j=i;
			while(j>0 && arr[j]<arr[j-1]) {
				int temp = arr[j];
				arr[j] = arr[j-1];
				arr[j-1] = temp;
				j--;
			}
			printArray(arr);
		}
		return arr;	
	}
	
    private static void printArray(int[] ar) {
        for(int n: ar){
           System.out.print(n+" ");
        }
          System.out.println("");
     }
}
