package problem.day17;

public class Problem28 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }
    //using kmp
   // knuth-morris-piatt algorithm: to find whether a string is occurrence is another string
    /*
     * idea is first to build the table of pattern
     * eg:  string : aaaaab   pattern : aaab
     * now build the  table of aaab  
     * 0         1 2 3 4     index        
     * j         a a a b
     * value     0 1 2 0     value
     * and now , for(int i =0;i<string.length;i++)
     *  so basicly,  we check s[i]== table[j+1]
     *       true->       i++.j++
     *       false->     i doesn't change, j=t[j]
     *  until j == t.length we found answer
     * The reason why it works is because for the pattern string "aaaab" everytime we move i -> i+1
     * we repeated compare aaa which is redundant/unnecessary.  This is why we just move j = t[j], not j=0
     */
    public String strStr1(String haystack, String needle) {
        //KMP algorithms   O(m+n)
        if(needle.equals("")) return haystack;
        if(haystack.equals("")) return null;
        char[] arr = needle.toCharArray();
        int[] next = makeNext(arr);

        for(int i = 0, j = 0, end = haystack.length(); i < end;){
                if(j == -1 || haystack.charAt(i) == arr[j]){
                        j++;
                        i++;
                        if(j == arr.length) return haystack.substring(i - arr.length);
                }
                if(i < end && haystack.charAt(i) != arr[j]) j = next[j];
        }
        return null;
    }
    
    private int[] makeNext(char[] arr){
            int len = arr.length;
            int[] next = new int[len];
    
            next[0] = -1;
            for(int i = 0, j = -1; i + 1 < len;){
                    if(j == -1 || arr[i] == arr[j]){
                            next[i+1] = j+1;
                            if(arr[i+1] == arr[j+1]) next[i+1] = next[j+1];
                            i++;
                            j++;
                    }
                    if(arr[i] != arr[j]) j = next[j];
            }
    
            return next;
    }
    
    
    //O(m*n)
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
