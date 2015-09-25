package Chap4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Stacks2 {
	public static void main(String[] args)throws Exception {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			String line = input.readLine();
			if(line.equals(""))
				break;
			else {
				String[] tokens = line.split(" ");
				int n = tokens.length;
				int[] arr = new int[n];
				for(int i=0;i<n;i++) {
					arr[i] = Integer.parseInt(tokens[i]);
				}
				int[] target = arr.clone(); 
				Arrays.sort(target);
				ArrayList<Integer> dummy = new ArrayList<Integer>();
				ArrayList<Integer> ans = arrange(arr, target, arr.length -1, dummy);
				ans.add(0);
				for(int i:arr)
					System.out.print(i + " ");
				System.out.println();
				for(int i:ans)
					System.out.print(i + " ");
				System.out.println();
			}
		}
	}
	
	public static ArrayList<Integer> arrange(int arr[], int[]target, int k, ArrayList<Integer> flips) {
		if(k==0)
			return flips;
		if(target[k] == arr[k]) {
			return arrange(arr, target, k-1, flips);
		} else {
			int index = find(arr, target[k]);
			if(index != 0) {
				int i=0, j=index;
				while(i<j) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
					i++;
					j--;
				}
				flips.add(arr.length - index);
//				System.out.println(Arrays.toString(arr));
			}
			flips.add(arr.length-k);
			int i=0;
			int j=k;
			while(i<j) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++;
				j--;
			}
//			System.out.println(Arrays.toString(arr));
			return arrange(arr, target, k-1, flips);
		}
	}
	
	public static int find(int arr[], int num) {
		int n = arr.length;
		for(int i=0;i<n;i++)
			if(num==arr[i])
				return i;
		return -1;
	}
}
