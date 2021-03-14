import java.util.Arrays;

/**
 * @ProjectName: LeetCode
 * @Author: XinyuLiu
 * @Description:
 */
public class LeetCode706 {
    //数组法
    int INF = Integer.MAX_VALUE;
    int N = 1000009;
    int[] map = new int[N];
    public MyHashMap() {
        Arrays.fill(map, INF);
    }

    public void put(int key, int value) {
        map[key] = value;
    }

    public int get(int key) {
        return map[key] == INF ? -1 : map[key];
    }

    public void remove(int key) {
        map[key] = INF;
    }
}
