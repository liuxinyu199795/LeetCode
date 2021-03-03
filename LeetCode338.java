
public class LeetCode338 {
    public int[] countBits(int num) {
        int[] nums = new int[num+1];
        nums[0] = 0;
        for (int i = 1; i <=num; i++) {
            nums[i]=nums[i&(i-1)]+1;//i&(i-1)等于i去掉一个1,于是+1;
        }
        return nums;
    }
    public static void main(String[] args) {

    }
}
