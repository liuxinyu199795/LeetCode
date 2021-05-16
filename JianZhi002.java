/**
 * @ProjectName: LeetCode
 * @Author: XinyuLiu
 * @Description:
 */
public class JianZhi002 {
    public String replaceSpace(String s) {
        StringBuffer res = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            String str = s.substring(i,i+1);
            if(" ".equals(str)){
                res.append("%20");
            }else{
                res.append(str);
            }
        }
        return res.toString();
    }
}
