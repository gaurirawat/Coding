package IB;
//https://www.interviewbit.com/problems/majority-element/
public class Greedy_ib_majority_element {
    public int majorityElement(final int[] a) {
        if(a.length==0)return 0;
        int elem=a[0];
        int c=1;
        for(int i=1;i<a.length;++i){
            if(elem==a[i]) c++;
            else{
                c--;
                if(c==-1){
                    c=1;
                    elem=a[i];
                }
            }
        }
        return elem;
    }
}
