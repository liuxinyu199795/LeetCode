public class LeetCode33 {
    public static int search(int[] nums, int target) {
        return search(nums,0,nums.length-1,target);
    }
    public static int search(int[] nums,int low,int high,int target){
        if(low>high) return -1;
        int mid=(low+high)/2;
        if(nums[mid]==target) return mid;
        if(nums[mid]<nums[high]){
            if(nums[mid]<target&&target<=nums[high]){
                return search(nums,mid+1,high,target);
            }else{
                return search(nums,low,mid-1,target);
            }
        }else{
            if(nums[low]<=target&&target<nums[mid]){
                return search(nums,low,mid-1,target);
            }else{
                return search(nums,mid+1,high,target);
            }
        }

    }
    public static void main(String[] args) {
        int[] nums={4,5,6,7,0,1,2};
        System.out.println(search(nums,2));
        System.out.println(search(nums,3));
        System.out.println(search(nums,0));
    }
}
