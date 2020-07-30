package IB;
//https://www.interviewbit.com/problems/largest-number/
import java.util.*;

public class Array_ib_largest_number {
    public String largestNumber(final List<Integer> a) {
        Collections.sort(a, new CustomComp());
        StringBuffer s = new StringBuffer();// take string buffer otherwise TLE
        for(int x:a)
            s.append(x);
        return s.charAt(0)=='0'?"0":s.toString();
    }
}

class CustomComp implements Comparator<Integer> {
    public int compare(Integer a, Integer b){
        String x=a+""+b;
        String y=b+""+a;
        return -x.compareTo(y);
    }
}
