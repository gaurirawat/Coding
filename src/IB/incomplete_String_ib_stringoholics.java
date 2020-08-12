package IB;

import java.util.HashMap;
import java.util.Map;

public class incomplete_String_ib_stringoholics {
    int mod=(int)Math.pow(10,9)+7;
    public int solve(String[] a) {

        int rlen[]=new int[a.length];
        for(int i=0;i<a.length;++i){
            String s=a[i];
            if(isPrime(s.length())){
                rlen[i]=s.length();
                continue;
            }
            int lps[]=new int[s.length()];
            int p=0;
            for(int q=1;q<s.length();++q){
                while(p!=0 && s.charAt(q)!=s.charAt(p)){
                    p=lps[p-1];
                }
                if(s.charAt(q)==s.charAt(p))
                    lps[q]=p++ +1;
                else if(p==0)
                    lps[q]=0;
            }
            rlen[i]=s.length()-p;
        }

        // we got the recurring length for all the string. Now we find the lcm
        HashMap<Integer, Integer> map= new HashMap<Integer, Integer>();
        for(int i=0;i<rlen.length;++i){
            factorise(rlen[i],map);
        }
        long lcm=1;
        for(Map.Entry<Integer,Integer> e:map.entrySet())
            lcm=(lcm*(int)Math.pow(e.getKey(),e.getValue()))%mod;
        return (int)lcm;
    }

    public boolean isPrime(int x){
        if(x<=2||x==3||x==5) return true;
        for(int i=2;i<=(int)Math.sqrt(x);++i)
            if(x%i==0)return false;
        return true;
    }

    public void factorise(int x, HashMap<Integer, Integer> map){
        int c=0;
        int fac=2;
        while(x!=1){
            while(x!=1 && x%fac==0){
                x/=fac;
                c++;
            }
            if(c!=0){
                if(map.get(fac)==null)
                    map.put(fac,c);
                else if(map.get(fac)!=null && c>map.get(fac)){
                    map.replace(fac, map.get(fac),c);

                }
            }
            c=0;
            fac++;
        }
    }
}
