package problem.day1;

import java.util.ArrayList;
import java.util.List;

class Problem7 {
    public static <E> void main(String[] args) {
        int x = 1234567899;
        System.out.println(x);
        int reverse = reverse2(x);
        System.out.println(reverse);
    }
    
    public static int reverse(int x) {
        System.out.println(Math.pow(2, 31));
        if(x<(-(Math.pow(2, 31))) || (x>((Math.pow(2, 31))-1))){
            System.out.println("sfda");
            return 0;
        }
        if(x<10&& x>=0){
            return x;
        }
        int sign = 1;
        if(x<0){
            x= x * (-1);
            sign= (-1);
        }
        int number  = x;
        List<Integer> list = new ArrayList<Integer>();
        while(number>0){
            list.add(number%10);
            number = number /10;
        }
        int size = list.size();
           x=0;
        boolean flag = true;
        for(int length = list.size(); length>=1;length--){
            if(((int)list.get(size-length)==0) && flag){
                continue;
            }
            x=(int) (x+((int) list.get(size-length))*(Math.pow(10, length-1)));
            flag= false;
            
        }
           x=x*sign;
           if(x<(-(Math.pow(2, 31))) || (x>((Math.pow(2, 31))-1))){
               return 0;
           }
    return x;
}

    public static int reverse2(int x){
        if(x<(-(Math.pow(2, 31))) || (x>((Math.pow(2, 31))-1))){
            return 0;
        }
         if(x<10&& x>=0){
            return x;
        }
        int sign = 1;
        if(x<0){
            x= x * (-1);
            sign= (-1);
        }
        
        String word = String.valueOf(x);
        StringBuffer sb = new StringBuffer();
        for (int j = word.length()-1; j >=0 ; j--) {
            sb.append(word.charAt(j));
        }
        String news = sb.toString();
        System.out.println(sb.toString());
        try {
            x= Integer.parseInt(news);
        } catch (Exception e) {
            return 0;
        }
        
        System.out.println("sfddadf");
        x=x*sign;
        if(x<=(-(Math.pow(2, 31)-1)) || (x>=((Math.pow(2, 31))-1))){
               return 0;
           }
        System.out.println("sdfa");
        return x;
    }

}
