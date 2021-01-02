package revision;

import java.util.*;

//https://leetcode.com/problems/word-ladder/
public class Graph_lc_word_ladder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord) || beginWord.equals(endWord)){
            return 0;
        }
        else{
            wordList.remove(endWord);
        }
        if(wordList.contains(beginWord)){
            wordList.remove(beginWord);
        }
        wordList.add(beginWord);
        wordList.add(endWord);
        ArrayList<ArrayList<Integer>> graph=new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<wordList.size();++i) {
            graph.add(new ArrayList<Integer>());
        }
        buildGraph(graph, wordList);
        return getMinLength(graph, wordList.size()-2, wordList.size()-1);
    }


    public int getMinLength(ArrayList<ArrayList<Integer>> graph, int beginIndex, int endIndex){
        Deque<int[]> q= new LinkedList<int[]>();
        q.add(new int[]{beginIndex, 1});
        boolean[] visited= new boolean[graph.size()];
        visited[beginIndex]=true;
        while(!q.isEmpty()) {
            int[] currEntry=q.pollFirst();
            if(currEntry[0]==endIndex) {
                return currEntry[1];
            }
            for(int x: graph.get(currEntry[0])) {
                if(!visited[x]) {
                    visited[x]=true;
                    q.add(new int[] {x, currEntry[1]+1});
                }
            }
        }
        return 0;
    }

    public void buildGraph(ArrayList<ArrayList<Integer>> graph, List<String> wordList){
        for(int i=0; i<wordList.size(); ++i) {
            for(int j=i+1; j<wordList.size(); ++j) {
                if(canConnect(wordList.get(i), wordList.get(j))){
                    graph.get(i).add(j);
                    graph.get(j).add(i);
                }
            }
        }
    }

    public boolean canConnect(String a, String b) {
        if(a.length()!=b.length()){
            return false;
        }
        boolean flag=true;
        for(int i=0;i<a.length();++i) {
            if(a.charAt(i)!=b.charAt(i)) {
                if(flag){
                    flag=false;
                }
                else{
                    return false;
                }
            }
        }
        return true;
    }
}
