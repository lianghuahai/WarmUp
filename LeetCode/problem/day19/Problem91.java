package problem.day19;

public class Problem91 {

    public static void main(String[] args) {
        System.out.println(numDecodings("123"));

    }
    public static int numDecodings(String s) {
        if(s==null||s.length()==0)return 0;
        int []mapping= new int[s.length()+1];
        return recursion(s,0,mapping);
    }
    public static int recursion(String s,int index,int []mapping){
        if(index==s.length())return 1;
        if(s.charAt(index)=='0')return 0;
        if(mapping[index]>0)return mapping[index];
        int res = recursion(s,index+1,mapping);
        if(index<s.length()-1){
            String str = s.substring(index,index+2);
            if(Integer.valueOf(str)>=10 && Integer.valueOf(str)<=26)res+=recursion(s,index+2,mapping);
        }
        mapping[index]=res;
        return res;
    }
}
