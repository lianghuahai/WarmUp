package problem.day17;

public class problem5 {

    public static void main(String[] args) {
        String longestPalindrome = longestPalindrome("ababd");
        System.out.println(longestPalindrome);

    }   
    
    public static String longestPalindrome(String s) {
      //1.   dp 
        // dp[i][j]=true means that  string from index i to j is palindrome
        if(s==null||s.length()==0)return s;
        boolean [][] dp = new boolean[s.length()][s.length()];
        String res = "";
        int max = 0;
        for(int j = 0;j<s.length();j++){
            for(int i=0;i<=j;i++){
                dp[i][j] = (s.charAt(i) == s.charAt(j)) && ( j-i <=2 || dp[i+1][j-1]);
                if(dp[i][j]){
                    if(j-i+1>max){
                        max=j-i+1;
                        res=s.substring(i,j+1);
                    }
                }
            }
        }
        return res;
    }
  
    
    
    //2.   central expanding   mid to edges 中心扩散
    /*
    String res="";
    for(int j = 0;j<s.length();j++){
        expanding(s,i,i); // odd
        expanding(s,i,i+1); //even
    }
       return res;
    }
     public String expanding(String s,int left, int right) {
        while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
            left--;
            right++;
        }
        String curr = s.substring(s,left+1,right);
        if(curr.length>res.length()){
            res = curr;
        }
     }
    */
    
    
    /*   3. foolish method
        if(s==""){
        return "";
    }
    if(s.length()==1){
        return s;
    }
    StringBuffer sb = new StringBuffer();
    //loop per char of string
    int i=0;
    int j=0;
    int lb=1;
    int r = 0;
    boolean flag= false;
    boolean hasAnswer =false;
    for( i=0;i<s.length();i++){
        //i = 0,  j=  length
         flag = false;
        boolean tureOUt=false;
        for(j=s.length()-1;j>=i+1;j--){
            int left=i; 
            int right = j;
            if(s.charAt(i)==s.charAt(j)){
                if((s.length()-i)<=(r-lb)){
                    tureOUt=true;
                    break;
                }
                flag=true;
    
                while(left<right){
                    if(s.charAt(left)==s.charAt(right)){
                        left++;
                        right--;
                        
                    }else{
                        
                        flag=false;
                        break;
                    }
                    
                }
                if(  flag ){
                    if((r-lb)<(j-i)){
                        lb=i;
                        r=j;
                    }
                    hasAnswer=true;
                }
            }
            if(flag){
                break;
            }
        }
        if(tureOUt){
                    break;
                }
        
        }
        System.out.println(lb);
        System.out.println(r);
        System.out.println(hasAnswer);
        if(lb>r || (!hasAnswer)){
            System.out.println("r");
            return String.valueOf(s.charAt(r));
        }
        
        while(lb<=r){
           sb.append(String.valueOf(s.charAt(lb))); 
            lb++;
        }
        return sb.toString();*/
}
 