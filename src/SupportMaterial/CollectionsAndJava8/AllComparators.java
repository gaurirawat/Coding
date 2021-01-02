package SupportMaterial.CollectionsAndJava8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class AllComparators {
    public static void main(String[] args) {
        ArrayList<int[]> dummyDataArray = new ArrayList<int[]>();
        dummyDataArray.add(new int[] {1,2});
        dummyDataArray.add(new int[] {2,2});
        dummyDataArray.add(new int[] {3,5});
        dummyDataArray.add(new int[] {3,0});
        dummyDataArray.add(new int[] {2,1});
        dummyDataArray.add(new int[] {4,0});

        ArrayList<int[]> arraySingleComparison= new ArrayList<int[]>();
        arraySingleComparison.addAll(dummyDataArray);
        Collections.sort(arraySingleComparison, Comparator.comparingInt(a->a[0]));

        ArrayList<int[]> arrayDoubleComparison= new ArrayList<int[]>();
        arrayDoubleComparison.addAll(dummyDataArray);
        Collections.sort(arrayDoubleComparison, (a,b)->(a[0]==b[0]? a[1]-b[1] : a[0]-b[0] ));


        ArrayList<ArrayList<Integer>> dummyDataList = new ArrayList();
        ArrayList<Integer> temp1=new ArrayList<Integer>();
        temp1.add(1); temp1.add(14);
        ArrayList<Integer> temp2=new ArrayList<Integer>();
        temp2.add(1); temp2.add(4);
        ArrayList<Integer> temp3=new ArrayList<Integer>();
        temp3.add(3); temp3.add(2);
        ArrayList<Integer> temp4=new ArrayList<Integer>();
        temp4.add(1); temp4.add(6);
        dummyDataList.add(temp1);
        dummyDataList.add(temp2);
        dummyDataList.add(temp3);
        dummyDataList.add(temp4);


        ArrayList<ArrayList<Integer>> listSingleComparison= new ArrayList<>();
        listSingleComparison.addAll(dummyDataList);
        Collections.sort(listSingleComparison, Comparator.comparingInt(a->a.get(0)));
        System.out.println(listSingleComparison.toString());

        ArrayList<ArrayList<Integer>> listDoubleComparison= new ArrayList<ArrayList<Integer>>();
        listDoubleComparison.addAll(dummyDataList);
        Collections.sort(listDoubleComparison,
                (a,b)->(a.get(0).equals(b.get(0))? (a.get(1)).compareTo(b.get(1)) : (a.get(0)).compareTo(b.get(0) )));
        System.out.println(listDoubleComparison.toString());


        ArrayList<Pair> pairDummyData = new ArrayList<>();
        pairDummyData.add(new Pair(1,"abc"));
        pairDummyData.add(new Pair(2,"b"));
        pairDummyData.add(new Pair(1,"acz"));
        pairDummyData.add(new Pair(1,"acd"));

        ArrayList<Pair> pairSingleComparison=new ArrayList<>();
        pairSingleComparison.addAll(pairDummyData);
        Collections.sort(pairSingleComparison, Comparator.comparingInt(a->a.age));
        System.out.println(pairSingleComparison.toString());

        ArrayList<Pair> pairDoubleComparison=new ArrayList<>();
        pairDoubleComparison.addAll(pairDummyData);
        Collections.sort(pairDoubleComparison, (a,b)->(a.age==b.age? a.name.compareTo(b.name) : a.age-b.age ));
        System.out.println(pairDoubleComparison.toString());
    }
}

class Pair{
    int age;
    String name;
    public Pair(int a, String b) {
        age=a;
        name=b;
    }

    public String toString(){
        return "( "+ age+" "+ name+ " )";
    }
}