package sorting;

import java.util.ArrayList;
import java.util.List;

//O(n^2)
public class SelectionSort {
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
        selection(list);
        System.out.println();
        for (Integer integer : list) {
            System.out.print(integer+" ");
        }
        
    }
    public static void selection(List<Integer> list){
        for (int i = 0; i < list.size()-1; i++) {
            for (int j = i+1; j <= list.size()-1; j++) {
                if(list.get(i)>list.get(j)){
                    int temp = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, temp);
                }
            }
        }
    }
    
    
    
    
    
    
}
