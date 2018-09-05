package problem.day23;

import java.util.HashSet;
import java.util.Set;

public class Problem202 {

    public static void main(String[] args) {
        isHappy(19);

    }
    public static boolean isHappy(int n) {
        Set<Integer> dict = new HashSet();
        while(dict.add(n)){
            int ssum=0;
            while(n>0){
                int remain=n%10;
                ssum+=remain*remain;
                n=n/10;
            }
            if(ssum==1){
                return true;
            }else{
                n=ssum;
            }
        }
        return false;
        
    }
    //iteration
    public boolean isHappy3(int n) {
        Set<Integer> inLoop = new HashSet<Integer>();
        int squareSum,remain;
            while (inLoop.add(n)) {
                    squareSum = 0;
                    while (n > 0) {
                        remain = n%10;
                            squareSum += remain*remain;
                            n /= 10;
                    }
                    if (squareSum == 1)
                            return true;
                    else
                            n = squareSum;

            }
            return false;

    }
    
    
    
    
//    recursion
    public boolean isHappy2(int n) {
        if(n<10) {
                if(n==1||n==7) return true;
                else return false;
         }
        int b;int sum=0;
        while(n>0) {
                  b=n%10;
                  sum=sum+b*b; 
                  n=n/10;
          } 
     return isHappy(sum);
  }
}
