package problem.day6;

public class Problem75 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }
    public static void sortColors(int[] nums) {
        // counting sort
        int[] dic = new int[]{0,0,0};
        for(int i=0;i<nums.length;i++){
            dic[nums[i]]++;
        }
        int index =0;
        for(int i =0;i<dic.length;i++){
            while((dic[i]--)>0){
                nums[index++] = i;
            }
        }
        
        /*   sort in-place  O(2n)
         * 
            int second=n-1, zero=0;
            for (int i=0; i<=second; i++) {
                while (A[i]==2 && i<second) swap(A[i], A[second--]);
                while (A[i]==0 && i>zero) swap(A[i], A[zero++]);
            }
         */
    }
}
