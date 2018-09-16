package problem.day24;

public class Problem231 {
    public boolean isPowerOfTwo(int n) {
        if(n<=0)return false;
        if(n==1)return true;
        return (n&(n-1))==0;
    }
}
