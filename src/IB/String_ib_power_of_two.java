package IB;

import java.math.BigInteger;

public class String_ib_power_of_two {
    public int power(String a) {
        // System.out.println(a);
        BigInteger x= new BigInteger(a);
        BigInteger arr[]=x.divideAndRemainder(new BigInteger("2"));
        if(arr[0].equals(new BigInteger("1")))
            return 1;
        if(arr[0].equals(new BigInteger("0")))
            return 0;
        if(arr[1].equals(new BigInteger("1")))
            return 0;
        return power(arr[0].toString());
    }
}
