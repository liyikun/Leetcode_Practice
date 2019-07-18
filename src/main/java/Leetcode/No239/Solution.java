package Leetcode.No239;

import java.util.*;

class Solution {
    private Deque<Integer> window;
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length == 0) return new int[0];
        if(k == 1) return nums;
        window = new ArrayDeque<Integer>();
        int[] result = new int[nums.length - k + 1];
        for (int i = 0;i < nums.length; i++) {
            if(!window.isEmpty() && window.peekFirst() == i - k) {
                window.removeFirst();
            }
            while (!window.isEmpty() && nums[window.peekLast()] <= nums[i]) {
                window.removeLast();
            }
            window.add(i);
            if(i >= k - 1) {
                result[i - k + 1] = nums[window.peekFirst()];
            }
        }

        return result;

    }
    public static void main(String[] args) {
        Solution ins = new Solution();
        int[] result = ins.maxSlidingWindow(new int[]{1,3,1,2,0,5},3);
        for(int i : result) {
            System.out.println(i);
        }
    }
}