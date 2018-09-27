package problem.day11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem118 {
    public List<List<Integer>> getRow(int numRows) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(numRows==0)return res;
        res.add(new ArrayList<Integer>(Arrays.asList(1)));
        if(numRows==1)return res;
        res.add(new ArrayList(Arrays.asList(1,1)));
        for(int i=2; i<numRows;i++){
            List<Integer> list = res.get(res.size()-1);
            List<Integer> temp2 = new ArrayList();
            for(int j =0;j<list.size();j++){
                if(j==0){
                    temp2.add(list.get(j));
                }
                else{
                    temp2.add(list.get(j)+list.get(j-1));
                }
                if(j==list.size()-1)temp2.add(list.get(j));
                
            }
            res.add(new ArrayList(temp2));
        }
        return res;
    }
}
