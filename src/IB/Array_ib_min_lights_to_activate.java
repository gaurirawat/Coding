package IB;

import java.util.ArrayList;
import java.util.Collections;

//https://www.interviewbit.com/problems/maximum-sum-square-submatrix/
public class Array_ib_min_lights_to_activate {
    public int solve(ArrayList<Integer> a, int k) {
        return innerSolve(a,k,0);
    }

    public int innerSolve(ArrayList<Integer> a, int k, int i){
        if(i>=a.size())
            return 0;
        boolean found=false;
        int j=k-1;
        for(j=k-1;j>=-(k-1);--j){
            if((i+j)<0 || (i+j)>=a.size())
                continue;
            if(a.get(i+j)==1){
                found=true;
                break;
            }
        }
        if(!found)
            return -1;

        int val=innerSolve(a,k,i+j+k);
        if(val==-1)
            return -1;
        else
            return 1+val;
    }

    public int solve2(int a, int[] arr) {
        int sum = 0;
        for (int x : arr)
            sum += x;
        if (sum % 3 != 0) return 0;

        sum /= 3;

        ArrayList<Integer> indexPrefix = new ArrayList<Integer>();
        int temp = 0;
        for (int i = 0; i < arr.length; ++i) {
            temp += arr[i];
            if (temp == sum) {
                indexPrefix.add(i);
            }
        }

        ArrayList<Integer> indexSuffix = new ArrayList<Integer>();
        temp = 0;
        for (int i = arr.length - 1; i >= 0; --i) {
            temp += arr[i];
            if (temp == sum) {
                indexSuffix.add(i);
            }
        }

        int answer = 0;
        for (int index : indexSuffix) {
            int pos = Collections.binarySearch(indexPrefix, index - 1);
            if (pos < 0) {
                pos = Math.abs(pos + 1);
            }
            answer += pos;
        }
        return answer;
    }
}