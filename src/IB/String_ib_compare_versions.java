package IB;

import java.math.BigInteger;

//https://www.interviewbit.com/problems/compare-version-numbers/
public class String_ib_compare_versions {
    public int compareVersion(String a, String b) {
        String v1[]=a.split("\\.");
        String v2[]=b.split("\\.");
        // System.out.println(Arrays.toString(v1));
        // System.out.println(Arrays.toString(v2));
        int i=0;
        for(i=0;i<v1.length&&i<v2.length;++i){
            BigInteger x=new BigInteger(v1[i]);
            BigInteger y=new BigInteger(v2[i]);
            if(x.compareTo(y)>0)
                return 1;
            else if(x.compareTo(y)<0)
                return -1;
        }
        int j=i;
        while(i<v1.length && (new BigInteger(v1[i])).compareTo(new BigInteger("0"))==0)++i;
        while(j<v2.length && (new BigInteger(v2[j])).compareTo(new BigInteger("0"))==0)++j;
        if(i==v1.length&&j==v2.length)
            return 0;
        else if(j==v2.length)
            return 1;
        return -1;
    }
}
