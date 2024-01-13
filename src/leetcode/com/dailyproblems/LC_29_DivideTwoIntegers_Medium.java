package leetcode.com.dailyproblems;

class LC_29_DivideTwoIntegers_Medium {
    /**
     10  -5  -2
     -10  5. -2
     10.  5.  2
     -10  -5  2
     */
    public int divideIntuition(int dividend, int divisor) {
        int negatives = 0;
        if ( dividend < 0 ){
            negatives++;
            dividend = -dividend;
        }

        if (divisor < 0){
            negatives++;
            divisor = -divisor;
        }
        long quotient = 0;
        while( dividend >= divisor){
            dividend = dividend - divisor;
            quotient++;
        }

        if (negatives == 1){
            quotient = -quotient;
        }

        if (quotient < Integer.MIN_VALUE){
            quotient = Integer.MIN_VALUE;
        }

        if (quotient > Integer.MAX_VALUE){
            quotient = Integer.MAX_VALUE;
        }

        return (int)quotient;

    }

    public int divide(int dividend, int divisor) {
        int result_sign = 1;

        if (dividend < 0 ^ divisor < 0){
            result_sign = -1;
        }else{
            result_sign = 1;
        }

        dividend =  Math.abs(dividend);
        divisor = Math.abs(divisor);

        long quotient = 0;
        //if dividend is -1 abs val is 1 and divisor is -2^31 even the abs value is -2^31 only
        // in that case this loop will execute for ever and time limit will be exceeded
        //so this solution works only for normal cases

        while( dividend >= divisor){
            dividend = dividend - divisor;
            quotient++;
        }

        quotient = result_sign * quotient;
        if (quotient < Integer.MIN_VALUE){
            quotient = Integer.MIN_VALUE;
        }
        if (quotient > Integer.MAX_VALUE){
            quotient = Integer.MAX_VALUE;
        }
        return (int)quotient;

    }
}
