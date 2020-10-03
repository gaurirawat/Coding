package revision;

import java.util.*;

public class IBM {
    public static void main(String[] args) {
        List<Integer> l= new ArrayList<Integer>();
        l.add(3);
        l.add(3);
        l.add(3);
        l.add(3);
        l.add(1);
        l.add(3);
        l.add(3);
        socialGraphs(l);

    }
    public static void socialGraphs(List<Integer> c){
        HashMap<Integer, ArrayList<Integer>> map= new HashMap<Integer, ArrayList<Integer>>();
        ArrayList<ArrayList<Integer>> ans=new ArrayList<ArrayList<Integer>>();

        for(int i=0;i<c.size();++i){
            ArrayList<Integer> l= map.getOrDefault(c.get(i),new ArrayList<Integer>());
            l.add(i);
            if(l.size()==c.get(i)) {
                ans.add(l);
                map.put(c.get(i), new ArrayList<Integer>());
            }
            else
                map.put(c.get(i),l);
        }

        Collections.sort(ans, Comparator.comparingInt(a->a.get(0)));
        for(int i=0;i<ans.size();++i){
            for(int j=0;j<ans.get(i).size();++j)
                System.out.print(ans.get(i).get(j)+" ");
            System.out.println();
        }
    }
}

//        for(Map.Entry<Integer, ArrayList<Integer>> e: map.entrySet()){
//            ArrayList<Integer> l =e.getValue();
//            for(int i=0;i<l.size();){
//                ArrayList<Integer> t=new ArrayList<>();
//                for(int j=0;j<e.getKey();++j)
//                    t.add(l.get(j+i));
//                ans.add(t);
//                i+=e.getKey();
//            }
//        }