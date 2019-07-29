package Leetcode.No287;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    private Map<Integer, Integer> map = new HashMap<>();
    public int findDuplicate(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])) {
                return nums[i];
            } else {
                map.put(nums[i], 1);
            }
        }
        return 0;
    }
}
