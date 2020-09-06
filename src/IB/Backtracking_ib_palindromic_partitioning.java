package IB;

import java.util.ArrayList;

//https://www.interviewbit.com/problems/palindrome-partitioning/
public class Backtracking_ib_palindromic_partitioning {
    ArrayList<ArrayList<String>> ans;
    public ArrayList<ArrayList<String>> partition(String s) {
        ans =new ArrayList<ArrayList<String>>();
        int palindromic[][]=new int[s.length()][s.length()];
        generatePartitions(new ArrayList<String>(),0,s,palindromic);
        return ans;
    }

    public void generatePartitions(ArrayList<String> l, int i, String s, int[][]palindromic){
        if(i==s.length()){
            ArrayList<String> newl=new ArrayList<String>();
            newl.addAll(l);
            ans.add(newl);
            return;
        }

        for(int x=i;x<s.length();++x){
            if(isPalindromic(i,x,s,palindromic)){
                l.add(l.size(),s.substring(i,x+1));
                generatePartitions(l,x+1,s,palindromic);
                l.remove(l.size()-1);
            }
        }
    }

    public boolean isPalindromic(int i, int j, String s, int[][]palindromic){
        if(palindromic[i][j]!=0)
            return palindromic[i][j]==1?true:false;
        palindromic[i][j]=1;
        int l=i,r=j;
        while(l<r){
            if(s.charAt(l)!=s.charAt(r)){
                palindromic[i][j]=-1;
                break;
            }
            ++l;--r;
        }
        return palindromic[i][j]==1?true:false;
    }
}
