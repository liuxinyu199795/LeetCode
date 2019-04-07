package GaoPinSuanFa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class test15 {
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);//先排序
        List<List<Integer>> lists = new ArrayList<>();
        int length=nums.length;
        for (int i = 0; i <length-2; i++) {
            if(i==0||i>0&&nums[i]!=nums[i-1]){
                int j=i+1;
                int k=length-1;
                int sum=0-nums[i];
                while(j<k){
                    if(nums[j]+nums[k]==sum){
                        lists.add(Arrays.asList(nums[j],nums[k],nums[i]));
                        while(j<k&&nums[j+1]==nums[j]) j++;
                        while(j<k&&nums[k-1]==nums[k]) k--;
                        j++;
                        k--;
                    }else if(nums[j]+nums[k]>sum){
                        while(j<k&&nums[k-1]==nums[k]) k--;
                        k--;
                    }else{
                        while(j<k&&nums[j+1]==nums[j]) j++;
                        j++;
                    }
                }
            }
        }
        return lists;
    }
    public static void main(String[] args) {
        int[] num={-1,0,1,2,-1,-4};
        System.out.println(threeSum(num));
    }
}
