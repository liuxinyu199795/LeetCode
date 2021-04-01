public class LeetCode50 {
    //迭代法
    /*public static double myPow(double x, int n) {
        double res=1.0;
        for (int i=n; i!=0 ; i/=2) {
            if(i%2!=0) res*=x;
            x*=x;
        }
        return n<0?1/res:res;
    }*/
    //递归法
    public static double myPow(double x, int n){
        if(n==0) return 1;
        if(n<0){
            return 1/myPow(x,-n);
        }
        if(n%2==1){
            return x*myPow(x,n-1);
        }
        return myPow(x*x,n/2);
    }
    public static void main(String[] args) {
        System.out.println(myPow(2.00000,10));

    }
}
