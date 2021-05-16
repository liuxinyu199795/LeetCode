/**
 * @ProjectName: LeetCode
 * @Author: XinyuLiu
 * @Description:
 */
public class LeetCode13 {
    int[] nums = new int[]{1000,900,500,400,100,90,50,40,10,9,5,4,1};
    String[] strings = new String[]{"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
    public int romanToInt(String s) {
        int res = 0;
        for (int i = 0, j = 0; i < strings.length && j < s.length(); i++) {
            int num = nums[i];
            String str = strings[i];
            int size = str.length();
            while(j + size <= s.length() && s.substring(j,j+size).equals(str)){//因为substring最后一位不算，所以j+size==s.length()
                res += num;
                j += size;
            }
        }
        return res;
    }
}
