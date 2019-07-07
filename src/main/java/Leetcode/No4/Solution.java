package Leetcode.No4;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public String longestPalindrome(String s) {

        int n = s.length();

        if(n == 0) return s;

        String maxStr = String.valueOf(s.charAt(0));
        int maxLength = 1;
        int maxi = 0;
        int maxj = 0;

       Boolean[][] dp = new Boolean[n][n];

        for(int i = 0;i < n;i++) {
            for(int j = 0;j <= i ; j++) {
                dp[i][j] = false;
                if(s.charAt(i) == s.charAt(j) && ((i - j <= 2) || dp[i-1][j+1])) {

                    dp[i][j] = true;

                    if(i - j + 1 > maxLength) {
                        maxi = i;
                        maxj = j;
                        maxLength = i - j + 1;
                    }
                }
            }
        }

        maxStr = s.substring(maxj, maxi + 1);

        return maxStr;

    }
}