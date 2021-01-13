package revision;
//https://leetcode.com/problems/confusing-number-ii/submissions/
public class Graph_lc_confusing_number {
    public int confusingNumberII(int n) {
        int c = 0;
        for (long x : new long[]{1 , 8, 6 ,9}) {
            c += confusingNumberInner(x, n);
        }
        return c;
    }

    public int confusingNumberInner(long num, int n) {
        if (num > n) {
            return 0;
        }

        int c = 0;
        char[] ch = (num + "").toCharArray();
        for (int i = 0; i < ch.length; ++i) {
            if (ch[i] == '6') {
                ch[i] = '9';
            }
            else if (ch[i] == '9') {
                ch[i] = '6';
            }
        }
        StringBuffer sb = new StringBuffer(new String(ch));
        sb.reverse();
        if (!sb.toString().equals(num + "")) {
            c++;
        }

        for  (long x : new long[]{0, 1 , 8, 6 ,9}) {
            c += confusingNumberInner(num * 10 + x, n);
        }
        return c;
    }
}
