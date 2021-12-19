public class LeetCode997 {
    public int findJudge(int n, int[][] trust) {
        // 不信任任何人的人 & 被所有人信任的人
        // 计算每个人信任的人的数量和被信任的数量
        // 前者等于0，后者等于n-1
        int[][] arr = new int[n + 1][2];
        for (int[] t : trust) {
            // 0表示信任别人
            arr[t[0]][0]++;
            // 1表示被别人信任
            arr[t[1]][1]++;
        }

        for (int i = 1; i <= n; i++) {
            if (arr[i][0] == 0 && arr[i][1] == n - 1) {
                return i;
            }
        }

        return -1;
    }
}
