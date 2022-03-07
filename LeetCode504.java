public class LeetCode504 {
    public String convertToBase7(int num) {
        boolean flag = num < 0;
        if(flag) num = -num;
        StringBuffer sb = new StringBuffer();
        do{
            sb.append(num % 7);
            num /= 7;
        }while (num != 0);
        sb.reverse();
        return flag ? "-" + sb.toString() : sb.toString();
    }
}
