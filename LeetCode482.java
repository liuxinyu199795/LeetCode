/**
 * @ProjectName: LeetCode
 * @Author: XinyuLiu
 * @Description:
 */
public class LeetCode482 {
    /*public static String licenseKeyFormatting(String s, int k) {
        String str = s.replaceAll("-","").toUpperCase();
        int length = str.length();
        if(length == 0) return "";
        StringBuilder sb = new StringBuilder();
        int i = 0;
        if(length % k != 0){
            sb.append(str.substring(0,length % k));
            sb.append("-");
            i = length % k;
        }
        while(i < length){
            sb.append(str.substring(i,i + k));
            sb.append("-");
            i += k;
        }
        return sb.substring(0,sb.length() - 1);
    }*/
    //从后往前模拟，避免收个分区的讨论和取余
    public static String licenseKeyFormatting(String s, int k) {
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1, cnt = 0; i >= 0; i--) {
            if (s.charAt(i) == '-') continue;
            if (cnt == k && (cnt = 0) >= 0) sb.append("-");
            sb.append(s.charAt(i));
            cnt++;
        }
        return sb.reverse().toString().toUpperCase();
    }

    public static void main(String[] args) {
        String s = "5F3Z-2e-9-w";
        licenseKeyFormatting(s,4);
    }
}
