package Leetcode.ABC;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Solution {
    private Map<Character,Integer> map = new HashMap<Character, Integer>();
    private Map<Integer,String> mapN = new HashMap<Integer, String>();
    public Solution() {
        map.put('a', 1);
        map.put('b', 2);
        map.put('c', 3);
        mapN.put(1,"a");
        mapN.put(2,"b");
        mapN.put(3,"c");
        mapN.put(0,"aa");
    }
    public void ReduceAbc(String str) {
        int n = str.length();
        int i = 0, res = 0;
        char first = str.charAt(0);
        boolean repeat = true;

        mapN.put(0,String.valueOf(new char[]{first,first}));

        while (i < n) {
            char cur = str.charAt(i);
            if(cur != first) repeat = false;
            res = res ^ map.get(cur);
            i++;
        }
        String result = repeat ? str : mapN.get(res);
        System.out.println(result);
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        s.ReduceAbc("bcab");
        s.ReduceAbc("aaaaaaaaaaa");
        s.ReduceAbc("aaab");
        s.ReduceAbc("abc");
        s.ReduceAbc("bac");
        s.ReduceAbc("bbacbacbac");
    }
}
