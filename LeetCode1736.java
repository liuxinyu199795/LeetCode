/**
 * @ProjectName: LeetCode
 * @Author: XinyuLiu
 * @Description:
 */
public class LeetCode1736 {
    public static String maximumTime(String time) {
        char[] times = time.toCharArray();
        for (int i = 0; i < times.length; i++) {
            if('?' == times[i]){
                if(i == 1){
                    times[1] = times[0] == '2' ? '3' : '9';
                }else if(i == 0){
                    if(times[1] == '?'){
                        times[0] = '2';
                        times[1] = '3';
                    }else{
                        times[0] = times[1] > '3' ? '1' : '2';
                    }
                }else if(i == 3){
                    if(times[4] == '?'){
                        times[3] = '5';
                        times[4] = '9';
                    }else{
                        times[3] = '5';
                    }
                }else{
                    times[4] = '9';
                }
            }
        }
        return String.valueOf(times);
    }

    public static void main(String[] args) {
        String str = "2?:?0";
        System.out.println(maximumTime(str));
    }
}
