package IB;
//https://www.interviewbit.com/problems/xor-between-two-arrays/

import java.util.ArrayList;
public class Tree_ib_Trie_xor_between_two_arrays {
    int max;
    public int solve(ArrayList<Integer> x, ArrayList<Integer> y) {
        TrieNode root1=generateTrie(x);
        TrieNode root2=generateTrie(y);
        max=0;
        findMaxXor(root1, root2,0,0,0);
        return max;
    }

    public TrieNode generateTrie(ArrayList<Integer> x){
        TrieNode root=new TrieNode();
        for(int i=0;i<x.size();++i)
            root=insertIntoTrie(root,x.get(i),0);
        return root;
    }

    public TrieNode insertIntoTrie(TrieNode root, int num, int i){
        if(root==null)
            root=new TrieNode();
        if(i==31){
            root.eow=true;
            return root;
        }
        boolean isBitZero=(num&(1<<i))==0;
        if(isBitZero)
            root.zero=insertIntoTrie(root.zero,num,i+1);
        else
            root.one=insertIntoTrie(root.one,num,i+1);
        return root;
    }

    public void findMaxXor(TrieNode root1, TrieNode root2, int num1, int num2, int i){
        if(i==31){
            System.out.println(num1+" "+num2+" "+ (num1^num2));
            max=Math.max(max, (num1^num2));
            return;
        }
        if(root1.one!=null){
            if(root2.zero!=null) findMaxXor(root1.one, root2.zero, num1+(1<<i),num2,i+1);
            if(root2.one!=null) findMaxXor(root1.one, root2.one , num1+(1<<i),num2+(1<<i),i+1);
        }
        if(root1.zero!=null){
            if(root2.zero!=null) findMaxXor(root1.zero, root2.zero, num1, num2,i+1);
            if(root2.one!=null) findMaxXor(root1.zero, root2.one, num1, num2+(1<<i),i+1);
        }
    }
    class TrieNode{
        TrieNode zero;
        TrieNode one;
        boolean eow;//end of word
    }
}

/*
public class Tree_ib_Trie_xor_between_two_arrays {
    int max;
    public int solve(ArrayList<Integer> x, ArrayList<Integer> y) {
        if(x.size()>y.size()){
            ArrayList<Integer> t=x;
            x=y;
            y=t;
        }
        TrieNode rootY=generateTrie(y);
        max=0;
        for(int i=0;i<x.size();++i)
            findMaxXor(x.get(i),rootY,0,0);
        return max;
    }

    public TrieNode generateTrie(ArrayList<Integer> x){
        TrieNode root=new TrieNode();
        for(int i=0;i<x.size();++i)
            root=insertIntoTrie(root,x.get(i),0);
        return root;
    }

    public TrieNode insertIntoTrie(TrieNode root, int num, int i){
        if(root==null)
            root=new TrieNode();
        if(i==31){
            root.eow=true;
            return root;
        }
        boolean isBitZero=(num&(1<<i))==0;
        if(isBitZero)
            root.zero=insertIntoTrie(root.zero,num,i+1);
        else
            root.one=insertIntoTrie(root.one,num,i+1);
        return root;
    }

    public void findMaxXor(int numX, TrieNode rootY, int genNum, int i){
        if(i==31){
            System.out.println(numX+" "+genNum+" "+ (numX^genNum));
            max=Math.max(max, (numX^genNum));
            return;
        }
        boolean isBitZero=(numX&(1<<i))==0;
        if(isBitZero){
            if(rootY.one!=null) findMaxXor(numX, rootY.one, genNum+(1<<i),i+1);
            else findMaxXor(numX, rootY.zero, genNum,i+1);
        }
        else{
            if(rootY.zero!=null) findMaxXor(numX, rootY.zero, genNum,i+1);
            else findMaxXor(numX, rootY.one, genNum+(1<<i),i+1);
        }
    }
}
class TrieNode{
    TrieNode zero;
    TrieNode one;
    boolean eow;//end of word
}
 */