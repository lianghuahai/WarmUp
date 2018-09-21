package problem.day3;

public class Problem38 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String countAndSay = countAndSay(5);
        String s= "123456";
        System.out.println(countAndSay);
//        System.out.println(String.valueOf(s.charAt(0)));
    }
    public static String countAndSay(int n) {
        if(n ==1){
            return "1";
        }
        String numStr = countAndSay(n-1);
        StringBuffer sb = new StringBuffer();
//        String previous=String.valueOf(numStr.charAt(0));  // 1 1 2 2 1
        String previous="";  // 1 1 2 2 1
        int counter=1;
        for(int i =0;i<numStr.length();i++){
            String element = String.valueOf(numStr.charAt(i));
            if(i==0){
                previous=element;
                counter=1;
                continue;
            }
            if(element.equals(previous)){
                counter++;
            }else{
                sb.append(counter);
                sb.append(previous);
                previous=element;
                counter=1;
            }
        }
        if(true){
            sb.append(counter);
            sb.append(previous);
        }
        return sb.toString();
    }

}
