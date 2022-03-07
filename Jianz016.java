public class Jianz016 {
    //1.暴力法
    /*public double Power(double base, int exponent) {
        boolean flag = exponent < 0;
        if(flag) exponent = -exponent;
        double res = 1l;
        while(exponent-- != 0){
            res *= base;
        }
        return flag ? 1/res : res;
    }*/
    //2.快速幂
    public double Power(double base, int exponent) {
        double res = 1.0;
        for (int i = exponent; i != 0 ; i /= 2) {
            if((i&1) == 1){
                res *= base;
            }
            base *= base;
        }
        if(exponent < 0){
            res = 1 / res;
        }
        return res;
    }
}
