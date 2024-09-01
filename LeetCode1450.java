import java.util.Arrays;

public class LeetCode1450 {
    //1.递归方法
    /*public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int res = 0;
        if(startTime.length == 0 || endTime.length == 0){
            return res;
        }
        for (int i = 0; i < startTime.length; i++) {
            if(startTime[i]<= queryTime && endTime[i] >= queryTime){
                res++;
            }
        }
        return res;
    }*/
    //2.差分方法
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int length = startTime.length;
        int maxEndTime = Arrays.stream(endTime).max().getAsInt();
        if(queryTime > maxEndTime){
            return 0;
        }
        int[] res = new int[maxEndTime + 2];
        //算差分数组
        for (int i = 0; i < length; i++) {
            res[startTime[i]]++;
            res[endTime[i] + 1]--;
        }
        int ans = 0;
        //然后在请求时间内求差分数组的前缀和就知道了
        for (int i = 0; i <= queryTime; i++) {
            ans += res[i];
        }
        return ans;
    }
}
