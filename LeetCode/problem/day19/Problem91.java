package problem.day19;

public class Problem91 {

    public static void main(String[] args) {
        System.out.println(numDecodings("123"));

    }
    //recursion rule
    /*
    "" =>  ""   1
    "123" =>  a + "23"   +    w + "3"
    "293" =>  b + "93"   
    "012" =>  0
    */
    //problem  soving pattern
    /*
    ""  (2) 
    1    1   种
 ----------------------   
    ""  2 (2) 
    1   1  1
    
    ""  (2 2)
    1  1   1+1
  ----------------------  
    ""  2 2 (6)             =>"226"  = 3
    1   1 2  2
    ""  2  (26)
    1   1 2  1+2
  ----------------------
  */
 // iterator + dp    time O(n)   space O(n)
    public static int numDecodings(String s) {
        if(s==null||s.length()==0)return 0;
        int num1 =0;
        int num2 =0;
        
        
        
    
        return num2;
    
    }
    
    
     
    // iterator + dp    time O(n)   space O(n)
    public static int numDecodings1(String s) {
        if(s==null||s.length()==0)return 0;
        int len = s.length();
        int []mapping= new int[s.length()+1];
        mapping[0]=1;
        mapping[1]=  s.charAt(0)=='0'? 0:1;
        for(int i=2 ;i<=len;i++){
            int num1 = Integer.valueOf(s.substring(i-1,i));
            int num2 = Integer.valueOf(s.substring(i-2,i));
            if(num1>=1 && num1 <=9){
                 mapping[i] += mapping[i-1];
            }
            if(num2>=10 && num2<=26){
                mapping[i] += mapping[i-2];
            }
        }
        return mapping[s.length()];
    }
    
    
 // recursion + dp    time O(n)   space O(n)
    public int numDecodings2(String s) {
        if(s==null||s.length()==0)return 0;
        int []mapping= new int[s.length()+1];
        return recursion(s,0,mapping);
    }
    public int recursion(String s,int index,int []mapping){
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
