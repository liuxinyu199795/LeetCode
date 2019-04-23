import java.util.*;

public class LeetCode40 {
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> listAll=new ArrayList<List<Integer>>();
        List<Integer> list=new ArrayList<Integer>();
        //排序
        int[] num=delete(candidates);
        Arrays.sort(num);
        find(listAll,list,num,target,0);
        return listAll;
    }
    public static void  find(List<List<Integer>> listAll,List<Integer> tmp,int[] candidates,int target,int num){
        //递归的终点
        if(target==0){
            if(isTrue(tmp)){
                listAll.add(tmp);
                return;
            }
        }
        if(target<candidates[0]) return;
        for(int i=num;i<candidates.length&&candidates[i]<=target;i++){
            //深拷贝
            List<Integer> list=new ArrayList<>(tmp);
            list.add(candidates[i]);
            //递归运算，将i传递至下一次运算是为了避免结果重复。
            find(listAll,list,candidates,target-candidates[i],i);
        }
    }
    public static int[] delete(int[] nums){
        Arrays.sort(nums);
        List<Integer> list =new ArrayList<>();
        int a=nums[0];
        list.add(nums[0]);
        for (int i = 1; i <nums.length ; i++) {
            if(nums[i]!=a){
                list.add(nums[i]);
                a=nums[i];
            }
        }
        int[] array=new int[list.size()];
        for (int i = 0; i <list.size() ; i++) {
            array[i]=list.get(i);
        }
        return array;
    }
    public static boolean isTrue(List<Integer> num){
        Set<Integer> set =new HashSet<>(num);
        if(set.size()==num.size()){
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        int[] num =new int[]{10,1,2,7,6,1,5};
        List<List<Integer>> lists = combinationSum2(num, 8);
        Iterator iterator =lists.iterator();
        while(iterator.hasNext()){
            Object next = iterator.next();
            System.out.println(next);
        }

    }
}
