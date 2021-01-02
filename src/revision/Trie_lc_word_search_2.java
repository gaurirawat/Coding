package revision;

import java.util.*;

//https://leetcode.com/problems/word-search-ii/submissions/
//ref: https://leetcode.com/problems/word-search-ii/discuss/59780/Java-15ms-Easiest-Solution-(100.00)

public class Trie_lc_word_search_2 {
    HashSet<String> set;
    public List<String> findWords(char[][] board, String[] words) {
        set= new HashSet<String>();
        TrieNode root=new TrieNode();
        for(int i=0;i<words.length;++i) {
            insert(words[i], root);
        }
        for(int i=0;i<board.length; ++i) {
            for(int j=0;j<board[0].length; ++j) {
                findWordsInner(root, i, j, board);
            }
        }
        List<String> ans= new ArrayList<String>();
        for(String s:set) {
            ans.add(s);
        }
        return ans;
    }

    public void insert(String s, TrieNode root) {
        char[] ch=s.toCharArray();
        for(int i=0;i<ch.length;++i) {
            TrieNode next=root.map.getOrDefault(ch[i],new TrieNode());
            root.map.put(ch[i],next);
            root=next;
        }
        root.word=new String(ch);
    }

    public void findWordsInner(TrieNode root, int x, int y, char[][] board) {
        if(root==null || x<0 ||y<0 || x>=board.length || y>=board[0].length) {
            return;
        }
        TrieNode next=root.map.get(board[x][y]);
        if(next!=null) {
            char letter= board[x][y];
            if(next.word!=null) {
                set.add(next.word);
            }

            board[x][y]='0';
            findWordsInner(next, x+1, y, board);
            findWordsInner(next, x-1, y, board);
            findWordsInner(next, x, y+1, board);
            findWordsInner(next, x, y-1, board);
            board[x][y]=letter;
        }

    }
}

class TrieNode {
    String word;
    HashMap<Character, TrieNode> map;
    public TrieNode() {
        word=null;
        map=new HashMap<Character, TrieNode>();
    }
}