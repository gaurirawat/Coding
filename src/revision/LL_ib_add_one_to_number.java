package revision;
import java.util.*;
public class LL_ib_add_one_to_number {
	public int[] plusOne(int[] a) {
        int i=0;
        for(; i<a.length; ++i){
            if(a[i]!=0)
                break;
        }
        a[a.length-1]+=1;
        int x[]= new int[a.length-i+ a[a.length-1]%10];
        x= Arrays.copyOfRange(a, i, a.length-1);
//        x=Arrays.cop
        if(a[a.length-1]>9){
            x[x.length]=1;
            x[x.length-1]%=10;
        }
        return x;
    }
}
