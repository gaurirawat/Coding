package IB;

import java.util.*;
//https://www.interviewbit.com/problems/equal/
public class Hashing_ib_equal_sums_pair {
    public ArrayList<Integer> equal(ArrayList<Integer> a) {
        HashMap<Integer,Index> map=new HashMap<Integer,Index>();
        Four ans=null;
        for(int i=0;i<a.size();++i){
            // System.out.println(map.toString());
            for(int j=i+1;j<a.size();++j){
                int sum=a.get(i)+a.get(j);
                if(map.get(sum)==null){
                    map.put(sum, new Index(i,j));
                }
                else{
                    Index e=map.get(sum);
                    if(i!=e.i && i!=e.j && j!=e.i && j!=e.j && e.j<j){
                        Four curr=new Four(e.i,e.j,i,j);
                        // System.out.println("here"+curr);
                        if(ans==null)
                            ans=curr;
                        else if(curr.i<ans.i||
                                (curr.i==ans.i && curr.j<ans.j)||
                                (curr.i==ans.i && curr.j==ans.j && curr.k<ans.k)||
                                (curr.i==ans.i && curr.j==ans.j && curr.k<ans.k && curr.l<ans.l))
                            ans=curr;
                    }
                }
            }
        }
        ArrayList<Integer> ansl=new ArrayList<Integer>();
        if(ans!=null){
            ansl.add(ans.i);
            ansl.add(ans.j);
            ansl.add(ans.k);
            ansl.add(ans.l);
        }
        return ansl;
    }
}
class Four {
    int i;
    int j;
    int k;
    int l;
    public Four(int a, int b, int c, int d){
        i=a;
        j=b;
        k=c;
        l=d;
    }
    public Four(){}
    public String toString(){
        return "["+i+" "+j+" "+k+" "+l+"]";
    }
}
class Index{
    int i;
    int j;
    public Index(int x, int y){
        i=x;
        j=y;
    }
    public Index(){}
    public String toString(){
        return "["+i+" "+j+"]";
    }
}