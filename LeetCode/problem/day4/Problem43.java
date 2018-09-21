package problem.day4;

public class Problem43 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }
    public static String multiply(String num1, String num2) {
        if(num1.equals("0")||num2.equals("0")){
            return "0";
        }
        if(num1.equals("1")){
            return num2;
        }
        if(num2.equals("1")){
            return num1;
        }
        //eg:  123 *  45,   2 * 4 = 08;    2 is index 1, 4 is index 0; then the result 08 is index[i+j,i+j+1] = [0,1]
        // index[i]* index[j] = index[i+j,i+j+1]
        int len  = num1.length()+num2.length();
        int[] result = new int[len];
        for(int i =0;i<num1.length();i++){
            for(int j = 0;j<num2.length();j++){
                int res = (num1.charAt(i)-'0')*(num2.charAt(j)-'0');
                result[i+j] =  result[i+j]+res/10;
                result[i+j+1]=result[i+j+1]+res%10;
            }
        }
        for(int k = len-1;k>0;k--){
            int carry = result[k]/10;
            result[k]= result[k]%10;
            result[k-1]=result[k-1]+carry;
        }
        StringBuffer sb = new StringBuffer();
        for(int m = 0;m<len;m++){
            // System.out.print(result[m]);
            if(result[m]==0){
                continue;
            }
            sb.append(result[m]);
        }
        return sb.toString();
    }
}
