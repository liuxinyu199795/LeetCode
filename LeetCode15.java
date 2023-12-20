import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode15 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if(nums[i] > 0) break;
            if(i > 0 && nums[i] == nums[i - 1]) continue;//nums[i]值重复了，去重
            int j = i + 1,k = nums.length - 1;
            while(j < k){
                int sum = nums[i]+nums[j]+nums[k];
                if(sum < 0){
                    while(j < k && nums[j] == nums[++j]);//去重
                }else if(sum > 0){
                    while(j < k && nums[k] == nums[--k]);//去重

                }else{
                    res.add(new ArrayList<>(Arrays.asList(nums[i],nums[j],nums[k])));
                    while(j < k && nums[j] == nums[++j]);//去重
                    while(j < k && nums[k] == nums[--k]);//去重
                }
            }
        }
        return res;
    }
}
