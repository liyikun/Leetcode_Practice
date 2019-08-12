package Leetcode.No212;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    private Set<String> res = new HashSet<String>();
    public List<String> findWords(char[][] board, String[] words) {
        if(board.length == 0) {
            return new ArrayList<>();
        }
        Trie trie = new Trie();
        for(String word : words) {
            trie.insert(word);
        }

        int m = board.length;
        int n = board[0].length;

        boolean[][] isVisitable = new boolean[m][n];

        for(int i = 0; i < m; i++) {
            for(int j = 0;j < n; j++) {
                dfsboard(board, isVisitable, trie, "",i,j);
            }
        }

        return new ArrayList<>(res);
    }

    private void dfsboard(char[][] board,boolean[][] isVisitable,Trie trie,String curStr,int x,int y) {
        if(x >= board.length || x < 0 || y >= board[0].length || y < 0) return;
        if(isVisitable[x][y]) return;
        String str = curStr + board[x][y];

        if(!trie.startsWith(str)) {
            return;
        }

        if(trie.search(str)) {
            res.add(str);
        }

        isVisitable[x][y] = true;

        dfsboard(board,isVisitable,trie,str,x + 1,y);
        dfsboard(board,isVisitable,trie,str,x,y - 1);
        dfsboard(board,isVisitable,trie,str,x - 1,y);
        dfsboard(board,isVisitable,trie,str,x,y + 1);

        isVisitable[x][y] = false;
    }


    class Trie {
        private TrieNode root;
        Trie() {
            root = new TrieNode();
        }
        class TrieNode {
            Boolean isWords = false;
            TrieNode[] children = new TrieNode[26];
        }
        private int caculIndex (char c) {
            return c - 'a';
        }
        public void insert(String words) {
            TrieNode node = root;

            for(char c : words.toCharArray()) {

                int asIndex = caculIndex(c);
                if(node.children[asIndex] == null) {
                    node.children[asIndex] = new TrieNode();
                }
                node = node.children[asIndex];
            }

            node.isWords = true;
        }
        public boolean search(String words) {
            TrieNode node = root;

            for(char c : words.toCharArray()) {
                int asIndex = caculIndex(c);
                if(node.children[asIndex] == null) {
                    return false;
                }
                node = node.children[asIndex];
            }

            if(!node.isWords) return false;

            return true;
        }
        public boolean startsWith(String prefix) {
            TrieNode node = root;
            for(char c : prefix.toCharArray()) {
                int asIndex = caculIndex(c);
                if(node.children[asIndex] != null) {
                    node = node.children[asIndex];
                } else {
                    return false;
                }
            }

            return true;

        }
    }
}