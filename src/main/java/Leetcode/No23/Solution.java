package Leetcode.No23;

public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        return Merge(lists,0,lists.length - 1);

    }

    public ListNode Merge(ListNode[] lists,int left,int right) {
        if (left >= right) return lists[left];
        int mid = left + (right - left); // 2
        ListNode list1 = Merge(lists,left,mid);
        ListNode list2 = Merge(lists,mid+1,right);
        return Merge(list1,list2);
    }

    public ListNode Merge(ListNode list1,ListNode list2) {
        if(list1 == null) return list2;
        if(list2 == null) return list1;
        if(list1.val < list2.val) {
            list1.next = Merge(list1.next,list2);
            return list1;
        } else {
            list2.next = Merge(list1,list2.next);
            return list2;
        }
    }
}


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
