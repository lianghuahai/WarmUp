package sorting;

import java.util.ArrayList;
import java.util.List;

public class BucketSort {
    public static <E> void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
//        list.add(1);
        list.add(21);
        list.add(3);
        list.add(1);
        list.add(5);
        list.add(33);
        list.add(7);
        list.add(2);
        list.add(11);
        list.add(32);
        list.add(27);
        list.add(4);
        list.add(0);
        list.add(100);
        list.add(50);
        
        for (Integer integer : list) {
            System.out.print(integer+" ");
        }
         bucketSort(list);
        System.out.println();
        for (Integer integer : list) {
            System.out.print(integer+" ");
        }
        
    }
    public static void bucketSort(List<Integer> list){
        
    }
}
