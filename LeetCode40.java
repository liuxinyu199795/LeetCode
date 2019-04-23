import java.util.*;

public class LeetCode40 {
    static List<List<Integer>> ret;
    static boolean[] used;

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        ret = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return ret;
        }

        Arrays.sort(candidates);

        used = new boolean[candidates.length];
        LinkedList<Integer> list = new LinkedList<>();
        generateSum(candidates, 0, target, list);
        return ret;
    }

    // 从start处开始寻找合适的元素，trace：距离target剩余的空间
    private static void generateSum(int[] candidates, int start, int trace, LinkedList<Integer> list) {
        if (trace == 0) {
            ret.add(new LinkedList<>(list));
        }

        for (int i = start; i <= candidates.length - 1; i++) {
            // 每个数字只能出现一次，去重
            if (i != 0 && candidates[i] == candidates[i - 1] && !used[i - 1])
                continue;

            // 不满足，提前退出循环
            if (candidates[i] > trace)
                break;

            list.add(candidates[i]);
            used[i] = true;
            generateSum(candidates, i + 1, trace - candidates[i], list);

            // 回溯
            list.removeLast();
            used[i] = false;
        }
    }
    public static void main(String[] args) {
        int[] num =new int[]{10,1,2,7,6,1,5};
        List<List<Integer>> lists = combinationSum2(num, 8);
        Iterator iterator =lists.iterator();
        while(iterator.hasNext()){
            Object next = iterator.next();
            System.out.println(next);
        }

    }
}
