package Leetcode.No32;

import java.util.Map;
import java.util.Stack;

class Solution {
    public int longestValidParentheses(String s) {
        if(s.length() < 2) return 0;
        int[] result = new int[s.length()];
        int max = 0;
        for(int i = 0;i < s.length();i++) {
            char cur = s.charAt(i);
            if(cur == '(') {
                result[i] = 0;
            } else {
                int n = 0;
                int preChar = i > 0 ? s.charAt(i - 1) : '*';
                if(preChar == '(') {
                    if(i > 1) {
                        n = result[i - 2] + 2;
                    } else {
                        n = 2;
                    }
                } else {
                    int pret = i > 1 ? i - result[i - 1] - 1 : - 1;
                    if(pret > 0 && s.charAt(pret) == '(') {
                        int pre = i - result[i - 1] - 2;
                        int prenum = pre >= 0 ? result[pre] : 0;
                        n = result[i - 1] + 2 + prenum;
                    }
                }
                result[i] = n;
                max = n > max ? n : max;
            }
        }
        return max;
    }
    public static void main(String[] args) {

    }
}