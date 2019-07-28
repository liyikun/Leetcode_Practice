package Leetcode.No50;

public class Solution {
    public double myPow(double x, int n) {
        if(n == 0) return 1;
        if(n == 1) return x;
        if(n == -1) return 1 / x;
        double m = n % 2 != 0 ? n > 0 ? x : 1 / x : 1;
        double val = myPow(x, n / 2);
        return val * val * m;
    }
}
