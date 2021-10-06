import java.util.*;

/**
 * @ProjectName: LeetCode
 * @Author: XinyuLiu
 * @Description:
 */
public class LeetCode414 {
    //1.遍历求解
    /*long INF = (long)-1e18;
    public int thirdMax(int[] nums) {
        long f = INF, s = INF,t = INF;
        for (int num : nums) {
            if(num > f){
                t = s;
                s = f;
                f = num;
            }else if(num < f && num > s){
                t = s;
                s = num;
            }else if(num < s && num > t){
                t = num;
            }
        }
        return t != INF ? (int)t : (int)f;
    }*/
    //2.Set去重并排序
    public int thirdMax(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int x : nums) set.add(x);
        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        return list.size() < 3 ? list.get(list.size() - 1) : list.get(list.size() - 3);
    }
}
