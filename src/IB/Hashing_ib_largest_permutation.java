package IB;
//https://www.interviewbit.com/problems/largest-permutation//
public class Hashing_ib_largest_permutation {
    public int[] solve(int[] a, int k) {
        int n=a.length;
        int[] pos=new int[n+1];
        for(int i=0;i<n;++i){
            pos[a[i]]=i;
        }
        for(int i=0;i<n && k!=0 ;++i) {
            if(a[i]!=n-i){
                k--;

                pos[a[i]]=pos[n-i];
                pos[n-i]=i;

                a[pos[a[i]]]=a[i];
                a[i]=n-i;
            }
        }
        return a;
    }
}
