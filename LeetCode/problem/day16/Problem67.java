package problem.day16;

public class Problem67 {

    public static void main(String[] args) {
        System.out.println(addBinary("11","1"));

    }
    public static String addBinary(String a, String b) {
        int result = Integer.parseInt(a)+Integer.parseInt(b);
        String temp = String.valueOf(result);
        StringBuffer sb=  new StringBuffer();
        int carry = 0;
        for(int i = 0;i<temp.length();i++){
            int digit =(temp.charAt(i)-'0')+carry;
            System.out.println(digit);
            carry = digit>1 ? 1:0;
            digit = digit>=2? digit-2:digit;
            sb.append(digit>>1);
        }
        if(carry==1){
            sb.append(1);
        }
//        System.out.println(sb.toString());
        return sb.reverse().toString();
    }
}
