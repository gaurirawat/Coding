package IB;
//https://www.interviewbit.com/problems/integer-to-roman/
/*
this pathetic solution will take a lot of time to get developed and pass all edge cases. Try out the lower one.
 */
public class String_ib_int_to_roman {
    public String intToRoman(int n) {
        int r[]={1,5,10,50,100,500,1000};
        char a[]={'I','V','X','L','C','D','M'};
        StringBuffer sb= new StringBuffer();
        for(int i=r.length-1;i>=0;--i){
            if(i!=6){
                int y=(int)(r[i+1]-Math.pow(10,(r[i+1]-1+"").length()-1));
                if(n>=y){
                    if(i==0||i==1)
                        sb.append("I"+a[i+1]);
                    else if(i==2||i==3)
                        sb.append("X"+a[i+1]);
                    else
                        sb.append("C"+a[i+1]);
                    n-=y;
                }
            }

            int x=n/r[i];
            if(x==0){
                continue;
            }
            else{
                for(int j=0;j<x;++j)
                    sb.append(""+a[i]);
                n=n%r[i];
            }
        }
        return sb.toString();
    }
}
/*
public String intToRoman(int n) {
    String o[]={"","I","II","III","IV","V","VI","VII","VIII","IX"};
    String t[]={"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};
    String c[]={"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};
    String m[]={"","M","MM","MMM"};
    return m[n/1000]+c[(n%1000)/100]+t[(n%100)/10]+o[n%10];
}
 */