package Leetcode.No232;

import java.util.Stack;

public class MyQueue {
    private Stack<Integer> intputs;
    private Stack<Integer> outputs;
    private void load() {
        if(outputs.empty()) {
            while (!intputs.empty()) outputs.push(intputs.pop());
        }
    }
    public MyQueue() {
        intputs = new Stack<Integer>();
        outputs = new Stack<Integer>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        intputs.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        this.load();
        return outputs.pop();
    }

    /** Get the front element. */
    public int peek() {
        this.load();
        return outputs.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return intputs.empty() && outputs.empty();
    }

}
