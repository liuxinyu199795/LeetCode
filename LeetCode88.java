/**
 * @ProjectName: LeetCode
 * @Author: XinyuLiu
 * @Description:
 */
public class LeetCode88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p = 0;
        for (int i = m; i <m+n ; i++) {
            nums1[i] = nums2[p++];
        }
        //nums1 = bubbleSort(nums1);//冒泡排序
        quickSort(nums1,0,m+n-1);//冒泡排序

    }
    //1.冒泡排序(n^2时间复杂度)
    public int[] bubbleSort(int[] nums){
        for (int i = 0; i <nums.length-1 ; i++) {
            for (int j = 0; j <nums.length-1-i ; j++) {
                if(nums[j]>nums[j+1]){
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
        }
         return nums;
    }
    //2.快速排序(nlogn时间复杂度)
    public void quickSort(int[] nums,int left,int right){
        if(left>right) return;
        int flag = nums[left];
        int i = left;
        int j = right;
        while(i<j){
            while(nums[j]>flag && i<j){//右边小于旗杆的数
                j--;
            }
            while(nums[i]<=flag && i<j){
                i++;
            }
            while(i<j){
                int temp = nums[i];
                nums[i]=nums[j];
                nums[i]=temp;
            }
        }
        nums[left] = nums[j];
        nums[j] = flag;
        quickSort(nums,left,j-1);
        quickSort(nums,j+1,right);
    }
    //3.双指针，创建m+n长度新数组，排序后重新赋给s1
    /*public void merge(int[] nums1, int m, int[] nums2, int n) {
        int total = m + n;
        int[] arr = new int[total];
        int idx = 0;
        for (int i = 0, j = 0; i < m || j < n;) {
            if (i < m && j < n) {
                arr[idx++] = nums1[i] < nums2[j] ? nums1[i++] : nums2[j++];
            } else if (i < m) {
                arr[idx++] = nums1[i++];
            } else if (j < n) {
                arr[idx++] = nums2[j++];
            }
        }
        System.arraycopy(arr, 0, nums1, 0, total);
    }*/
}
