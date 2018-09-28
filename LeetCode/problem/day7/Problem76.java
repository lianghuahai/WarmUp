package problem.day7;

public class Problem76 {
    public String minWindow(String s, String t) {
        /*
    s=    a d o b e c o d e b a n c ;    t=a b c 
         j=0              i= 0 to len
       position , counter[]
        */
        int position = 0;
        int []mapping= new int[256];
        // initial counter table
        for(int i =0;i<t.length();i++){
            mapping[t.charAt(i)]++;
        }
        int size = t.length();
        int res = Integer.MAX_VALUE;
        //
        for(int i =0,j=0;i<s.length();i++){
            if(mapping[s.charAt(i)]-->0)size--;
            while(size==0){
                if(i-j+1<res){
                    res=i-j+1;
                    position = j;
                }
                if(++mapping[s.charAt(j++)]>0)size++;
           }
         }
        return res == Integer.MAX_VALUE? "" : s.substring(position,position+res);
    }   
}
