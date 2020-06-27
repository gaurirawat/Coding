package revision;
// https://leetcode.com/problems/majority-element-ii/
import java.util.*;
class Array_lc_majority_element_NbyK {
    int num; 
    int ctr;
    public Array_lc_majority_element_NbyK(){
        num=-1246254;
        ctr=0;
    }
    
    public List<Integer> majorityElement(int[] nums) {
        return majorityElementNbyK(nums, 3);    
    }

    public List<Integer> majorityElementNbyK(int nums[], int k){
        //creating buckets
        Array_lc_majority_element_NbyK buck[]= new Array_lc_majority_element_NbyK[k];
        for(int i=0;i<k; ++i){
            buck[i]= new Array_lc_majority_element_NbyK();
        }
            
        for(int num: nums){
            boolean flag= true;
            
            for(Array_lc_majority_element_NbyK buckElem:buck){ 
                // System.out.println(num);
                // System.out.println(buckElem.num+ " "+ buckElem.ctr);     
                if(num==buckElem.num){
                    buckElem.ctr++;
                    flag=false;
                    break;
                }
            }
            
            //no entry or addition
            if(flag){
                flag=true;
                for(Array_lc_majority_element_NbyK buckElem:buck){
                    if(flag && buckElem.ctr<=0) {   //bucket is empty
                        buckElem.ctr=1;     
                        buckElem.num= num;
                        flag=false;
                    }
                }
                if(flag){
                  for(Array_lc_majority_element_NbyK buckElem:buck)
                    buckElem.ctr--;             
                }
            }
        }
                    
        for(Array_lc_majority_element_NbyK buckElem:buck){
            // System.out.println(buckElem.num+ " "+ buckElem.ctr);
            buckElem.ctr=0;
        }

        for(int num: nums){
            for(Array_lc_majority_element_NbyK buckElem:buck){
                if(num==buckElem.num)
                    buckElem.ctr++;
            }
        }

        List<Integer> answer = new ArrayList<Integer>();

        for(Array_lc_majority_element_NbyK buckElem:buck){
            if(buckElem.ctr>(nums.length)/k)
                answer.add(buckElem.num);
        }
        return answer;
    }
    
}
