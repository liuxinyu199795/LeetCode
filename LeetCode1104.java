import java.util.*;

/**
 * @ProjectName: LeetCode
 * @Author: XinyuLiu
 * @Description:
 */
public class LeetCode1104 {
    //1.队列法
    public static List<Integer> pathInZigZagTree(int label) {
        List<Integer> res = new ArrayList<>();
        res.add(1);
        if(label == 1){
            return res;
        }
        Deque<Integer> deque = new ArrayDeque<>();
        boolean flag = true;
        int i = 1;
        Map<Integer,Integer> map = new HashMap<>();
        deque.addLast(i);
        int layor = 1;
        while(!deque.isEmpty() && i <= label){
            int a = ++i,b = ++i;
            Integer num;
            if(flag){
                num = deque.pollFirst();
                deque.addLast(a);
                deque.addLast(b);
            }else{
                num = deque.pollLast();
                deque.addFirst(a);
                deque.addFirst(b);
            }
            map.put(b,num);
            map.put(a,num);
            if(deque.size() == 2 * layor){
                flag = !flag;
                layor *= 2;
            }
        }
        List<Integer> list = new ArrayList<>();
        list.add(label);
        int num = map.get(label);
        while(num != 1){
            list.add(num);
            num = map.get(num);
        }
        for (int j = list.size() - 1; j >= 0; j--) {
            res.add(list.get(j));
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(pathInZigZagTree(14));
    }
}
