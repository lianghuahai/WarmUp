package problem.day21;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem119 {
    public static void main(String[] args) {
        getRow(5);
    }
    public static List<Integer> getRow(int numRows) {
            List<Integer> list = new ArrayList<Integer>(Arrays.asList(1));
            for(int i=1; i<=numRows;i++){
                int prev=1;
                for(int j =0;j<list.size();j++){
                    if(j==0){
                        list.set(j,list.get(j));
                    }
                    else{
                        int temp=list.get(j);
                        list.set(j,prev+list.get(j));
                        prev=temp;
                    }
                }
                list.add(1);
            }
            return list;
    }
    public List<Integer> getRow2(int rowIndex) {
        List<Integer> list = new ArrayList<Integer>();
        if (rowIndex < 0)
                return list;

        for (int i = 0; i < rowIndex + 1; i++) {
                list.add(0, 1);  //123  becomes  1 123
                for (int j = 1; j < list.size() - 1; j++) {
                        list.set(j, list.get(j) + list.get(j + 1));
                }
        }
        return list;
}
}
