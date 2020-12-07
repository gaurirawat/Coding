package revision;
//https://leetcode.com/problems/utf-8-validation/submissions/
public class BM_lc_UTF8_validation {
    public boolean validUtf8(int[] data) {
        for(int i=0;i<data.length;++i) {
            int n=data[i];
            int c=0;
            for(int j=0; j<=7; ++j) {
                if((n>>(7-j)&1)==1){
                    c++;
                } else {
                    break;
                }
            }
            if(c==1||c>4) {
                // System.out.println("1 "+c+" "+i);
                return false;
            }
            for(int j=i+1; j<i+c;++j){
                if(j==data.length || !((data[j]>>7&1)==1 && (data[j]>>6&1)==0)) {
                    // System.out.println("2 "+c+" "+i+" "+j);
                    return false;
                }
            }
            i=i+(c==0?0:c-1);
        }
        return true;
    }
}
