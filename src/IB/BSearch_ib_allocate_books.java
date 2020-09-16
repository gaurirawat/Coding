package IB;
//https://www.interviewbit.com/problems/allocate-books/
//same as painters partition problem
public class BSearch_ib_allocate_books {
    public int books(int[] books, int n) {
        long r=0;
        long l=Integer.MIN_VALUE;
        for(int x:books){
            l=Math.max(x,l);
            r+=x;
        }
        if(n>books.length)
            return -1;
        else if(n==books.length)
            return (int)l;
        long min=Long.MAX_VALUE;
        while(l<=r){
            long mid=l+(r-l)/2;
            long pages=getMaxPagesAllocated(books, mid, n);
            // System.out.println(l+" "+r+" "+mid+" "+pages);
            if(pages==Long.MAX_VALUE)
                l=mid+1;
            else{
                min=Math.min(min, pages);
                r=mid-1;
            }
        }
        return (int)min;
    }

    public long getMaxPagesAllocated(int[]books, long maxAllowedPages, int n){
        long maxPages=0;
        int pages=0;
        for(int i=0;i<books.length;++i){
            pages+=books[i];
            if(pages>maxAllowedPages){
                --n;
                if(n==0)
                    return Long.MAX_VALUE;
                pages=books[i];
            }
            maxPages=Math.max(maxPages, pages);
        }
        maxPages=Math.max(maxPages, pages);
        return maxPages;
    }
}