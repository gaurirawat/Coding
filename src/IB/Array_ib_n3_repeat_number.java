package IB;

import java.util.*;

//https://www.interviewbit.com/problems/n3-repeat-number/
public class Array_ib_n3_repeat_number {
    public int repeatedNumber(final List<Integer> l) {
        if(l.size()==0) return -1;
        ArrayList<MajElem> elems=new ArrayList<MajElem>();
        for(int x:l){
            boolean found=false;
            for(MajElem e: elems){
                if(e.e==x){
                    e.c++;
                    found=true;
                    break;
                }
            }
            if(!found){
                if(elems.size()<3)
                    elems.add(new MajElem(x,1));
                else{
                    for(int i=0;i<elems.size();++i){
                        MajElem e=elems.get(i);
                        e.c--;
                        if(e.c==0){
                            elems.remove(e);
                            --i;
                        }
                    }
                }
            }
        }

        for(MajElem e:elems)
            e.c=0;
        for(int i=0;i<l.size();++i){
            for(MajElem e:elems){
                if(e.e==l.get(i)){
                    e.c++;
                    if(e.c>l.size()/3)
                        return e.e;
                }
            }
        }
        return -1;
    }
}

class MajElem{
    int e;
    int c;
    public MajElem(int i, int j){
        e=i;
        c=j;
    }
}