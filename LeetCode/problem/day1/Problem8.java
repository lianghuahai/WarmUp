package problem.day1;

public class Problem8 {

    public static void main(String[] args) {
        int myAtoi = myAtoi("2147483646");
//        int myAtoi = myAtoi("-91283472332");
        System.out.println(myAtoi);

    }
    public static int myAtoi(String str) {
        if(str.length()==0){
            return 0;
        }
        boolean flag = true;
        boolean valid = true;
        boolean numeric =true;
        int sign = 1;
        int number = 0;
        for(int i=0;i<str.length();i++){
            if(flag&& str.charAt(i)==' '){
                continue;
            }else{
                if(valid && str.charAt(i)=='-'){
                    sign= 0 -sign;
                    valid=false;
                }else if(valid && str.charAt(i)=='+'){
                    valid=false;
                }else{
                    if(numeric){
                        if(str.charAt(i)>='0' && str.charAt(i)<='9'){
                            if(  ((long)number*10+(long)Integer.parseInt(String.valueOf(str.charAt(i)))) < (0-Math.pow(2,31)) || (long)((long)number*10+(long)Integer.parseInt(String.valueOf(str.charAt(i)))) >(Math.pow(2,31)-1)){
                                return -2147483648;
                            }else{
                                 number = number * 10+ Integer.parseInt(String.valueOf(str.charAt(i)));
                            }
                        }else{
                            return 0;
                        }
                        numeric= false;
                    }else{
                         if(str.charAt(i)>='0' && str.charAt(i)<='9'){
                             if(  (long)((long)number*10+(long)Integer.parseInt(String.valueOf(str.charAt(i)))) < (0-Math.pow(2,31)) || (long)((long)number*10+(long)Integer.parseInt(String.valueOf(str.charAt(i)))) >(Math.pow(2,31)-1)){
                                 return -2147483648;
                             }else{
                                 number = number * 10+ Integer.parseInt(String.valueOf(str.charAt(i)));
                            }
                        }else{
                             return number*sign;
                         }
                    }
                    valid=false;
                }
                flag=false;
            }
            System.out.println(number);
        }
        return number*sign;
        
    }
}
