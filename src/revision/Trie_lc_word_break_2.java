package revision;

import java.util.*;
/*
first approach: trie
second approach: memoization+backtracking.
if s="aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" and dict =["a", "aa", "aaa"....]
The below implementation using trie will lead to n^l where l=s.length() and n=dict.length;
in such a scenario it is better to not use a tree and go ahead with the second approach

Second approach. For every index, make a list of all the possible words. This will help us to remove all invalid words.
Then keep adding every valid word one by one as we do in our combination problem.
 */
public class Trie_lc_word_break_2 {
    class Approach{
        public List<String> wordBreak(String s, List<String> dictionary) {
            List<String> answer= new ArrayList<String>();
            if(s==null || s.length()==0) {
                return answer;
            }

            TrieNode root= new TrieNode();
            for(int i=0; i<dictionary.size(); ++i) {
                insert( root, dictionary.get(i) );
            }
            getResult(0, s, answer, new ArrayList<String>(), root, root);
            return answer;
        }

        public void getResult(int i, String s, List<String> answer, List<String> curr,  TrieNode currNode, TrieNode rootNode) {
            if( i == s.length() && curr==rootNode) {
                String temp = String.join(" ", curr);
                answer.add(temp);
            }
            if( i >= s.length() ) {
                return;
            }
            TrieNode nextNode = currNode.map.get(s.charAt(i));
            if(nextNode != null) {
                if( nextNode.word!=null ) {
                    curr.add(nextNode.word);
                    getResult(i+1, s, answer, curr, rootNode, rootNode);
                    curr.remove(nextNode.word);
                }
                getResult(i+1, s, answer, curr, nextNode, rootNode);
            }
        }

        public void insert(TrieNode root, String s) {
            for(int i=0; i<s.length(); ++i) {
                TrieNode next = root.map.getOrDefault(s.charAt(i), new TrieNode());
                root.map.put( s.charAt(i), next );
                root = next;
            }
            root.word = s;
        }
    }

    class Approach2 {
        public List<String> wordBreak(String s, List<String> wordDict) {
            ArrayList<String>[] list = new ArrayList[s.length()];
            HashSet<String> set = new HashSet<String>();
            set.addAll(wordDict);
            // wordDict.removeAll();
            // wordDict.addAll(set);
            for (int l = 0; l < s.length(); ++l) {
                list[l] = new ArrayList<String>();
                for (int r = l + 1; r <= s.length(); ++r) {
                    String temp = s.substring(l, r);
                    if (set.contains(temp)) {
                        list[l].add(temp);
                    }
                }
            }
            ArrayList<String> answer = new ArrayList<String>();
            getResult(0, s, list, new ArrayList<String>(), answer);
            return answer;
        }

        public void getResult(int i, String s, ArrayList<String>[] list, ArrayList<String> current, ArrayList<String> answer) {
            if (i == s.length()) {
                answer.add(String.join(" ", current));
                return;
            }
            for (String validWord : list[i]) {
                current.add(validWord);
                getResult(i + validWord.length(), s, list, current, answer);
                current.remove(current.size() - 1);
            }
        }
    }
}