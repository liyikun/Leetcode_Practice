package Leetcode.No25;

import Leetcode.ListNode;

import java.util.List;
import java.util.Stack;

public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode result = new ListNode(0);
        result.next = head;

        ListNode start = result;
        ListNode end = result;

        while (end.next != null) {
            for(int i = 0;i < k && end != null ;i++) end = end.next;
            if(end == null) break;
            ListNode first = start.next;
            ListNode next = end.next;
            end.next = null;
            start.next = reverse(first);
            first.next = next;
            start = first;
            end = start;

        }

        return result.next;
    }
    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

}
