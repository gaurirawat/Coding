package revision;

import java.util.Arrays;

public class Mathworks {
    public static void main(String[] args) {
        String s="giraffe";
        int k=2;
        String charValue="01111001111111111011111111";
        System.out.println(getSpecialSubstring(s,k,charValue));
    }

    static int mx;
    public static int getSpecialSubstring(String s,int k,String charValue){
        s=s.toLowerCase();
        int arr[]=new int[s.length()];
        for(int i=0;i<arr.length;++i){
            int alp=s.charAt(i)-'a';
            arr[i]=Integer.parseInt(charValue.charAt(alp)+"");
        }

        int mx=0;
        for(int i=0;i<arr.length;++i){
            int c=k;
            for(int j=i;j<arr.length;++j){
                if(arr[j]==1)
                    continue;
                --c;
                if(c==0) {
                    mx = Math.max(mx, j - i + 1);
                    break;
                }
            }
        }
        return mx;
    }
}
