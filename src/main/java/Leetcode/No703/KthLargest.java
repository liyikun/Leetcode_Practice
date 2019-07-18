package Leetcode.No703;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargest {
    private Queue<Integer> que;
    private int max;
    public KthLargest(int k, int[] nums) {
        max = k;
        que =  new PriorityQueue<Integer>(max, new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return (o1 - o2);
            }
        });
        for(int i : nums) {
            this.add(i);
        }
    }

    public int add(int val) {
        if(que.size() < max) {
            que.add(val);
        } else if(val > que.peek()){
            que.remove();
            que.add(val);
        }
        return que.peek();
    }

}
