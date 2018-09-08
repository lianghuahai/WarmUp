package problem.day23;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Problem207 {
/*    BFS uses the indegrees of each node. We will first try to find a node with 0 indegree. If we fail to do so,
    there must be a cycle in the graph and we return false. Otherwise we have found one. 
            We set its indegree to be -1 to prevent from visiting it again and reduce the indegrees of all its neighbors by 1.
            This process will be repeated for n (number of nodes) times. If we have not returned false, we will return true.*/
    
    
    //BFS,  把所有indegree=0都加入stack，然后遍历stack，把所有他对应的outdegree课程 --，然后再check它的outdegree那个课程indegree是否为0
    //如果为0，继续加入stack， 一直循环直到结束，总课程数如果不等于回环数（count）证明有cycle
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[][] matrix = new int[numCourses][numCourses]; // i -> j
        int[] indegree = new int[numCourses];
        
        for (int i=0; i<prerequisites.length; i++) {
            int ready = prerequisites[i][0];
            int pre = prerequisites[i][1];
            if (matrix[pre][ready] == 0)
                indegree[ready]++; //duplicate case
            matrix[pre][ready] = 1;
        }
        
        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i=0; i<indegree.length; i++) {
            if (indegree[i] == 0) queue.offer(i);
        }
        while (!queue.isEmpty()) {
            int course = queue.poll();
            count++;
            for (int i=0; i<numCourses; i++) {
                if (matrix[course][i] != 0) {
                    if (--indegree[i] == 0)
                        queue.offer(i);
                }
            }
        }
        return count == numCourses;
    }
    
    //DFS
    public class Solution {
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            ArrayList[] graph = new ArrayList[numCourses];
            for(int i=0;i<numCourses;i++)
                graph[i] = new ArrayList();
                
            boolean[] visited = new boolean[numCourses];
            for(int i=0; i<prerequisites.length;i++){
                graph[prerequisites[i][1]].add(prerequisites[i][0]);
            }

            for(int i=0; i<numCourses; i++){
                if(!dfs(graph,visited,i))
                    return false;
            }
            return true;
        }

        private boolean dfs(ArrayList[] graph, boolean[] visited, int course){
            if(visited[course])
                return false;
            else
                visited[course] = true;

            for(int i=0; i<graph[course].size();i++){
                if(!dfs(graph,visited,(int)graph[course].get(i)))
                    return false;
            }
            visited[course] = false;
            return true;
        }
    }
}
