import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class LeetCode207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];//入度
        List<List<Integer>> adjacency = new ArrayList<>();//存放邻接节点
        for (int i = 0; i < numCourses; i++) {
            adjacency.add(new ArrayList<>());//初始化节点
        }
        for (int[] pre : prerequisites) {
            indegree[pre[0]]++;
            adjacency.get(pre[1]).add(pre[0]);
        }
        Queue<Integer> queue = new ArrayDeque<>();
        //将入度为0的点放入队列
        for (int i = 0; i < indegree.length; i++) {
            if(indegree[i] == 0){
                queue.add(i);
            }
        }
        while(!queue.isEmpty()){
            Integer node = queue.poll();
            numCourses--;
            for(Integer ad : adjacency.get(node)){
                indegree[ad]--;
                if(indegree[ad] == 0){
                    queue.add(ad);
                }
            }
        }
        return numCourses == 0;
    }
}
