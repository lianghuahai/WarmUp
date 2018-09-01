package problem.day22;

import java.util.Arrays;
import java.util.Comparator;
//private class LargerNumberComparator implements Comparator<String> {
//     @Override
//     public int compare(String a, String b) {
//         String order1 = a + b;
//         String order2 = b + a;
//        return order2.compareTo(order1);
//     }
// }
public class Problem79 {

    public static void main(String[] args) {
        largestNumber(new int[]{3,30,34,5,9});

    }
/*    12. string1.compareTo(string2): 首先取出两个字符串的长度，比较较小的长度内，两者是否相等。
    若不相等，则直接返回该位置字符的ASCII码相减后的值。
    若各位置都相等，则将两个字符串长度的差值返回。
    
*/

    public static String largestNumber(int[] nums) {
        // Get input integers as strings.
        String[] asStrs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            asStrs[i] = String.valueOf(nums[i]);
        }

        // Sort strings according to custom comparator.
//        Arrays.sort(asStrs, new LargerNumberComparator());
        Arrays.sort(asStrs, (a,b)->{   //jdk 1.8 lamda expression , no need to create a class!!!!!!!!!!!!
            String str1=a+b;
            String str2=b+a;
           return str2.compareTo(str1);
        } );                                          //    [  Key! ]
        //排序完之后     [3, 30, 34, 5, 9]  =>  [9, 5, 34, 3, 30]!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        // If, after being sorted, the largest number is `0`, the entire number is zero.
        if (asStrs[0].equals("0")) {
            return "0";
        }
        // Build largest number from sorted array.
        String largestNumberStr = new String();
        for (String numAsStr : asStrs) {
            largestNumberStr += numAsStr;
        }

        return largestNumberStr;
    }
}
