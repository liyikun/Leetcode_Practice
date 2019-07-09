package Leetcode.No28;

class Solution {
    public int strStr(String haystack, String needle) {
        int i = 0,j = 0;
        int[] next = new int[needle.length()];
        getNext(next,needle);
        while (i < haystack.length() && j < needle.length()) {
            if(j == -1 || haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }
        if(j == needle.length()) {
            return i - j;
        } else {
            return -1;
        }
    }

    private void getNext(int[] next, String needle) {
        if(next.length == 0) return;
        int i = 0;
        int j = -1;
        next[0] = -1;

        while (i < next.length - 1) {
            if(j == -1 || needle.charAt(i) == needle.charAt(j)) {
                j++;
                i++;
                next[i] = j;
            } else {
                j = next[j];
            }
        }

    }
}