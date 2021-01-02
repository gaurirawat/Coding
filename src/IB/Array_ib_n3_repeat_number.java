package IB;

import java.util.*;

//https://www.interviewbit.com/problems/n3-repeat-number/
public class Array_ib_n3_repeat_number {
    public int repeatedNumber(final List<Integer> l) {
        if (l.size() == 0) {
            return -1;
        }

        ArrayList<Element> maj = new ArrayList<Element>();
        for (int i = 0; i < l.size(); ++i) {
            boolean found = false;
            for (int j=0; j<maj.size(); ++j) {
                if (maj.get(j).number == l.get(i)) {
                    maj.get(j).freq++;
                    found = true;
                    break;
                }
            }

            if (!found) {
                if (maj.size()<3) {
                    maj.add(new Element(l.get(i)));
                } else {
                    for (int j=0; j<maj.size(); ++j) {
                        maj.get(j).freq--;
                        if(maj.get(j).freq == 0) {
                            maj.remove(j);
                        }
                    }
                }
            }
        }

        for (int j=0; j<maj.size(); ++j) {
            maj.get(j).freq = 0;
        }

        for (int i=0; i<l.size(); ++i) {
            for (int j=0; j<maj.size(); ++j) {
                if (l.get(i) == maj.get(j).number) {
                    maj.get(j).freq++;
                    if (maj.get(j).freq > l.size()/3) {
                        return maj.get(j).number;
                    }
                    break;
                }
            }
        }
        return -1;
    }

    class Element{
        int number;
        int freq;
        public Element(int num) {
            number = num;
            freq = 1;
        }
    }
}