
public class trapping_rain_water {
	public static void main(String args[])throws Exception
	{
		int[] array = {0,1,0,2,1,0,1,3,2,1,2,1};
		System.out.println(trap(array));
	}
	
	public static int trap(int[] height)
	{
		int vol = 0;
		int n = height.length;
		int[] left_most = new int[n];
		int[] right_most = new int[n];
		
		int leftMaxSoFar = 0;
		int rightMaxSoFar = 0;
		
		for(int i=0;i<n;i++) {
			left_most[i] = leftMaxSoFar;
			if(height[i] > leftMaxSoFar) leftMaxSoFar = height[i];
		}
		
		for(int i = n-1; i>=0; i--) {
			right_most[i] = rightMaxSoFar;
			if(height[i] > rightMaxSoFar) rightMaxSoFar = height[i];
		}
		
		for(int i=0; i<n;i++)
			vol += Math.max(0, Math.min(left_most[i], right_most[i]) - height[i]);
		
		return vol;
	}
}
