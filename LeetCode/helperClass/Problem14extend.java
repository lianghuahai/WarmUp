package helperClass;

public class Problem14extend {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }
    
    
    /// this method is to  find longest common subString
    public static String longestCommonPrefix(String[] strs) {
        if(strs.length==1){
            return strs[0];
        }
        if(strs.length==0){
                return "";
            }
            int shortStr = strs[0].length();
            int position = 0;
            for(int i = 1;i<strs.length;i++){
                if( strs[i].length()<shortStr){
                    shortStr=strs[i].length();
                    position=i;
                }
            }
            // loop shortest string using  "slide window"
            String str = strs[position];
            StringBuffer sb = new StringBuffer();
            StringBuffer sol = new StringBuffer();
            int left=0;
            int right = 0;
        boolean temp= false;
            int n = str.length();
            while(right<n){
                System.out.println(sb.toString()+"sb.tostring");
                System.out.println(str.charAt(right)+"++++");
                sb.append(str.charAt(right));
                System.out.println(sb.toString()+"sb.tostring");
                boolean flag = true;
                for(String s : strs){
                    System.out.println("data:"+s);
                    if(s.indexOf(sb.toString())==-1){
                        System.out.println("jinlai");
                        flag=false;
                        break ;
                    }
                }
                if(flag){
                    System.out.println("--!");
                    temp=true;
                    right++;
                }else{
                    System.out.println("!!");
                    if(temp){
                        
                    
                    if(sol.length()<sb.length()){
                        sol.setLength(0);
                        for(int i =0;i<sb.length()-1;i++){
                            sol.append(sb.charAt(i));
                        }
                    }
                    sb.setLength(0);
                    right++;
                        }
                    else{
                        sb.setLength(0);
                      break;  
                    }
                    
                }
            }
            if(sol.length()<sb.length()&& temp){
                        sol.setLength(0);
                        for(int i =0;i<sb.length();i++){
                            sol.append(sb.charAt(i));
                        }
                    }
            
            return sol.toString();
            
    }

}
