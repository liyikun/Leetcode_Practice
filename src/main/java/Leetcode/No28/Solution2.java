package Leetcode.No28;

public class Solution2 {
    public int strStr(String haystack, String needle) {

        int[] next = new int[needle.length()];
        int i = 0,j = 0;
        if(next.length == 0) return 0;
        getNext(next, needle);
        for(int t : next) {
            System.out.println(t);
        }
        while (i < haystack.length() && j < needle.length()) {
            if(haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            } else {
                if(j > 0) j = next[j - 1];
                else {
                    j = next[j];
                    i++;
                }
            }
        }

        if(j == needle.length()) {
            return i - j;
        } else {
            return -1;
        }
    }

    private void getNext(int[] next, String needle) {
        int i = 1,j = 0;
        next[0] = 0;
        while (i < next.length) {
            if(needle.charAt(i) != needle.charAt(j)) {
                next[i] = 0;
                if(j > 0) j = next[j - 1];
                else {
                    j = next[j];
                    i++;
                }
            } else {
                next[i] = j + 1;
                i++;
                j++;
            }
        }
    }
    public  static void main(String[] args) {
        Solution2 instance = new Solution2();
        System.out.println(instance.strStr("aabaaabaaac","aabaaac"));
    }
}
