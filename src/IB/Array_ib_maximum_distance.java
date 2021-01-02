package IB;
//https://www.interviewbit.com/problems/max-distance/
//https://www.geeksforgeeks.org/given-an-array-arr-find-the-maximum-j-i-such-that-arrj-arri/
public class Array_ib_maximum_distance {
    public int maximumGap(final int[] a) {
        if (a.length ==0) {
            return 0;
        }

        int sml[] = new int[a.length];
        int grr[] = new int[a.length];

        int min = a[0];
        for(int i=0; i<a.length; ++i) {
            min = Math.min(min, a[i]);
            sml[i] = min;
        }

        int max = a[a.length-1];
        for(int i=a.length-1; i>=0; --i) {
            max = Math.max(max, a[i]);
            grr[i] = max;
        }

        int answer = 0;
        int l = 0;
        int r = 0;

        while(r<a.length) {
            if (sml[l] <= grr[r]) {
                answer = Math.max(answer, r-l);
                r++;
            }
            else {
                l++;
            }
        }
        return answer;
    }
}
