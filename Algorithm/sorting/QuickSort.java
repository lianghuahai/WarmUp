package sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuickSort {
    public static <E> void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
//        list.add(1);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(5);
//        list.add(33);
//        list.add(7);
//        list.add(2);
//        list.add(11);
//        list.add(32);
//        list.add(27);
//        list.add(4);
        for (Integer integer : list) {
            System.out.print(integer+" ");
        }
        quickSort(list,0,list.size()-1);
        System.out.println();
        for (Integer integer : list) {
            System.out.print(integer+" ");
        }
        
        // quickSort 1
//        int[] a = {1, 2, 4, 5, 7, 4, 5 ,3 ,9 ,0};  
//        System.out.println(Arrays.toString(a));  
//        quickSort1(a);  
//        System.out.println(Arrays.toString(a));  
    }
    public static void quickSort1(int[] a) {  
        if(a.length>0) {  
            quickSort1(a, 0 , a.length-1);  
        }  
    }  
    private static void quickSort1(int[] a, int low, int high) {  
        //1,找到递归算法的出口  
        if( low > high) {  
            return;  
        }  
        //2, 存  
        int i = low;  
        int j = high;  
        //3,key  
        int key = a[ low ];  
        //4，完成一趟排序  
        while( i< j) {  
            //4.1 ，从右往左找到第一个小于key的数  
            while(i<j && a[j] > key){  
                j--;  
            }  
            // 4.2 从左往右找到第一个大于key的数  
            while( i<j && a[i] <= key) {  
                i++;  
            }  
            //4.3 交换  
            if(i<j) {  
                int p = a[i];  
                a[i] = a[j];  
                a[j] = p;  
            }  
        }  
        // 4.4，调整key的位置  
        int p = a[i];  
        a[i] = a[low];  
        a[low] = p;  
        //5, 对key左边的数快排  
        quickSort1(a, low, i-1 );  
        //6, 对key右边的数快排  
        quickSort1(a, i+1, high);  
    } 
    public static void quickSort(List<Integer> list, int left, int right){
        if(left>right){
            return ;
        }
        int index = partition(list,left,right);//pivot position
        quickSort(list,left,index - 1);
        quickSort(list,index + 1,right);
    }
    public static int partition(List<Integer> list,int left, int right){
        int pivot = list.get(right);
        int pivotIndex= right;
//        right = right -1;
        while(left<right){
            while(left<right && list.get(left)<=pivot){
                left=left+1;
            }
            while(left<right && list.get(right)>=pivot){
                right=right-1;
            }
            int temp= list.get(left);
            list.set(left, list.get(right));
            list.set(right, temp);
        }
        int temp= list.get(left);
        list.set(left, list.get(pivotIndex));
        list.set(pivotIndex, temp);
        return left;
    }
}
