package Leetcode.No111;

import Leetcode.TreeNode;

class Solution {
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null) return 1 + minDepth(root.right);
        if(root.right == null) return 1 + minDepth(root.left);

        int leftLen = minDepth(root.left);
        int leftRight = minDepth(root.right);

        return 1 + Math.min(leftLen, leftRight);
    }
}