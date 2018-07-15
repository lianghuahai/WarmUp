package problem.day16;

public class Problem59 {

    public static void main(String[] args) {
//        int[][] generateMatrix = generateMatrix(3);
//        for (int[] is : generateMatrix) {
//            for (int i : is) {
//                System.out.print(i+" ");
//            }
//            System.out.println();
//        }
        StringBuffer sb=  new StringBuffer();
        StringBuffer reverse = sb.reverse();
        String a ="123";
        System.out.println(Integer.parseInt(a));
        

    }
    public static int[][] generateMatrix(int n) {
        int [][]matrix = new int [n][n];
        if(n==0){
            return matrix;
        }
        int left = 0, up =0,  down= matrix.length, right= matrix[0].length;
        int value = 1;
        while(left<right && up<down){
            if(value-1==(matrix.length*matrix[0].length)){
                break;
            }
            for(int i = left;i<right;i++){
                matrix[up][i]=value++;
            }
            if(value-1==(matrix.length*matrix[0].length)){
                break;
            }
            up++;
            for(int i = up;i<down;i++){
                matrix[i][right-1]=value++;
            }
            if(value-1==(matrix.length*matrix[0].length)){
                break;
            }
            right--;
            for(int i = right-1;i>=left;i--){
                matrix[down-1][i]=value++;
            }
            if(value-1==(matrix.length*matrix[0].length)){
                break;
            }
            down--;
            for(int i = down-1;i>=up;i--){
                matrix[i][left]=value++;
            }
            left++;
        }
        return matrix;
    }
}
