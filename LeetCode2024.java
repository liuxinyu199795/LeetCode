public class LeetCode2024 {
    //1.滑动窗口
    public int maxConsecutiveAnswers(String answerKey, int k) {
        return Math.max(slideWindow(answerKey,k,'T'),slideWindow(answerKey,k,'F'));
    }
    public int slideWindow(String str,int k,char c){
        int left = 0,right = 0,max = 0;
        while(right < str.length()){
            if(str.charAt(right) != c){
                k--;
                while(k < 0){
                    if(str.charAt(left) != c){
                        k++;
                    }
                    left++;
                }
            }
            right++;
            max = Math.max(max,right - left);
        }
        return max;
    }
}
