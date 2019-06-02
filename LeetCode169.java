import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LeetCode169 {
    //1.暴力法
    /*public static int majorityElement(int[] nums) {
        for (int i = 0; i <nums.length ; i++) {
            int a=nums[i];
            int num=1;
            for (int j = i+1; j <nums.length ; j++) {
                if(nums[j]==a) num++;
            }
            if(num>nums.length/2) return a;
        }
        return 0;
    }*/

    //2.Map键值对记录法
    /*public static int majorityElement(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i <nums.length ; i++) {
            if(!map.containsKey(nums[i])){
                map.put(nums[i],1);
            }else if(map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i])+1);
            }
        }
        for (Map.Entry<Integer,Integer> entry:map.entrySet()){
            if(entry.getValue()>nums.length/2) return entry.getKey();
        }
        return 0;
    }*/

    //3.sort排序法
    public static int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int num=1,max=num;
        if(nums.length==1) return nums[0];
        for (int i = 0; i <nums.length-1; i++) {
            if(nums[i]!=nums[i+1]){
                num=1;
            }else{
                num++;
            }
            if(num>nums.length/2) return nums[i];
        }
        return 0;
    }


    public static void main(String[] args) {
        int[] num = new int[]{3,1,1};
        System.out.println(majorityElement(num));
    }
}
