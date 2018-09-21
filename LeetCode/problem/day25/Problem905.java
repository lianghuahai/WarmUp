package problem.day25;

public class Problem905 {

    public static void main(String[] args) {
        sortArrayByParity(new int[]{0,2,3,4});

    }
    public static int[] sortArrayByParity(int[] A) {
        if(A.length<=1)return A;
        int odd = A.length-1,even =0;
        while(even<odd){
            if(A[even]%2==0){
                even++;
            }else{
                int temp=A[odd];
                A[odd]=A[even];
                A[even]=temp;
                odd--;
            }
        }
        return A;
    }
}
