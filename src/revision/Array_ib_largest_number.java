package revision;
//https://www.interviewbit.com/problems/largest-number/
//https://leetcode.com/problems/largest-number/submissions/
import java.util.*;
public class Array_ib_largest_number {
	public String largestNumber(final List<Integer> a) {
        Collections.sort(a, new CustomComp());
        StringBuffer ans = new StringBuffer();
        for(int x : a)
            ans.append(x);
        if(ans.charAt(0)=='0')
            return "0"; 
        return  ans.toString();
    }
}

class CustomComp implements Comparator<Integer>{
    @Override
    public int compare(Integer i1, Integer i2){
        String s1=(i1+""+i2);
        String s2=(i2+""+i1);
        return -s1.compareTo(s2);
    }
    //the array has to be sorted in reverse order
}

	/*
	public String largestNumber(final List<Integer> a) {
        List<String> strs = new ArrayList<String>();
        for(Integer i : a){
            strs.add(String.valueOf(i));
        }
        
        Collections.sort(strs, new MyCompartor());
        if(Integer.valueOf(strs.get(0))==0)
        return "0";
         StringBuffer strBuf = new StringBuffer();
        for(String s : strs)
            strBuf.append(s);
        return strBuf.toString();
    }
}

class MyCompartor implements Comparator<String>{
    @Override
    public int compare(String s1, String s2){
        String first = s1 + s2;
        String second = s2 + s1;
        return second.compareTo(first);
    }
}
*/