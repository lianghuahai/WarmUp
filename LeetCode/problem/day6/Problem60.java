package problem.day6;

import java.util.ArrayList;
import java.util.List;

public class Problem60 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }
    /*
     * say n = 4, you have {1, 2, 3, 4}
        If you were to list out all the permutations you have
                       1 + (permutations of 2, 3, 4)   6个组合
   =>key point         2 + (permutations of 1, 3, 4)   6        所以如果要拿k=17就是  17/6 = 3  结果就在3+ permutation里面 然后继续缩小范围
                       3 + (permutations of 1, 2, 4)   6         k = k% lookup[i-1];  or k-= (index)2*6
                       4 + (permutations of 1, 2, 3)   6
        We know how to calculate the number of permutations of n numbers... n! 
        So each of those with permutations of 3 numbers means there are 6 possible permutations. 
        Meaning there would be a total of 24 permutations in this particular one. 
        So if you were to look for the (k = 14) 14th permutation, it would be in the
        3 + (permutations of 1, 2, 4) subset.
        
        To programmatically get that, you take k = 13 (subtract 1 because of things always starting at 0) 
        and divide that by the 6 we got from the factorial, which would give you the index of the number you want. 
        In the array {1, 2, 3, 4}, k/(n-1)! = 13/(4-1)! = 13/3! = 13/6 = 2. 
        The array {1, 2, 3, 4} has a value of 3 at index 2.So the first number is a 3.
        Then the problem repeats with less numbers.
        The permutations of {1, 2, 4} would be:
            1 + (permutations of 2, 4)
            2 + (permutations of 1, 4)
            4 + (permutations of 1, 2)
        But our k is no longer the 14th, because in the previous step, we've already eliminated the 12 4-number permutations starting with 1 and 2. So you subtract 12 from k.. which gives you 1. Programmatically that would be...
        k = k - (index from previous) * (n-1)! = k - 2*(n-1)! = 13 - 2*(3)! = 1
     */
    public static String getPermutation(int n, int k) {
        List<Integer> numbers = new ArrayList<Integer>();
        //创建一个 1 到  n的链表
        for(int i=1;i<=n;i++){
            numbers.add(i);
        }
        //创建一个 n！的数组
        int[]lookup = new int[n];
        lookup[0]=1;
        for(int i=1;i<n;i++){
            lookup[i]=i*lookup[i-1];// table for n!
        }
        k=k-1;
        StringBuilder sb = new StringBuilder();
        for(int i =n;i>0;i--){
            int index = k /lookup[i-1];  //得到链表中的index
            sb.append(numbers.get(index));// 添加value到结果中
            numbers.remove(index);      //把该value从链表中删除  
            k=k%lookup[i-1];// or  k-= index*lookup[i-1];   缩小k的范围
        }
        return sb.toString();
    }
}
