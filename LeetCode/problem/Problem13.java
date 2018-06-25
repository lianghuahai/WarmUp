package problem;

import java.util.HashMap;
import java.util.Map;

public class Problem13 {
    public static <E> void main(String[] args) {
        String x = "MCMXCIV";
        System.out.println(x);
        int reverse = romanToInt(x);
        System.out.println("result: "+reverse);
    }
    
    
    
    public static int romanToInt(String s) {
        Map<String,Integer> map = new HashMap<String,Integer>();
        map.put("I",1);
        map.put("V",5);
        map.put("X",10);
        map.put("L",50);
        map.put("C",100);
        map.put("D",500);
        map.put("M",1000);
        if(s.length()==1){
            return (int)map.get(s);
        }
        if(s.length()==2){
            int result = 0;
            String a = String.valueOf(s.charAt(0));
            String b = String.valueOf(s.charAt(1));
            int f = (int)map.get(a);
            int ss = (int)map.get(b);
            if(f<ss){
                result = ss -f;
            }else{
                result = ss + f;
            }
            return result;
        }
        int result=0;
        for(int i = 0; i<=s.length()-1;){
            
            if(i==(s.length()-1)){
                result = result +  map.get(String.valueOf(s.charAt(s.length()-1)));
                break;
            }
            String a = String.valueOf(s.charAt(i));
            String b = String.valueOf(s.charAt(i+1));
            int f = (int)map.get(a);
            int ss = (int)map.get(b);
            if(f<ss){
                result= result+ ss -f;
                i=i+2;
            }else{
                result = result + f ;
                i=i+1;
            }
            System.out.println(result);
        }
        return result;
    }
}
