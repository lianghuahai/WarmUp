package problem.day1;

import java.util.HashMap;
import java.util.Map;

public class Problem9 {
    public static <E> void main(String[] args) {
        int x = 121;
        System.out.println(x);
        boolean reverse = isPalindrome(x);
        System.out.println(reverse);
    }
 // method 1  Revert half of the number   x=x/10,  rev = rev*x%10
    //eg: length is odd 12321 ->    x=12  rev = 123
    //eg: length is even 1221 ->    x=12  rev = 12
    //so  we have to return    (x==rev  || x==rev/10)
    
    
    //method2
    public static boolean isPalindrome(int x) {
        if(x<0){
            return false;
        }
        if(x>=0 && x<10){
            return true;
        }
        if(x%10==0){
            return false;
        }
        // digit of number
        int length=0;
        int number = x;
        while (number>0){
            number=number/10;
            length++;
        }
        number = x;
        // cut half number  and reverse it
        int firstHalf=0;
        int secondHalf=0;
        for(int i = 0;i<length/2;i++){
            firstHalf= firstHalf*10+ number%10;
            number=number/10;
        }
        //even number  has to shift one more digit
        if(length%2==1){
            secondHalf=number/10;
        }else{
            secondHalf=number;
        }
        //compare
//        System.out.println(firstHalf);
//        System.out.println(secondHalf);
//        for(int i = 0;i<=length/2;i++){
//            if(secondHalf%10 != firstHalf%10){
//                return false;
//            }
//            firstHalf=firstHalf/10;
//            secondHalf=secondHalf/10;
//        }
        return true;
        
    }
    public static boolean isPalindrome2(int x) {
        if(x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int revertedNumber = 0;
        while(x > revertedNumber) {    // the key point is x> revertednumber!!!!!!!!! so we dont have to calculate how many digits of #!!!
                                        // 12321   :   123> 12,keep looping, and then 12 > 123 is false, end the loop
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }
        String s="dfaf";
        Map<String,Integer> map = new HashMap<String,Integer>();
        char charAt = s.charAt(1);
        String sss = String.valueOf(charAt);
        System.out.println(s);
        // When the length is an odd number, we can get rid of the middle digit by revertedNumber/10
        // For example when the input is 12321, at the end of the while loop we get x = 12, revertedNumber = 123,
        // since the middle digit doesn't matter in palidrome(it will always equal to itself), we can simply get rid of it.
        return x == revertedNumber || x == revertedNumber/10;
    }
}
