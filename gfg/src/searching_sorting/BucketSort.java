package searching_sorting;

import java.util.Arrays;
import java.util.Vector;

public class BucketSort {
	public double[] sortDecimal(double[] arr) {
		if(arr == null)
			return null;
		int n = arr.length;
		Vector<Double>[] buckets = new Vector[n];
		for(int i=0;i<n;i++)
			buckets[i] = new Vector();
		for(double num:arr) {
			System.out.println((int)(n*num));
			buckets[(int)(n*num)].add(num);
		}

		int k = 0;
		for(int i=0;i<n;i++) {
			Object[] list = buckets[i].toArray();
			Arrays.sort(list);
			for(int j=0;j<list.length;j++) {
				arr[k] = (double)list[j];
				k++;
			}
		}
		return arr;
	}
}
