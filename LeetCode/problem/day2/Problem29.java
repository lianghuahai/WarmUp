package problem.day2;

public class Problem29 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }
    //key point is to using divisor= divisor+divisor; 2^n increasing
    // This will reduce time complexity from n ->  logn
    public static int divide(int dividend, int divisor) {
     // edge case problem  int divide = divide(-2147483648,-1);
        //ans = (sign == 1)? Integer.MAX_VALUE : Integer.MIN_VALUE;
        int sign = 1;
        if((dividend<0 && divisor>0)||(dividend>0 && divisor<0))sign=-1;
        long idividend=Math.abs((long)dividend);
        long idivisor= Math.abs((long)divisor);
        if(idividend==0 || idividend<idivisor)return 0;
        long multiple=  idivide(idividend,idivisor);
        int res=0;
        if(multiple>Integer.MAX_VALUE||multiple<Integer.MIN_VALUE){
            res= (sign==1)?Integer.MAX_VALUE:Integer.MIN_VALUE;
        }else{
            res= (int)(sign*multiple);
        }
        return res;
    }
    public static long idivide(long dividend, long divisor) {
        if(dividend<divisor)return 0;
        long sum = divisor;
        long multiple=1;
        while((sum+sum)<=dividend){
            sum+=sum;
            multiple+=multiple;
        }
        return multiple+idivide(dividend-sum,divisor);
    }
    
    
    
    //method
    public static int divide2(int dividend, int divisor) {
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
