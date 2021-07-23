/**
 * @ProjectName: LeetCode
 * @Author: XinyuLiu
 * @Description:
 */
public class LeetCode1893 {
    public static boolean isCovered(int[][] ranges, int left, int right) {
        int res = 0;
        for (int i = left; i <= right; i++) {
            a:for (int j = 0; j < ranges.length; j++) {
                if(i <= ranges[j][1] && i >= ranges[j][0]){
                    res++;
                    break a;
                }
            }
        }
        return res == right - left + 1 ? true : false;
    }

    public static void main(String[] args) {
        int[][] nums = new int[][]{{25,42},{7,14},{2,32},{25,28},{39,49},{1,50},{29,45},{18,47}};
        System.out.println(isCovered(nums,15,38));
    }
}
