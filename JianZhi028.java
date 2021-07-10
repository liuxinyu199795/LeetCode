/**
 * @ProjectName: LeetCode
 * @Author: XinyuLiu
 * @Description:
 */
public class JianZhi028 {
    //1.摩尔投票法
    public int MoreThanHalfNum_Solution(int [] array) {
        int cur = -1,num = 0;
        for (int n : array) {
            if(num == 0){
                cur = n;
                num++;
            }else{
                num += n == cur ? 1 : -1;
            }
        }
        int sum = 0;
        for (int i : array) {
            if(i == cur) sum++;
        }
        return cur;
    }
}
