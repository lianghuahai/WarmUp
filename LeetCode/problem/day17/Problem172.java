package problem.day17;

public class Problem172 {

    public static void main(String[] args) {
        trailingZeroes(13);
    }
    public static int trailingZeroes(int n) {
        long m =1;
        for(long i=n;i>0;i--){
            m=m*i;
        }
        int res =0;
        while(m!=0){
            if(m%10==0){
                res++;
                m=m/10;
            }else{
                return res;
            }
        }
        return res;
    }
}
