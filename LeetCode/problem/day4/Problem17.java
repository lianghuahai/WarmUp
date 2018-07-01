package problem.day4;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Problem17 {
    private static final String[] KEYS = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
    public static void main(String[] args) {
        List<String> letterCombinations = letterCombinations2("234");
        System.out.println(letterCombinations);

    }
    public static List<String> letterCombinations(String digits) {
        Map<Character,String> map= new LinkedHashMap<Character,String>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqs");
        map.put('8',"tuv");
        map.put('9',"wyz");
        map.put('1',"");
        List<String> list= new ArrayList<String>();
        List<String> res = new ArrayList<String>();
        
        for(int i =0;i<digits.length();i++){
            if(digits.charAt(i)=='1'){continue;}
            String str = map.get(digits.charAt(i));
            list.add(str);
        }
        
        for (int i = 0; i < list.size()-1; i++) {
            for (int j = i+1; j < list.size(); j++) {
            }
        }
        
        return res;
    }

    
    public static List<String> letterCombinations2(String digits) {
        String[] ans = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        List<String> result = new ArrayList<String>();
        if(digits == "" || digits.length() == 0)
                return result;
        result.add("");
        int[] num = new int[digits.length()];
        for(int i = 0;i<digits.length();i++)
        {
                num[i] = digits.charAt(i)-'0';
        }
        for(int k = 0;k<digits.length();k++)
        {
                if(num[k]<2)
                        continue;
                List<String> midans = new ArrayList<String>();
                String s1 = ans[num[k]];
                for(int i = 0;i<result.size();i++)
                {
                        for(int j = 0;j<s1.length();j++)
                        {
                                midans.add(result.get(i)+s1.charAt(j));
                        }
                }
                result = midans;
        }
        return result;
    }

    
    public static List<String> letterCombinations3(String digits) {
        LinkedList<String> ans = new LinkedList<String>();
        if(digits.isEmpty()) return ans;
        String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ans.add("");
        for(int i =0; i<digits.length();i++){
                int x = Character.getNumericValue(digits.charAt(i));
                while(ans.peek().length()==i){
                        String t = ans.remove();
                        for(char s : mapping[x].toCharArray())
                                ans.add(t+s);
                }
        }
        return ans;
}
        //recursive
    public List<String> letterCombinations4(String digits) {
        List<String> ret = new LinkedList<String>();
        combination("", digits, 0, ret);
        return ret;
    }

    private void combination(String prefix, String digits, int offset, List<String> ret) {
            if (offset >= digits.length()) {
                    ret.add(prefix);
                    return;
            }
            String letters = KEYS[(digits.charAt(offset) - '0')];
            for (int i = 0; i < letters.length(); i++) {
                    combination(prefix + letters.charAt(i), digits, offset + 1, ret);
            }
    }
}
