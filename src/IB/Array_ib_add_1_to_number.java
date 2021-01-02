package IB;

import java.util.ArrayList;

//https://www.interviewbit.com/problems/add-one-to-number/
public class Array_ib_add_1_to_number {
    public ArrayList<Integer> plusOnee(ArrayList<Integer> a) {
        while (!a.isEmpty() && a.get(0) == 0) {
            a.remove(0);
        }
        if (a.isEmpty()) {
            a.add(1);
            return a;
        }

        int carry = 1;
        int i = a.size() - 1;
        while (carry != 0 && i != -1) {
            int t = a.get(i) + carry;
            carry = t / 10;
            a.set(i, t % 10);
            --i;
        }
        if (carry != 0) {
            a.add(0, 1);
        }

        return a;
    }
}
