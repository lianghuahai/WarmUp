package problem.day22;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Problem347 {

    public static void main(String[] args) {
        int[] a = new int[100];
        for (int i : a) {
            
        }
        Map<Integer,Integer> map = new HashMap();
        for (int i : map.keySet()) {
            
        }
        PriorityQueue<Integer>  que = new PriorityQueue<Integer>((c1,c2)-> c2-c1);
        que.add(1);
        que.add(11);
        que.add(111);
        System.out.println(que.peek());
        List<Integer> list = new ArrayList();
        list.forEach((n)->{
            
        });
    }
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> res = new ArrayList();
        if(nums.length==0|| nums==null)return res;
        List<Integer>[] bk = new ArrayList[nums.length+1];
        Map<Integer,Integer> map = new HashMap();
        for(int n :nums){
            map.put(n,map.getOrDefault(n,0)+1);    
        }
        for(int key : map.keySet()){
            if(bk[map.get(key)]==null){
                bk[map.get(key)]=new ArrayList();
            }
            bk[map.get(key)].add(key);
        }
        int idx=k;
        for(int i=bk.length-1;i>=0;i--){
            if(k==0)break;
            if(bk[i]!=null){
                for(int j:bk[i]){
                    if(k==0)break;
                    res.add(j);
                    k--;
                }
            }
        }
        return res;
    }

}
