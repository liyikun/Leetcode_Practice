package Leetcode.No30;

import java.util.*;

public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        Set<Integer> result = new HashSet<Integer>();
        if(s.length() == 0 || words.length == 0) return new ArrayList<Integer>();

        int len = words[0].length();

        Map<String,Integer> map = new HashMap<String, Integer>();
        Map<String,Integer> map2 = new HashMap<String, Integer>();
        for(String str : words) {
            if(map.containsKey(str)) map.put(str,map.get(str) + 1);
            else map.put(str, 1);
        }

        for(int i = 0;i < s.length(); i++) {
            int start = i;
            for(int j = i; j < s.length() - len + 1; j+= len) {
                String cur = s.substring(j, j + len);
                if(map.containsKey(cur)) {
                    if(map2.containsKey(cur)) map2.put(cur,map2.get(cur) + 1);
                    else map2.put(cur, 1);
                } else {
                    start = j + len;
                    map2.clear();
                }
                if(map2.equals(map)) {
                    result.add(start);
                    start = j + len;
                    map2.clear();
                }
            }
            map2.clear();
        }

        return new ArrayList<Integer>(Arrays.asList(result.toArray(new Integer[result.size()])));
    }

    public static void main(String[] args) {
        String s = "aaa";
        String[] words = new String[]{"a","a"};
        Solution instance = new Solution();
        System.out.println(instance.findSubstring(s,words));
    }
}
