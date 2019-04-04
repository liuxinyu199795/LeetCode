package GaoPinSuanFa;

public class test4 {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m=nums1.length;
        int n=nums2.length;
        int i=0,j=0,k=0;
        int[] nums3=new int[(m+n)/2+1];
        while(i<m&&j<n&&i+j<nums3.length){
            if(nums1[i]<nums2[j]){
                nums3[k++]=nums1[i++];
            }else{
                nums3[k++]=nums2[j++];
            }
        }
        while(i<m&&i+j<nums3.length){
            nums3[k++]=nums1[i++];
        }
        while(j<n&&i+j<nums3.length){
            nums3[k++]=nums2[j++];
        }
        if((m+n)%2==0){
            return ((double)(nums3[(m+n)/2-1]+nums3[(m+n)/2]))/2;
        }else{
            return (double)(nums3[(m+n)/2]);
        }
    }

    public static void main(String[] args) {
        int[] num1=new int[]{1,3,5};
        int[] num2=new int[]{2,4,5};
        int[] num3=new int[]{2,4};
        System.out.println(findMedianSortedArrays(num1,num2));
        System.out.println(findMedianSortedArrays(num1,num3));
    }
}
