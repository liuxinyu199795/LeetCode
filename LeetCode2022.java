public class LeetCode2022 {
    public static int[][] construct2DArray(int[] original, int m, int n) {
        int[][] res = new int[m][n];
        int length = original.length;
        if(length != m * n) return new int[0][0];
        for (int i = 0,index = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res[i][j] = original[index++];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] ints = construct2DArray(new int[]{1, 2}, 1, 1);
        System.out.println(ints);

    }
}
