package Leetcode.No206;

import Leetcode.ListNode;

public class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        while (head.next != null) {
            if(pre != null) {
                ListNode next = head.next;
                head.next = pre;
                pre = head;
                head = next;
            } else {
                pre = head;
                head = head.next;
                pre.next = null;
            }
        }
        return pre;
    }
}


