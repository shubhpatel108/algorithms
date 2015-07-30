
public class isNumPalindrome {
	
	public static void main(String args[])throws Exception
	{
		int n = 1000021;
		System.out.println(isPalindrome(n));
	}
	
    public static boolean isPalindrome(int x) {
        if(x<0) return false;
        
        int len = String.valueOf(x).length() - 1;
        
        while(len>0) {
            
            if((x%10) == (int)(x/(Math.pow(10,len)))) {
                x =(int)  (x - (int)(x/(Math.pow(10,len))) * Math.pow(10, len));
                x = x/10;
                len-=2;
            } else {
                return false;
            }
        }
        
        return true;
    }
}