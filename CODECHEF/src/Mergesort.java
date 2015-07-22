import java.util.ArrayList;

public class Mergesort {
	private static ArrayList<Interval> numbers= new ArrayList<Interval>();
	private static ArrayList<Interval> helper;
	private static int number;
	
	public Mergesort(ArrayList<Interval> nums)
	{
		this.numbers = nums;
		sort(numbers);
	}
	
	public static void sort(ArrayList<Interval> myNumbers){
	    for(int i=0; i<myNumbers.size();i++){
	        numbers.add(myNumbers.get(i));
	    }
	    //numbers=myNumbers;
	    number = myNumbers.size()-1;

	    mergesort(0, number -1);
	}
	private static void mergesort(int low, int high){
	    //check if low is smaller than high, if not then the array is sorted
	    if(low<high){
	        //get the index of the element which is in the middle
	        int middle=low+(high-low)/2;
	        //sort the left side of the array
	        mergesort(low, middle);
	        //sort the right side of the array
	        mergesort(middle +1, high);
	        //combine them both
	        merge(low, middle, high);
	    }
	}
	private static void merge(int low, int middle, int high){
	    //copy both parts into the helper array
	    for(int i=high;i>=low;i--){
	        helper.add((numbers.get(i)));
	    }

	    int i=low;
	    int j=middle+1;
	    int k=low;
	    //copy the smallest myNumbers from either the left or right side back to the original array
	    while(i<middle  && j<high){
	        if(helper.get(i).start< helper.get(j).start){
	            numbers.set(k,(helper.get(i)));
	            i++;
	        }
	        else{
	            numbers.set(k,(helper.get(j)));
	            j++;
	        }
	        k++;
	    }
	    //copy the rest of the left side of the array into target array
	    while(i<middle){
	        numbers.set(k,helper.get(i));
	        k++;
	        i++;
	    }
	}
	
}
