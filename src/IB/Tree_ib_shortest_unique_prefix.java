package IB;

import java.util.*;

//https://www.interviewbit.com/problems/shortest-unique-prefix/
public class Tree_ib_shortest_unique_prefix {
    //HashMap method
    public ArrayList<String> prefix(ArrayList<String> l) {
        HashMap<String,ArrayList<Integer>> map = new HashMap<String, ArrayList<Integer>> ();
        ArrayList<String> ans = new ArrayList<String> (l.size());
        for(int i=0; i<l.size(); ++i) {
            String key = l.get(i).substring(0,1);
            ArrayList<Integer> temp =map.getOrDefault(key, new ArrayList<Integer>());
            temp.add(i);
            map.put(key, temp);
            ans.add("");
        }
        while (!map.isEmpty()) {
            HashMap<String,ArrayList<Integer>> newMap = new HashMap<String,ArrayList<Integer>> ();
            for(Map.Entry<String,ArrayList<Integer>> e: map.entrySet()) {
                if(e.getValue().size()==1) {
                    ans.set(e.getValue().get(0),e.getKey());
                }
                else{
                    int len = e.getKey().length()+1;
                    for(int x : e.getValue()) {
                        String key = l.get(x).substring(0,len);
                        ArrayList<Integer> temp =newMap.getOrDefault(key, new ArrayList<Integer>());
                        temp.add(x);
                        newMap.put(key, temp);
                    }
                }
            }
            map=newMap;
        }
        return ans;
    }

    //trie method
    public class Solution {
        public ArrayList<String> prefix(ArrayList<String> a) {
            TrieNode root = new TrieNode();
            for (int i = 0; i < a.size(); ++i) {
                insert(root, a.get(i));
            }

            ArrayList<String> answer = new ArrayList<String>();
            for (int i = 0; i < a.size(); ++i) {
                answer.add(getShortestValidPrefix(root, a.get(i)));
            }
            return answer;
        }

        public void insert(TrieNode root, String s) {
            char[] ch = s.toCharArray();
            for (int i = 0; i < s.length(); ++i) {
                root.count++;
                TrieNode next = root.map.getOrDefault(ch[i], new TrieNode());
                root.map.put(ch[i], next);
                root = next;
            }
            root.end = true;
            root.count++;
        }

        public String getShortestValidPrefix(TrieNode root, String word) {
            char[] ch = word.toCharArray();
            for (int i = 0; i < word.length(); ++i) {
                root = root.map.get(ch[i]);
                if (root.count == 1 || root.end) {
                    return word.substring(0, i + 1);
                }
            }
            return word;
        }
    }

    class TrieNode{
        HashMap<Character, TrieNode> map;
        int count;
        boolean end;

        public TrieNode() {
            map = new HashMap<Character, TrieNode>();
            count = 0;
            end = false;
        }
    }

}
