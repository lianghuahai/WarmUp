package problem.day4;

public class Problem29 {

    public static void main(String[] args) {
//        int divide = divide(-2147483648,-1);
        int divide = divide(-2147483648,-1);
        System.out.println(divide);
//        System.out.println(3<<1);
//        System.out.println(6<<1);
    }
    public static int divide(int dividend, int divisor) {
            
        // edge case problem  int divide = divide(-2147483648,-1);
        //dividend == Integer.MIN_VALUE && divisor == -1)   is the key!!!!!!
        if (divisor == 0 || (dividend == Integer.MIN_VALUE && divisor == -1)) return Integer.MAX_VALUE;
        long dividend2 = dividend;
            long divisor2 = divisor;
            if(dividend == 0){
                return 0;
            }

            int res = 0;
            int sign =1;
            if(divisor <0){
                sign = -1;
            }
            if(dividend <0){
                sign = sign*(-1);
            }
            
            dividend2 = Math.abs(dividend2);
            divisor2 = Math.abs(divisor2);
            int count =1;
            System.out.println(dividend2);
            System.out.println(divisor2);
            while (dividend2 >= divisor2) { 
                 long temp = divisor2, multiple = 1;
                while (dividend2 >= (temp << 1)) {
                    temp <<= 1;
                    multiple <<= 1;
                }
                dividend2 -= temp;
                res += multiple;
            }
            return sign*res;
            
        }
        
}
