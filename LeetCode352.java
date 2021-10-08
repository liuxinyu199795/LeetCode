import java.util.*;

public class LeetCode352 {
    private Set<Integer> set;

    public LeetCode352() {
        set = new TreeSet<>();
    }

    public void addNum(int val) {
        set.add(val);
    }

    public int[][] getIntervals() {
        List<int[]> ret = new ArrayList<>();
        Iterator<Integer> iterator = set.iterator();
        // 逐个检查集合中相邻的两个元素
        int begin = iterator.next(), end = begin;
        while (iterator.hasNext()) {
            int t = iterator.next();
            // 通过比较下一个元素和当前 end 之差是不是1，看看是否需要开始新的区间
            if (t != end + 1) {
                // 如果需要更新的话，就先把当前区间放到返回值中，然后再重新开始新的区间
                ret.add(new int[]{begin, end});
                begin = t;
                end = begin;
            } else {
                // 否则的话，就更新当前区间的 end
                end = t;
            }
        }
        // 最后需要把剩余的区间放到返回值中
        ret.add(new int[]{begin, end});
        return ret.toArray(new int[ret.size()][]);
    }
}
