package problem.day9;

import java.util.ArrayList;
import java.util.List;

public class Problem93 {
    public static void main(String[] args) {
        List<String> restoreIpAddresses = restoreIpAddresses("25525511135");
        for (String string : restoreIpAddresses) {
            System.out.print(string +" ");
        }
    }
    public static List<String> restoreIpAddresses(String s) {
        List<String> solutions = new ArrayList<String>();
        restoreIp(s, solutions, 0, "", 0);
        return solutions;
}

    private static void restoreIp(String ip, List<String> solutions, int idx, String restored, int count) {
        if (count > 4) return;
        if (count == 4 && idx == ip.length()) solutions.add(restored);

        for (int i=1; i<4; i++) {
            if (idx+i > ip.length()) break;
            String s = ip.substring(idx,idx+i);
            if ((s.startsWith("0") && s.length()>1) || (i==3 && Integer.parseInt(s) >= 256)) continue;
            restoreIp(ip, solutions, idx+i, restored+s+(count==3?"" : "."), count+1);
        }
    }
    
}
