package Leetcode.No235;

import Leetcode.TreeNode;

public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return findNode(root, p, q);
    }
    private TreeNode findNode(TreeNode node, TreeNode p, TreeNode q) {
        if(node == null || node.val == p.val || node.val == q.val) return node;

        TreeNode findLeft = findNode(node.left, p ,q);
        TreeNode findRight = findNode(node.right,p, q);

        return findLeft == null ? findRight : findRight == null ? findLeft : node;
    }
}
