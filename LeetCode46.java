import java.util.ArrayList;
import java.util.List;

public class LeetCode46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> listList = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        permute(nums,list,listList);
        return listList;
    }
    public void permute(int[] nums,List<Integer> list,List<List<Integer>> listList){
        int length=nums.length;
        if(list.size()==length){
            listList.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i <length ; i++) {
            if(list.contains(nums[i])){
                continue;
            }
            list.add(nums[i]);
            permute(nums,list,listList);
            list.remove(list.size()-1);
        }
    }
    public static void main(String[] args) {
    }
}
