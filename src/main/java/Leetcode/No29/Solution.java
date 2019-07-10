package Leetcode.No29;

class Solution {
    public int divide(long dividend, long divisor) {
        long count = 0;
        boolean isnegative = (divisor < 0 && dividend > 0) || (divisor > 0 && dividend < 0);
        long positiveDividend = Math.abs(dividend);
        long positiveDivisor = Math.abs(divisor);
        while (positiveDividend >= positiveDivisor) {
            count += 1 ;
            positiveDivisor = positiveDivisor << 1;
        }
        long result = 0;
        while (count > 0) {
            count -= 1;
            positiveDivisor = positiveDivisor >> 1;
            if(positiveDivisor <= positiveDividend ) {
                long num  = 1;
                result += num << count;
                positiveDividend -= positiveDivisor;
            }
        }
        result = isnegative? -result : result;
        if(result > Integer.MAX_VALUE) result = Integer.MAX_VALUE;
        if(result < Integer.MIN_VALUE) result = Integer.MIN_VALUE;
        return (int)result;
    }
}