package IB;

public class Array_ib_sort_array_with_squares {
    public int[] solve(int[] a) {
        int posIndex=a.length;
        boolean notSet=true;
        for(int i=0;i<a.length;++i) {
            if(a[i]>=0 && notSet) {
                posIndex=i;
                notSet=false;
            }
            a[i]*=a[i];
        }

        int[] ans=new int[a.length];
        merge(a,0,posIndex-1,posIndex,a.length-1, ans);
        return ans;
    }

    public void merge(int[] a, int la, int ra, int lb, int rb, int[] ans) {
        int c=0;
        while(la<=ra && lb<=rb) {
            if(a[ra]<a[lb]){
                ans[c++]=a[ra--];
            }
            else{
                ans[c++]=a[lb++];
            }
        }
        while(la<=ra){
            ans[c++]=a[ra--];
        }
        while(lb<=rb){
            ans[c++]=a[lb++];
        }
    }
}
