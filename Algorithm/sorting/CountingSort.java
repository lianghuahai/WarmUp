package sorting;

import java.util.ArrayList;
import java.util.List;

public class CountingSort {
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
        List<Integer> countSort = countSort(list,100);
        System.out.println();
        for (Integer integer : countSort) {
            System.out.print(integer+" ");
        }
        
    }
    public static List<Integer> countSort(List<Integer> list, int maxValue){
        List<Integer> copy = new ArrayList<Integer>();
        for (int i = 0; i <= 100; i++) {
            copy.add(0);
        }
        List<Integer> newList = new ArrayList<Integer>();
        
        for (Integer integer : list) {
            copy.set(integer, copy.get(integer)+1);
        }
        for (int i = 0; i < copy.size(); i++) {
            for (int j = 0; j < copy.get(i); j++) {
                newList.add(i);
            }
        }
        return newList;
    }
}
