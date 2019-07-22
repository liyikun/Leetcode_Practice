package Leetcode.No15;

import java.util.*;

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        if(nums.length < 3) return new ArrayList<>();
        Arrays.sort(nums);
        Set<List<Integer>> set = new HashSet<>();

        for(int i = 0; i < nums.length - 2;i ++) {
            int v = nums[i];
            if(i >= 1 && v == nums[i-1]) continue;
            Map<Integer,Integer> map = new HashMap<>();
            for (int j = i + 1; j < nums.length;j ++) {
                int v2 = nums[j];
                if(!map.containsKey(v2)) {
                    map.put(-v-v2, j);
                } else {
                    List<Integer> arrays = new ArrayList();
                    arrays.add(v);
                    arrays.add(-v-v2);
                    arrays.add(v2);
                    set.add(arrays);
                }
            }
        }
        return new ArrayList<>();
    }
}