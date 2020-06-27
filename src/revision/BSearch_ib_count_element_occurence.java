package revision;

//https://www.interviewbit.com/problems/count-element-occurence/
public class BSearch_ib_count_element_occurence {
    public int findCount(final int[] a, int b) {
        if(a.length==0)
            return 0;
        int l=0, r=a.length-1;
        int mid=0;
        while(l<=r){
            mid= l+(r-l)/2;
            if(b==a[mid])
                break;
            if(b< a[mid])
                r=mid-1;
            else
                l= mid+1;
        }
        if(a[mid]!=b)
            return 0;
        int c=1;
        int temp=mid+1;
        while(temp<a.length && a[temp]==b){
            c++;
            temp++;
        }
        temp=mid-1;
        while(temp>=0 && a[temp]==b){
            c++;
            temp--;
        }
        return c;
    }
}
