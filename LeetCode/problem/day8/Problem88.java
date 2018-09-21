package problem.day8;

public class Problem88 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i=0;
        int j=0;
        int k =0;
        int[] res = new int[n+m];
        
        while(i<m && j<n){
            if(nums1[i]<nums2[j]){
                res[k++]= nums1[i++];
            }else{
                res[k++]= nums1[j++];
            }
        }
        while(i<m ){
            res[k++]= nums1[i++];
        }
        while(j<n){
            res[k++]= nums1[j++];
        }
        for(int x=0;x<res.length;x++){
            nums1[x]=res[x];
        }
        return ;
    }

}
