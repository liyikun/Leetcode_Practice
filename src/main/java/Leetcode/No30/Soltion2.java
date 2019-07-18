package Leetcode.No30;


import java.util.*;

class Solution2 {
    public List<Integer> findSubstring(String s, String[] words) {
        if(s.length() == 0 || words.length == 0) return new ArrayList<Integer>();

        int len = words[0].length();
        int totalLen = len * words.length;
        Map<String,Integer> map = new HashMap<String, Integer>();
        Map<String,Integer> map2 = new HashMap<String, Integer>();
        for(String str : words) {
            if(map.containsKey(str)) map.put(str,map.get(str) + 1);
            else map.put(str, 1);
        }
        List<Integer> result = new ArrayList<Integer>();
        for(int i = 0;i < len; i++) {
            int start = i;
            for(int j = i; j <= s.length() - len; j+= len) {
                String cur = s.substring(j, j + len);
                if(!map.containsKey(cur)) {
                    start = j + len;
                    map2.clear();
                } else {
                    if(!map2.containsKey(cur)) map2.put(cur, 1);
                    else if(map2.get(cur).equals(map.get(cur))) {
                        String temp;
                        while (!(temp = s.substring(start, start + len)).equals(cur)) {
                            map2.put(temp, map2.get(temp) - 1);
                            start += len;
                        }
                        start += len;
                    } else {
                        map2.put(cur,map2.get(cur) + 1);
                    }
                    if(j + len - start == totalLen) {
                        result.add(start);
                        String firstWord = s.substring(start, start + len);
                        map2.put(firstWord,map2.get(firstWord) - 1);
                        start += len;
                    }
                }
            }
            map2.clear();
        }

        return result;
    }

    public static void main(String[] args) {
        String s = "aaa";
        String[] words = new String[]{"a","a"};
        Solution instance = new Solution();
        System.out.println(instance.findSubstring(s,words));
    }
}
