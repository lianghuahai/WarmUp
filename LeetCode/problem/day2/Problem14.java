package problem.day2;

public class Problem14 {

    public static void main(String[] args) {
        String[] strs ={"flower","flow","flight"};
//        String[] strs ={"ab","a"};
//        String[] strs ={"c","acc","ccc"};
        String s = longestCommonPrefix(strs);
        System.out.println(s);

    }
    public static String longestCommonPrefix(String[] strs) {
        if(strs.length==1){
            return strs[0];
        }
        if(strs.length==0){
                return "";
            }
        StringBuffer sb = new StringBuffer();
        String str = strs[0];
        boolean flag= true;
        try{
            for(int i = 0;i<str.length();i++){
                 sb.append(str.charAt(i));
                 char tem = str.charAt(i);
                 for(String s : strs){
//                     System.out.println(s.charAt(i)+"---");
                     if(i<s.length()){
                        if(s.charAt(i)!= tem){
                            System.out.println("===");
    //                        if(s.indexOf(sb.toString())!= 0){
                            sb.deleteCharAt(sb.length()-1);
                            flag=false;
                            break ;
                          }
                     }
                     else{
                         sb.deleteCharAt(sb.length()-1);
                         flag=false;
                         break;
                     }
                  }
                if(!flag){
                    break;
                }
            }
        }catch(Exception e){
            System.out.println("cuo le");
            return sb.toString();
        }
        return sb.toString();
    }
    public String longestCommonPrefix2(String[] strs) {
        if(strs.length==1){
            return strs[0];
        }
        if(strs.length==0){
                return "";
            }
        StringBuffer sb = new StringBuffer();
        String str = strs[0];
        boolean flag= true;
        try{
            for(int i = 0;i<str.length();i++){
                 sb.append(str.charAt(i));
                 System.out.println(sb.toString());
                 for(String s : strs){
                     System.out.println(s.indexOf(sb.toString())+"-----");
                    if(s.indexOf(sb.toString())!= 0){
//                      if(Stris.charAt(i)==sb.toString()){
                        sb.deleteCharAt(sb.length()-1);
                        System.out.println(sb.toString());
                        flag=false;
                        break ;
                      }
                  }
                if(!flag){
                    break;
                }
            }
        }catch(Exception e){
            return sb.toString();
        }
        return sb.toString();
    }
}
