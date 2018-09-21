package problem.day25;

public class Problem896 {
    public boolean isMonotonic(int[] A) {
        boolean incres=true,decre=true;
        for(int i=0;i<A.length-1;i++){
            if(A[i]>A[i+1])incres=false;
        }
        for(int i=0;i<A.length-1;i++){
            if(A[i]<A[i+1])decre=false;
        }
        return incres||decre;
    }
}
