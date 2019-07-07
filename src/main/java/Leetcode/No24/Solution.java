package Leetcode.No24;



class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode pre = new ListNode(0);
        ListNode result = pre;
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


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
