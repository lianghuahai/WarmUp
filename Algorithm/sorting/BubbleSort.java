package sorting;

import java.util.ArrayList;
import java.util.List;

//O(n^2) each loop we move the max value to right-most
public class BubbleSort {
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
        for (Integer integer : list) {
            System.out.print(integer+" ");
        }
        bubble(list);
        System.out.println();
        for (Integer integer : list) {
            System.out.print(integer+" ");
        }
        
    }
    public static void bubble(List<Integer> list){
        for (int i = 0; i < list.size()-1; i++) {
            for (int j = 1; j <= list.size()-i-1; j++) {
                if(list.get(j)<list.get(j-1)){
                    int temp = list.get(j);
                    list.set(j, list.get(j-1));
                    list.set(j-1, temp);
                }
            }
        }
    }
}
