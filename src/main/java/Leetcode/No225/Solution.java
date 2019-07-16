package Leetcode.No225;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {
    class MyStack {
        private Queue<Integer> q = new LinkedList<Integer>();
        /** Initialize your data structure here. */
        public MyStack() {

        }

        /** Push element x onto stack. */
        public void push(int x) {
            q.add(x);
            int sz = q.size();
            while (sz < 1) {
                q.add(q.remove());
                sz--;
            }
        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            return q.remove();
        }

        /** Get the top element. */
        public int top() {
            return q.peek();
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return q.isEmpty();
        }
    }
}
