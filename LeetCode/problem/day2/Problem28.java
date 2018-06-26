package problem.day2;

public class Problem28 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        strStr("","");

    }
    public static int strStr(String haystack, String needle) {
        if(haystack.equals("")&& needle.equals("")){
            return 0;
        }
        if(haystack.equals("")){
            return -1;
        }
        if( needle.equals("")){
            return 0;
        }
        for(int i =0;i<=haystack.length()-needle.length();i++){
            boolean flag = true;//???????
            for(int j =0;j<needle.length();j++){
                if(haystack.charAt(j+i)!=needle.charAt(j)){
                    flag = false;
                }
            }
            if(flag){
                return i;
            }
        }
        return -1;
    }
}
