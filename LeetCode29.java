


public class LeetCode29 {
    public static int divide(int dividend, int divisor) {
        if(dividend==0) return 0;
        if(dividend==Integer.MIN_VALUE&&divisor==-1){
            return Integer.MAX_VALUE;
        }
        boolean flag;
        flag=(dividend^divisor)<0;
        long t=Math.abs((long)dividend);
        long d=Math.abs((long)divisor);
        int result=0;
        for (int i = 31; i>=0 ; i--) {
            if((t>>i)>=d){//判断t跟2^n*advisor
                result+=1<<i;//加上2^n
                t-=d<<i;//减去2^n*advisor
            }
        }
        return flag? -result:result;
    }

    public static void main(String[] args) {
        System.out.println(divide(10,3));
        System.out.println(divide(7,-3));
        System.out.println(divide(0,-3));
        System.out.println(1>>31);
    }
}
