package IB;

import java.util.ArrayList;

//https://www.interviewbit.com/problems/rotate-matrix/
public class Array_ib_matrix_rotation_90_degrees {
    public void rotate(ArrayList<ArrayList<Integer>> a) {
        //find transpose
        for(int i=1;i<a.size();++i){
            for(int j =0;j<i;++j){
                int t=a.get(i).get(j);
                a.get(i).set(j,a.get(j).get(i));
                a.get(j).set(i,t);
            }
        }

        //mirror the transpose
        for(int i=0;i<a.size();++i){
            for(int j=0;j<a.get(0).size()/2;++j){
                int t=a.get(i).get(j);
                a.get(i).set(j, a.get(i).get(a.size()-1-j));
                a.get(i).set(a.size()-1-j,t);
            }
        }

    }
}