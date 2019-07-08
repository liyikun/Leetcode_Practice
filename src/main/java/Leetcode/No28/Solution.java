package Leetcode.No28;

class Solution {
    public int strStr(String haystack, String needle) {
        int n = haystack.length();
        int needleLen = needle.length();

        int w = 0;
        int result = -1;

        for(int i = 0;i < n;i ++) {
            char cur = haystack.charAt(i);

            System.out.println(w);
            System.out.println(needleLen - i);
            if(w >= needleLen - i) {
                result = i;
                break;
            }

            if(needle.charAt(w) == cur) {
                w++;
            } else {
                w = 0;
            }
        }

        return result;
    }
}