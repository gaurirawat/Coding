package IB;

import java.util.*;

public class Incomplete_median_an_array {
    public double findMedianSortedArrays(final List<Integer> a, final List<Integer> b) {
        int la=a.size(), lb=b.size();
        if(la==0) return (double)(lb%2==0?(b.get(lb/2)+b.get((lb/2)-1))/2.0 : b.get(lb/2));
        if(lb==0) return (double)(la%2==0?(a.get(la/2)+a.get((la/2)-1))/2.0 : a.get(la/2));

        int l=Math.min(a.get(0),b.get(0));
        int r=Math.max(a.get(la-1), b.get(lb-1));
        int count=(la+lb)%2==0 ? (la+lb)/2-1 : (la+lb)/2;
        double num=a.get(0);

        while(l<=r){
            int mid=l+(r-l/2);
            int c1=Collections.binarySearch(a,mid);
            int c2=Collections.binarySearch(b,mid);
            if(c1<0) c1=Math.abs(c1+1);
            if(c2<0) c2=Math.abs(c2+1);
            if((c1+c2)==count){
                if((la+lb)%2==0){
                    int min=Math.min(get(a,c1), get(b,c2));
                    if(min==c1)
                        num=(min+Math.min(get(a,c1+1),get(b,c2))/2.0);
                    else
                        num=(min+Math.min(get(a,c2+1),get(b,c1))/2.0);
                }
                else
                    num=Math.min(get(a,c1),get(b,c2));
                break;
            }
            else if((c1+c2)<count)
                l=mid+1;
            else
                r=mid-1;
        }
        return num;
    }

    public int get(List<Integer> a, int i){
        if(i==a.size()) return Integer.MAX_VALUE;
        else
            return a.get(i);
    }
}
