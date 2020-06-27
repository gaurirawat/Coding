package revision;
//https://leetcode.com/problems/two-city-scheduling/

import java.util.*;
public class Array_lc_two_city_scheduling {
    public int twoCitySchedCost(int[][] cost) {   
        int sum =0;
        int arr[]= new int[cost.length];
        for(int i=0; i<cost.length; ++i){
            arr[i]=cost[i][1]- cost[i][0];
            sum+=cost[i][0];
        }
        Arrays.sort(arr);
        
        for(int i=0; i< cost.length/2; ++i)
            sum+=arr[i];
        return sum;
    }
}

/*
1. Send all person to city A, Cost  = 10 + 30 + 400 + 30 = 470 
2. Check how much diff we will get if we send person to city B instead of city A
	Diff for  person1, D1 20 - 10 = 10 
	Diff for  person2, D2 200 - 30 = 170 
	Diff for  person3, D3 50 - 400 = -350 
	Diff for  person4, D4 20 - 30 = -10 
3. Sort the diff cost of persons - D3, D4, D1, D2 
4. Now we will pick N person which giving more diff to sending them city  B instead of city A, P3, P4 we will send them to city B
5. Add the diff cost of N person in Cost = 470 - 350 - 10 = 110 
*/