import java.util.*;

/**
 * @ProjectName: LeetCode
 * @Author: XinyuLiu
 * @Description:
 */
public class LeetCode90 {
    //1.回溯法(先排序，然后递归
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> listSet = new HashSet<>();
        List<Integer> cur = new ArrayList<>();
        dfs(nums,0,cur,listSet);
        return new ArrayList<>(listSet);
    }
    private void dfs(int[] nums,int i,List<Integer> list,Set<List<Integer>> listSet){
        if(nums.length==i){
            listSet.add(new ArrayList<>(list));
            return;
        }
        list.add(nums[i]);
        dfs(nums,i+1,list,listSet);

        list.remove(list.size()-1);
        dfs(nums,i+1,list,listSet);
    }
}
