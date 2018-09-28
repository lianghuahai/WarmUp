package problem.day25;

import java.util.HashMap;
import java.util.Map;

public class Problem290 {
    public static void main(String[] args) {
        System.out.println(wordPattern("ccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccdd",
                "s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s t t")
        );
    }
    /*
     *  int i = 1000; //greater than 127
        Integer a = i;
        Integer b = i;
        System.out.println(a == b); //this time we got false,if i=[-128,127]will be true
        Because "The JVM is caching Integer values. == only works for numbers between -128 and 127 "
     */
    public static boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");
        if (words.length != pattern.length())
            return false;
        Map index = new HashMap();
        for (Integer i=0; i<words.length; ++i)
            if (index.put(pattern.charAt(i), i) != index.put(words[i], i))
                return false;
        return true;
    }
}
