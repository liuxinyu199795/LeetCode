public class Jianz044 {
    public static int findNthDigit (int n) {
        // write code here
        if(n<10)return n;
        //把0位剔除,方便计算
        n--;
        int k=1;
        int num=0;
        //计算出n所在的区间，并保存n所在区间的位数
        while(n>0){
            num=n;
            n=(int)(n-Math.pow(10,k-1)*9*k);
            k++;
        }
        //a：第几个数，b：数的第几位
        int a=num/(k-1);
        int b=num%(k-1);
        //a需要加上区间的基数
        a=a+(int)(Math.pow(10,k-2));
        String s=a+"";
        //a的第b位数字就是所求的第n位数字
        return Integer.parseInt(s.substring(b,b+1));
    }

    public static void main(String[] args) {
        findNthDigit(1000000000);
    }
}
