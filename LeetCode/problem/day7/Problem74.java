package problem.day7;

public class Problem74 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[][] matrix = new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,50}};
        System.out.println(searchMatrix(matrix.clone(),11));
    }
  //binary  search for row
    // then BS  for col
    public static boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null || matrix.length ==0||matrix[0].length==0){
            return false;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int low = 0; 
        int high = matrix.length-1;
        int row =0;
        while(low<=high){
            int mid = (high - low)/2 +low;
            if(matrix[low][0] ==target)return true;
            else if(matrix[mid][0] <=target && matrix[mid][cols-1] >=target){
                row=mid;
                break;
            }else if(matrix[mid][0] >target){
                high = mid-1;
            }else {
                low = mid+1;
            }
        }
        
        if(low <=high){
            int left = 0;
            int right = cols-1;
             while(left<=right){
                 int mid = (right - left)/2 +left;
                 if(matrix[row][mid]==target){
                     return true;
                 }
                 else if(matrix[row][mid] <target){
                     left = mid+1;
                }else {
                     right = mid-1;
                }
             }
        }
        return false;
    }
    public static boolean searchMatrix1(int[][] matrix, int target) {
        if(matrix==null || matrix.length ==0||matrix[0].length==0){
            return false;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int low = 0; 
        int high = matrix.length-1;
        while(low<=high){
            int mid = (high - low)/2 +low;
            if(matrix[low][0] ==target)return true;
            else if(matrix[low][0] <=target && matrix[low][cols-1] >=target){
                break;
            }else if(matrix[low][0] >target){
                high = low;
            }else {
                low = high;
            }
        }
        if(low <=high){
            for(int i =0;i<cols;i++){
                if(matrix[low][i]==target){
                    return true;
                }
            }
        }
        return false;
    }
}
