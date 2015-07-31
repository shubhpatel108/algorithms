
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class n_paraenthesis {
    static HashMap<Integer, List<String>> hm = new HashMap<Integer, List<String>>();
    
    public static void main(String args[])
    {
    	System.out.println(generateParenthesis(3));
    }
    
    public static List<String> generateParenthesis(int n) {
        return insert(2*n);
    }
    
    public static List<String> insert(int num)
    {
        List<String> ans = new ArrayList<String>();
        int left = 0;
        int right = 1;
        
        if(num==0)
        {
            ans.add("");
            return ans;
        }
        
        if(hm.containsKey(num))
            return hm.get(num);
            
        for(; right<num ; right+=2)
        {
            List<String> inbetween = insert(right-left-1);
            List<String> apend = insert(num-right-1);
            for(int i=0;i<inbetween.size();i++)
            {
                for(int j=0;j<apend.size();j++)
                {
                    ans.add("(" + inbetween.get(i) + ")" + apend.get(j));
                }
            }
        }
        
        hm.put(num, ans);
        return ans;
    }
}
