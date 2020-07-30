package IB;
//https://www.interviewbit.com/problems/hotel-bookings-possible/

import java.util.*;
public class Array_ib_hotel_bookings {
    public boolean hotel(ArrayList<Integer> a, ArrayList<Integer> d, int k) {
        if(k==0) return false;
        Collections.sort(a);
        Collections.sort(d);
        int c=0;
        int aa=0, dd=0;
        while(aa<a.size() && dd<d.size()){
            if(a.get(aa)==d.get(dd)){
                aa++;dd++;
            }
            else if(a.get(aa)<d.get(dd)){
                c++;aa++;
                if(c>k)
                    return false;
            }
            else{
                c--;dd++;
            }
        }
        return true;
    }
}
