import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class LeetCode39 {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> listAll=new ArrayList<List<Integer>>();
        List<Integer> list=new ArrayList<Integer>();
        //排序
        Arrays.sort(candidates);
        find(listAll,list,candidates,target,0);
        return listAll;
    }
    public static void  find(List<List<Integer>> listAll,List<Integer> tmp,int[] candidates, int target,int num){
        //递归的终点
        if(target==0){
            listAll.add(tmp);
            return;
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
    public static void main(String[] args) {
        int[] num =new int[]{2,3,6,7};
        List<List<Integer>> lists = combinationSum(num, 7);
        Iterator iterator =lists.iterator();
        while(iterator.hasNext()){
            Object next = iterator.next();
            System.out.println(next);

        }

    }
}
