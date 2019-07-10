package Leetcode.No24;


import Leetcode.ListNode;

class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode pre = new ListNode(0),result = pre;
        while (head != null && head.next != null) {
            ListNode next = head.next.next;
            pre.next = head.next;
            pre = head;
            head.next.next = head;
            head = next;
        }
        pre.next = head;
        return result.next;
    }
}


