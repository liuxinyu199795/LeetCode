import com.sun.corba.se.spi.presentation.rmi.IDLNameTranslator;

import java.util.*;

/**
 * @ProjectName: LeetCode
 * @Author: XinyuLiu
 * @Description:
 */
public class LCP007 {
    //1.BFS(一层层去添加，到最后一层，然后遍历看有多少个终点）
   /* public int numWays(int n, int[][] relation, int k) {
        Map<Integer, Set<Integer>> relationMap = new HashMap<>();
        for (int i = 0; i < relation.length ; i++) {
            Set<Integer> set = relationMap.getOrDefault(relation[i][0],new HashSet<>());
            set.add(relation[i][1]);
            relationMap.put(relation[i][0],set);
        }
        int res = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        deque.addLast(0);
        while(!deque.isEmpty() && k-- > 0){
           int size = deque.size();
           while(size-- > 0) {
               int poll = deque.pollFirst();
               Set<Integer> pollSet = relationMap.get(poll);
               if (pollSet == null) continue;
               for (int num : pollSet) {
                   deque.addLast(num);
               }
           }
        }
        int ans = 0;
        while(!deque.isEmpty()){
            if(deque.pollFirst() == n - 1) ans++;
        }
        return ans;
    }*/
    //2.DFS
    int a,b,ans;
    Map<Integer, Set<Integer>> relationMap = new HashMap<>();
    public int numWays(int n, int[][] relation, int k) {
        int a = n,b = k;
        relationMap = new HashMap<>();
        for (int i = 0; i < relation.length; i++) {
            Set<Integer> set = relationMap.getOrDefault(relation[i][0], new HashSet<>());
            set.add(relation[i][1]);
            relationMap.put(relation[i][0], set);
        }
        dfs(0,0);
        return ans;
    }
    void dfs(int i,int sum){
        if(sum == b){
            if(i == a - 1) ans++;
            return;
        }
        Set<Integer> es = relationMap.get(i);
        if(es == null) return;
        for (int num : es) {
            dfs(num,sum + 1);
        }
    }
}
