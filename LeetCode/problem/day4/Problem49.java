package problem.day4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem49 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String [] strs = new String[]{"eat","tea","tan","ate","nat","bat"};
        List<List<String>> groupAnagrams = groupAnagrams(strs);
        System.out.println(groupAnagrams.size());
        

    }
    /*
     * 重点就是 loop str array一遍，把每个 string转成 char【】然后sort（）一遍，当成key放到map里面
     * 如果key存在就 map.get().add()放到 value集合里面，如果不存在 就put进去
     * 
     * 
     * 
     */
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> list = new ArrayList<List<String>>();
        if(strs==null||strs.length==0){
            return list;
        }
        Map<String,List<String>> dic = new HashMap<String,List<String>>();
        for(int i=0;i<strs.length;i++){
            char[] str = strs[i].toCharArray();
            Arrays.sort(str);
            String newStr = String.valueOf(str);
            if(dic.containsKey(newStr)){
                dic.get(newStr).add(strs[i]);
            }else{
                dic.put(newStr,new ArrayList());
                dic.get(newStr).add(strs[i]);
            }
        }
        for(String key : dic.keySet()){
            list.add(dic.get(key));
        }
        return list;
    }
}
