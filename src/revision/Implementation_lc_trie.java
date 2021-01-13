package revision;

import java.util.HashMap;
//https://leetcode.com/problems/implement-trie-prefix-tree/
public class Implementation_lc_trie {
    class Trie {
        private TrieNode root;
        /** Initialize your data structure here. */
        public Trie() {
            root = new TrieNode();
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            TrieNode node = root;
            for (char ch : word.toCharArray()) {
                if (node.map.get(ch) == null) {
                    node.map.put(ch, new TrieNode());
                }
                node = node.map.get(ch);
            }
            node.ends = true;
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            TrieNode node = root;
            int i;
            for(i = 0; i < word.length() && node != null; ++i) {
                node = node.map.get(word.charAt(i));
            }
            if (node != null && node.ends) {
                return true;
            }
            return false;
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            TrieNode node = root;
            int i;
            for(i = 0; i < prefix.length() && node != null; ++i) {
                node = node.map.get(prefix.charAt(i));
            }
            if (node != null) {
                return true;
            }
            return false;
        }

        class TrieNode {
            HashMap<Character, TrieNode> map;
            boolean ends;

            public TrieNode() {
                map = new HashMap<Character, TrieNode>();
                ends = false;
            }
        }
    }

}
