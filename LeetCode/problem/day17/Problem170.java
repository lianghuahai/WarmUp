package problem.day17;

public class Problem170 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }
    public int titleToNumber(String s) {
        int res= 0;
        for(int i=0;i<s.length();i++){
            res=res*26+(s.charAt(i)-65+1);
        }
        return res;        
    }
}
