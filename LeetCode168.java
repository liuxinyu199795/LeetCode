/**
 * @ProjectName: LeetCode
 * @Author: XinyuLiu
 * @Description:
 */
public class LeetCode168 {
    public String convertToTitle(int columnNumber) {
        StringBuffer sb = new StringBuffer();
        while(columnNumber > 0){
            //1.去掉0的影响
            columnNumber --;
            sb.append((char)(columnNumber % 26 +'A'));
            columnNumber /= 26;
        }
        return sb.reverse().toString();
    }
}
