

import java.util.*;

public class LeetCode18 {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        int length=nums.length;
        Arrays.sort(nums);
        List<List<Integer>> list =new ArrayList<>();
        for (int i = 0; i <length-3 ; i++) {
            if(i!=0&&nums[i-1]==nums[i]){
                continue;
            }
            for (int j = i+1; j <length-2 ; j++) {
                if(j!=i+1&&nums[j-1]==nums[j]){
                    continue;
                }
                if(j==i+1||j>i+1&&nums[j-1]!=nums[j]){
                    int k=j+1,l=length-1;
                    while(k<l){
                        if(nums[i]+nums[j]+nums[k]+nums[l]==target){
                            list.add(Arrays.asList(nums[i],nums[j],nums[k],nums[l]));
                            while(k<l&&nums[k+1]==nums[k]) k++;
                            while(k<l&&nums[l-1]==nums[l]) l--;
                            k++;
                            l--;
                        }else if(nums[i]+nums[j]+nums[k]+nums[l]<target){
                            while(k<l&&nums[k+1]==nums[k]) k++;
                            k++;
                        }else{
                            while(k<l&&nums[l-1]==nums[l]) l--;
                            l--;
                        }
                    }
                }
            }
        }
        return list;
    }
    public static void main(String[] args) {
        int[] num={1,0,-1,0,-2,2};
        System.out.println(fourSum(num,0));
    }
}
