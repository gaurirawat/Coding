package revision;
public class Array_lc_fruit_into_basket {
    public int totalFruit(int[] arr) {
        if(arr.length<=2) {
            return arr.length;
        }
        int l=0,r=0;
        int a=arr[0], b=arr[0];
        int lastOccurrenceOfA=0;
        int lastOccurrenceOfB=0;
        int len=arr.length;
        int max=0;
        for(r=0;r<len;++r){
            if(arr[r]==a){
                lastOccurrenceOfA=r;
            }
            else if(arr[r]==b){
                lastOccurrenceOfB=r;
            }
            else if(a==b) {
                b=arr[r];
                lastOccurrenceOfB=r;
            }
            else {
                max=Math.max(max,r-l);
                if(lastOccurrenceOfA<lastOccurrenceOfB) {
                    l=lastOccurrenceOfA+1;
                    a=b;
                    lastOccurrenceOfA=lastOccurrenceOfB;
                }
                else{
                    l=lastOccurrenceOfB+1;
                }
                b=arr[r];
                lastOccurrenceOfB=r;
            }
        }
        max=Math.max(max,r-l);
        return max;
    }
}
//https://leetcode.com/problems/fruit-into-baskets/submissions/
