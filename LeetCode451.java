import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @ProjectName: LeetCode
 * @Author: XinyuLiu
 * @Description:
 */
public class LeetCode451 {
    class Node {
        char c;
        int v;
        Node(char _c,int _v){
            c = _c;v = _v;
        }
    }
    public String frequencySort(String s) {
        //1.数据处理
        Map<Character,Integer> map = new HashMap<>();
        for (char t : s.toCharArray()) {
            map.put(t,map.getOrDefault(t,0) + 1);
        }
        PriorityQueue<Node> q = new PriorityQueue<>((a,b) ->{
            if(b.v != a.v) return b.v - a.v;
            return a.c - b.c;
        });
        for (char c : map.keySet()) {
            q.add(new Node(c,map.get(c)));
        }
        StringBuffer sb = new StringBuffer();
        while(!q.isEmpty()){
            Node poll = q.poll();
            int k = poll.v;
            while(k-- > 0) sb.append(poll.c);
        }
        return sb.toString();
    }
}
