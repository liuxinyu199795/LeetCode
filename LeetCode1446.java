public class LeetCode1446 {
    public int maxPower(String s) {
        int res = 1,num = 1;
        boolean equal = false;
        for (int i = 1; i < s.length(); i++) {
            if(s.charAt(i) == s.charAt(i - 1)){
                if(equal){
                  num++;
                  res = Math.max(res,num);
                  continue;
                }else{
                    equal = true;
                    num++;
                    res = Math.max(res,num);
                    continue;
                }
            }
            if(equal){
                equal = false;
                num = 1;
            }
        }
        return res;
    }
}
