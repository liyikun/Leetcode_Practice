package Leetcode.No98;

import Leetcode.TreeNode;

public class Solution {
    private double pre = -Double.MAX_VALUE;
    private boolean success = true;
    public boolean isValidBST(TreeNode root) {
        findBst(root);
        return success;
    }
    private void findBst(TreeNode node) {
        if(node == null) return;
        if(!success) return;
        findBst(node.left);
        if(node.val <= pre) success = false;
        pre = node.val;
        findBst(node.right);
    }
}
