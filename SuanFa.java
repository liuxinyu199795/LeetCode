/**
 * @ProjectName: LeetCode
 * @Author: XinyuLiu
 * @Description:
 */
public class SuanFa {
    //1.冒泡排序
    public static void bubbleSort(int[] nums){
        int length = nums.length;
        for (int i = 0; i <length ; i++) {
            for (int j = length-1; j >i ; j--) {
                if(nums[j]<nums[j-1]){
                    swap(nums,j-1,j);
                }
            }
        }
    }
    //2.快速排序
    public static void quickSort(int[] nums,int left,int right){
        if(left>right) return;
        int i = left, j = right, temp = nums[i];
        while(i<j){
            while(i < j && temp < nums[j]){//找小于等于旗杆的
                j--;
            }
            while(i < j && temp >= nums[i]){//找大于等于旗杆的
                i++;
            }
            if(i < j){
                swap(nums,i,j);
            }
        }
        nums[left] = nums[j];
        nums[j] = temp;
        quickSort(nums,left,j-1);
        quickSort(nums,j+1,right);
    }
    //3.简单选择排序
    public static void selectSort(int[] nums){
        int length = nums.length;
        for (int i = 0; i <length ; i++) {
            int min = i;
            for (int j = i; j <length ; j++) {
                if(nums[j]<nums[min]){
                    min = j;
                }
            }
            swap(nums,i,min);
        }
    }
    //4.直接插入排序
    public static void insertSort(int[] nums){
        int length = nums.length;
        for (int i = 1; i <length ; i++) {
            int k = i;
            a:for (int j = i-1; j >=0 ; j--) {
                if(nums[j]>nums[k]){
                    swap(nums,k,j);
                    k--;
                }else{
                    break a;//只要满足大小，不交换就可以停下，无须再跟之前有序的进行比较了
                }
            }
        }
    }
    //5.希尔排序(开始步长为1/2length的插入排序）
    public static void shellSort(int[] nums){
        int length = nums.length;
        if(length == 0 || nums == null) return;
        int num = length >> 1;
        while(num>=1){
            for (int i = num; i < length; i++) {
                for (int j = i-num; j >= 0; j -= num) {
                    if(nums[j+num]<nums[j]){//注意这的比较 跟前num个比
                        swap(nums,j+num,j);
                    }
                }
            }
            num = num >> 1;
        }
    }
    //6.归并排序
    public static int[] mergeSort(int[] nums,int left,int right){
        if(left<right){
            int mid = left + right >>1;
            mergeSort(nums,left,mid);
            mergeSort(nums,mid+1,right);
            merge(nums,left,mid,right);
        }
        return nums;
    }
    public static int[] merge(int[] nums,int left,int mid,int right){
        int i = left, j = mid+1, k =0;
        int[] tmp = new int[right-left+1];
        while(i<=mid && j<=right){
            if(nums[i]<nums[j]){
                tmp[k++] = nums[i++];
            }else{
                tmp[k++] = nums[j++];
            }
        }
        while(i <= mid){
            tmp[k++] = nums[i++];
        }
        while(j <= right){
            tmp[k++] = nums[j++];
        }
        for (int l = 0; l <tmp.length ; l++) {
            nums[l+left] = tmp[l];//注意下标
        }
        return nums;
    }
    //7.堆排序
    //8.基数排序
    public static void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5,3,6,1,7,4,2};
        //bubbleSort(nums);
        //quickSort(nums,0,nums.length-1);
        //selectSort(nums);
        //insertSort(nums);
        //shellSort(nums);
        mergeSort(nums,0,nums.length-1);
        for (int num : nums) {
            System.out.println(num);
        }
    }
}
