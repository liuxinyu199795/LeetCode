import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

/**
 * @ProjectName: LeetCode
 * @Author: XinyuLiu
 * @Description:
 */
public class LeetCode179 {
    //字符串比较，java可以字符串相加用compareTo，
    public static String largestNumber(int[] nums) {
        int length = nums.length;
        for (int i = 0; i <length-1 ; i++) {
            for (int j = 0; j <length-1-i ; j++) {
                if(compare(nums,j,j+1)){
                    int tmp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = tmp;
                }
            }
        }
        StringBuffer sb = new StringBuffer();
        for (int i = length-1; i >=0 ; i--) {
            sb.append(nums[i]);
        }
        return sb.toString().charAt(0)=='0'?"0":sb.toString();//特殊情况考虑全是0
    }
    public static boolean compare(int[] nums,int i ,int j){
        String s1 = String.valueOf(nums[i]);
        String s2 = String.valueOf(nums[j]);
        return (s1+s2).compareTo(s2+s1)>=0;
    }
}
