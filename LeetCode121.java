public class LeetCode121 {
    //1.遍历数组，求最小值，以及之后的数与最小值差值的最大值
    public int maxProfit(int[] prices) {
        if(prices==null||prices.length==0) return 0;
        int min=prices[0],k=0;
        int p=0;
        for (int i = 1; i <prices.length ; i++) {
            int pp=prices[i]-min;
            if(pp>p){
                p=pp;
            }
            if(prices[i]<min){
                min=prices[i];
                k=i;
            }
        }
        return p;
    }
    public static void main(String[] args) {
    }
}
