package problem.day3;

public class Problem38 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
//        String countAndSay = countAndSay(5);
        String s= "123456";
//        System.out.println(countAndSay);
//        System.out.println(String.valueOf(s.charAt(0)));
    }
    public String countAndSay1(int n) {
        if(n ==1){
           return "1";
       }
       String numStr = countAndSay(n-1);
       StringBuffer sb = new StringBuffer();
       String previous=String.valueOf(numStr.charAt(0));  // first character
       int counter=1;
       for(int i =1;i<numStr.length();i++){  // starting at second character
           String current = String.valueOf(numStr.charAt(i));
           if(current.equals(previous)){
               counter++;
           }else{
               sb.append(counter);
               sb.append(previous);
               previous=current;
               counter=1;
           }
       }
       // handle last character, two case:  a. last char!=previous  1112    b last char==previous 1111
       sb.append(counter);
       sb.append(previous);
       return sb.toString();
   }
    
    
    public String countAndSay(int n) {
        if(n ==1){
           return "1";
       }
       String numStr = countAndSay(n-1);
       StringBuffer sb = new StringBuffer();
//       String previous=String.valueOf(numStr.charAt(0));  // 1 1 2 2 1
       String previous="";  // 1 1 2 2 1
       
       //System.out.println(previous);
       int counter=1;
       for(int i =0;i<numStr.length();i++){
           String element = String.valueOf(numStr.charAt(i));
           if(i==0){
               previous=element;
               counter=1;
               continue;
           }
          // System.out.println(element);
           if(element.equals(previous)){
               //previous=element;   21
               counter++;
           }else{
               sb.append(counter);
               sb.append(previous);
               previous=element;
               counter=1;
           }
       }
       sb.append(counter);
       sb.append(previous);
       return sb.toString();
   }
    public static String countAndSay3(int n) {
        if(n ==1){
            return "1";
        }
        String numStr = countAndSay3(n-1);
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
