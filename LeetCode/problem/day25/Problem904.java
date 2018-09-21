package problem.day25;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Problem904 {
    public int totalFruit(int[] tree) {
        if(tree.length<=0)return 0;
        int start = 0;
        int res= 0;
        Map<Integer,Integer> map = new HashMap();//<value,index>
        for(int i=0;i<tree.length;i++){
            map.put(tree[i],i);
            if(map.size()>2){
                int minIndex = Collections.min(map.values());
                map.remove(tree[minIndex]);
                start=minIndex+1;
            }
            res=Math.max(res,i-start+1);
        }
        return res;
    }
}
