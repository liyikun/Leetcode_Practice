package Leetcode.No24;



class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode i = head;
        ListNode result = new ListNode(0);
        ListNode t = result;
        while (i != null) {
            ListNode swap = i;
            i = i.next;
            ListNode next = i.next;
            swap.next = next;
            i.next = swap;
            t.next = i;
            i = next;
            t = next;
        }

        return result;
    }
}


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
