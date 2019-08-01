package Leetcode.No102;


import Leetcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;



public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int i = 0,l = queue.size();
            while (i < l) {
                TreeNode n = queue.remove();
                list.add(n.val);
                if(n.left != null) queue.add(n.left);
                if(n.right != null) queue.add(n.right);
                i++;
            }
            if(!list.isEmpty()) result.add(list);
        }
        return result;
    }
}
