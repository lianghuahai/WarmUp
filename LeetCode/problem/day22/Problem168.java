package problem.day22;

public class Problem168 {

    public static void main(String[] args) {
        System.out.println(convertToTitle(28));

    }
    public static String convertToTitle(int n) {
        String res = "";
        while(n != 0) {
            char ch = (char)((n - 1) % 26 + 65);
            n = (n - 1) / 26;
            res = ch + res;
        }
       return res;
    }
}
