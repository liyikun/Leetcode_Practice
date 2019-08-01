package Leetcode.No104;

import Leetcode.TreeNode;

public class Solution {
    public int maxDepth(TreeNode root) {
        return searchRoot(root, 1);
    }
    private int searchRoot(TreeNode root,int len) {
        if(root == null) return len - 1;
        if(root.left == null && root.right == null) return len;
        int leftLen = searchRoot(root.left, len + 1);
        int leftright = searchRoot(root.right, len + 1);

        return leftLen > leftright ? leftLen : leftright;

    }
}
