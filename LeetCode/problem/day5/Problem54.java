package problem.day5;

import java.util.LinkedList;
import java.util.List;

public class Problem54 {

    public static void main(String[] args) {
//        int[][] matrix  = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}};//3*4   差一个
        int[][] matrix  = new int[][]{{1,2},{5,6},{9,12}};//3*2   正常
//        int[][] matrix  = new int[][]{{1,2,3},{5,6,7},{9,10,11}};//3*3   正常
//        int[][] matrix  = new int[][]{{1,2,3,4},{5,6,7,8}};   //2*4    正常
//        int[][] matrix  = new int[][]{{1,2,3},{5,6,7}};   //2*3    正常
//        int[][] matrix  = new int[][]{{1,2},{5,7}};   //2*2    正常
        List<Integer> spiralOrder = spiralOrder(matrix);
        for (Integer integer : spiralOrder) {
            System.out.print(integer+" ");
        }

    }
    //better
    /*
     *                  colBegin    colEnd
     *          rowBegin     1   2   3
     *                       4   5   6
     *          rowEnd       7   8   9
     *                
     */              
    public static List<Integer> spiralOrder1(int[][] matrix) {
        List<Integer> res = new LinkedList<Integer> ();
        int rowBegin=0;
        int colBegin=0;
        int rowEnd=matrix.length-1;
        int colEnd=matrix[0].length-1;
        
        if(matrix.length==0){
            return res;
        }
        while(rowBegin<=rowEnd && colBegin<=colEnd){
            for (int i = colBegin; i <= colEnd; i++) {
                res.add(matrix[rowBegin][i]);
            }
            rowBegin++;
            for (int i = rowBegin; i <= rowEnd; i++) {
                res.add(matrix[i][colEnd]);
            }
            colEnd--;
            
            if(rowBegin<=rowEnd){
                for (int i = colEnd; i >=colBegin; i--) {
                    res.add(matrix[rowEnd][i]);
                }
            }
            rowEnd--;
            if(colBegin<=colEnd){
                for (int i = rowEnd; i >=rowBegin; i--) {
                    res.add(matrix[i][colBegin]);
                }
            }
            colBegin++;
        }
        
        return res;
    }
    
    
    
    
    
    
    
    
    
    //not good
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new LinkedList<Integer> ();
        if(matrix.length==0){
            return list;
        }
        int left = 0, up =0,  down= matrix.length, right= matrix[0].length;
        
        while(left<right && up<down){
            if(list.size()==(matrix.length*matrix[0].length)){
                break;
            }
            for(int i = left;i<right;i++){
                list.add(matrix[up][i]);
            }
            up++;
            for(int i = up;i<down;i++){
                list.add(matrix[i][right-1]);
            }
            if(list.size()==(matrix.length*matrix[0].length)){
                break;
            }
            right--;
            for(int i = right-1;i>=left;i--){
                list.add(matrix[down-1][i]);
            }
            down--;
            for(int i = down-1;i>=up;i--){
                list.add(matrix[i][left]);
            }
            left++;
        }
        return list;
    }
}
