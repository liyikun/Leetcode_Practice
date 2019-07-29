package Leetcode.No287;

import java.util.Arrays;

public class Solution2 {
    public int findDuplicate(int[] nums) {
        if(nums.length == 0) return 0;
        Arrays.sort(nums);
        int pre = nums[0];
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] == pre) {
                return nums[i];
            }
            pre = nums[i];
        }
        return 0;
    }
}
