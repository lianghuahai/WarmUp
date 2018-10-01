package problem.day12;

public class Problem125 {
    public static void main(String[] args) {
//        System.out.println(isPalindrome("race a car"));
//        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(isPalindrome("  "));
    }
    //gay answer
    public boolean isPalindrom2(String s) {
        String actual = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
       String rev = new StringBuffer(actual).reverse().toString();
       char[]ch="adf".toCharArray();
       return actual.equals(rev);
   }
    public static boolean isPalindrome(String s) {
         s = s.trim();
        if(s==null ||s.length()==0)return true;
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++){
            if((s.charAt(i)>='a'&&s.charAt(i)<='z') ||(s.charAt(i)>='A' && s.charAt(i)<='Z'))sb.append(s.charAt(i));
        }
        String str= sb.toString();
        if(str.length()<=1)return false;
        for(int i=0,j=str.length()-1;i<j;i++,j--){
            String a = String.valueOf(str.charAt(i));
            String b = String.valueOf(str.charAt(j));
           if(!a.equalsIgnoreCase(b))return false;
        }
        return true;
    }
}
