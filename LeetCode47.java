import java.util.ArrayList;
import java.util.List;

public class LeetCode47 {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> listList = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        permute(nums,list,listList,new boolean[nums.length]);
        return listList;
    }
    public static void permute(int[] nums,List<Integer> list,List<List<Integer>> listList,boolean[] used){
        int length=nums.length;
        if(list.size()==length){
            listList.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i <length ; i++) {
            if(used[i] || i > 0 && nums[i] == nums[i - 1] && used[i-1]){
                continue;
            }
            used[i]=true;
            list.add(nums[i]);
            permute(nums,list,listList,used);
            list.remove(list.size()-1);
            used[i]=false;
        }
    }
    public static void main(String[] args) {
        int[] num = new int[]{1,1,3};
        List<List<Integer>> list =permute(num);
        System.out.println(list);
    }
}
