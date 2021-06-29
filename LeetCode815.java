import java.util.*;

/**
 * @ProjectName: LeetCode
 * @Author: XinyuLiu
 * @Description:
 */
public class LeetCode815 {
    int s,t;
    int[][] rs;
    public int numBusesToDestination(int[][] routes, int source, int target) {
        rs = routes;s = source;t = target;
        if(s == t) return 0;
        int res = bfs();
        return res;
    }
    int bfs(){
        //某个车站可以进入的路线
        Map<Integer, Set<Integer>> map = new HashMap<>();
        //队列存的是经过的实际路线
        Deque<Integer> d = new ArrayDeque<>();
        //哈希表记录的是进入改路线的的距离
        Map<Integer,Integer> m  = new HashMap<>();
        int n = rs.length;
        for (int i = 0; i < n; i++) {
            for (int station : rs[i]) {
                if(station == s){
                    d.addLast(i);
                    m.put(i,1);
                }
                Set<Integer> set = map.getOrDefault(station,new HashSet<>());
                set.add(i);
                map.put(station,set);
            }
        }
        while(!d.isEmpty()){
            int poll = d.pollFirst();
            int step = m.get(poll);
            //遍历车站所含的路线
            for (int station : rs[poll]) {
                //包含终点
                if(station == t) return step;
                Set<Integer> lines = map.get(station);
                if(lines == null) continue;//没有路线就不走
                for (int nr : lines) {
                    //如果走过了就不再走
                    if(!m.containsKey(nr)){
                        d.addLast(nr);
                        m.put(nr,step + 1);
                    }
                }
            }
        }
        return -1;
    }
}
