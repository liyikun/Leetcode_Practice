package Leetcode.No208;

public class Trie {
    private TreeNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new TreeNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TreeNode node = root;

        for(char c : word.toCharArray()) {
            if(node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new TreeNode();
            }
            node = node.children[c - 'a'];
        }

        node.isWords = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TreeNode node = root;
        for(char c : word.toCharArray()) {
            if(node.children[c - 'a'] == null) {
                return false;
            }
            node = node.children[c - 'a'];
        }
        if(!node.isWords) return false;
        return true;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TreeNode node = root;
        for(char c : prefix.toCharArray()) {
            if(node.children[c - 'a'] == null) {
                return false;
            }
            node = node.children[c - 'a'];
        }
        return true;
    }

    class TreeNode {
        TreeNode[] children = new TreeNode[26];
        Boolean isWords;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */