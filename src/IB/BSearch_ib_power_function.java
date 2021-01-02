package IB;
//https://www.interviewbit.com/problems/implement-power-function/
//https://www.geeksforgeeks.org/modular-exponentiation-power-in-modular-arithmetic/
public class BSearch_ib_power_function {
    public int pow(int x, int n, int d) {
        if (x == 0) {
            return 0;
        }
        int answer = inner(x*1L, n*1L, d*1L);
        if (answer < 0) {
            answer += d;
        }
        return answer;
    }

    public int inner(long x, long n, long d) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return (int)x;
        }

        long answer = 0;
        if (n % 2 == 0) {
            answer = inner(x * x % d, n/2, d);
        } else {
            answer = x * inner(x * x % d, n/2, d);
        }
        return (int)(answer % d);
    }
}
