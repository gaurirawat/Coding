package IB;
//https://www.interviewbit.com/problems/fizzbuzz/
public class Math_ib_fizz_buzz {
    public String[] fizzBuzz(int n) {
        String s[]=new String[n];
        for(int i=0;i<n;++i){
            if((i+1)%3!=0 && (i+1)%5!=0)
                s[i]=i+1+"";
            else if((i+1)%3==0 && (i+1)%5==0)
                s[i]="FizzBuzz";
            else if((i+1)%3==0)
                s[i]="Fizz";
            else
                s[i]="Buzz";
        }
        return s;
    }
}
