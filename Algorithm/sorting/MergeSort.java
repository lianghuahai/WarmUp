package sorting;

import java.util.ArrayList;
import java.util.List;

public class MergeSort {
    public static <E> void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
//        list.add(1);
        list.add(22);
        list.add(3);
        list.add(1);
        list.add(5);
        list.add(33);
        list.add(7);
        list.add(2);
        list.add(11);
        list.add(32);
        list.add(27);
//        list.add(4);
        for (Integer integer : list) {
            System.out.print(integer+" ");
        }
        mergeSort(list,0,list.size()-1);
        System.out.println();
        for (Integer integer : list) {
            System.out.print(integer+" ");
        }
    }
    public static void mergeSort(List<Integer> list,int first, int last){
        if(first>=last){
            return;
        }
        int mid = (first+last)/2;
        mergeSort(list,first,mid);
        mergeSort(list,mid+1,last);
        merge(list,first,mid,last);
        
    }
    public static void merge(List<Integer> list,int first,int mid,int last){
        if(first ==last){return;}
        List<Integer> copyList = new ArrayList<Integer>();
        int left = first;
        int rightFirst = mid +1;
        while(first<=mid && rightFirst<=last){
            if(list.get(first)<=list.get(rightFirst)){
                copyList.add(list.get(first));
                first++;
            }else{
                copyList.add(list.get(rightFirst));
                rightFirst++;
            }
        }
        //if copy all of the  right list, the left list will be needed to store again.
        while(first<=mid ){
            copyList.add(list.get(first));
            first++;
        }
        //if copy all of the left list, the right list will be needed to store again.
        while(rightFirst<=last){
            copyList.add(list.get(rightFirst));
            rightFirst++;
        }
        //copy sorted list  to original list
//        System.out.println("#");
//        for (int i = left; i <= last; i++) {
//            list.set(i, copyList.get(i));
////            System.out.print(copyList.get(i)+" ");
//        }
        
        for (Integer integer : copyList) {
            list.set(left, integer);
            left++;
//            System.out.println(integer);
        }
    }
}
