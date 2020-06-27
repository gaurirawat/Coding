package revision;
//https://www.interviewbit.com/problems/hotel-bookings-possible/
import java.util.*;
public class Array_ib_max_hotel_booking {
	public boolean hotel(ArrayList<Integer> ar, ArrayList<Integer> dp, int k) {
        Collections.sort(ar);
        Collections.sort(dp);
        int mx=0; 
        int i=0, j=0;
        while(i<ar.size() && j< dp.size()){
            if(ar.get(i)<dp.get(j)){
                i++; mx++;
                if(mx>k)
                    return false;
            }
            else{
                ++j;
                --mx;
            }
        }
        return true;
    }
}
