package searching;

import java.util.ArrayList;
import java.util.List;



public class BinarySearch {
    public static <E> void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
//        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(11);
        list.add(22);
        list.add(44);
        for (Integer integer : list) {
            System.out.print(integer+" ");
        }
        boolean found = bs(list,0,list.size(),1);
        System.out.println();
        System.out.println(found);
        
    }
    
    public static boolean bs(List<Integer> list, int first, int last,int target ){
        int mid = (first +last )/2;
        if(mid>=list.size()){
            return false;
        }
        System.out.println(list.get(mid)+","+first+","+last);
        if(first>last){
            return false;
        }
        else if(list.get(mid)==target){
            return true;
        }else{
            if(list.get(mid)>target){
                return bs(list,  first,  mid-1,target);
            }else{
                return bs(list, mid+1,  last,target);
            }
        }
    }
}
