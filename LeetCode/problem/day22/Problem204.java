package problem.day22;

public class Problem204 {
    /*  求0到 n 之内的质数
     * ！！！任何数的倍数一定不是质数！！！！重点
     * 可以建立一个   boolean table 
     * for(int i=2;i<n;i++) 只要table是false就是质数，把 2的倍数全部设为true，然后继续到3，直到N
     * 
     */
    public int countPrimes(int n) {
        boolean []map= new boolean[n];
        int res=0;
        for(int i=2;i<n;i++){
            if(!map[i]){
                res++;
                for (int j = 2; i*j < n; j++) {
                    map[i*j] = true;
                 }
            }
        }
      return res;
    }
}
