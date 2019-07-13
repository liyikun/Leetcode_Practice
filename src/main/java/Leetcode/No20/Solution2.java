package Leetcode.No20;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution2 {
    static Map<Character,Character> map = new HashMap<Character, Character>();
    static {
        map.put(')','(');
        map.put(']','[');
        map.put('}','{');
    }
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<Character>();

        for(char i : s.toCharArray()) {
            if(!map.containsKey(i)) {
                st.push(i);
            } else if(st.empty() || st.pop() != map.get(i)) {
                return false;
            }
        }

        return st.empty();
    }

}
