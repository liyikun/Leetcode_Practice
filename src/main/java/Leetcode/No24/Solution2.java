package Leetcode.No24;

import Leetcode.ListNode;

public class Solution2 {
    public ListNode swapPairs(ListNode head) {
        if(head == null && head.next == null) return head;

        ListNode next = head.next;
        head.next = swapPairs(head.next.next);
        next.next = head;

        return next;


    }
}
