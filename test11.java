package GaoPinSuanFa;

public class test11 {
    //1.暴搜
    /*public static int maxArea(int[] height) {
        int len=height.length;
        if(len<2) return 0;
        int max=0;
        int size=0;
        for (int i = 0; i <len ; i++) {
            for (int j = i+1; j <len ; j++) {
                size=(j-i)*(height[i]>height[j]?height[j]:height[i]);
                if(max<size){
                    max=size;
                }
            }
        }
        return max;
    }*/
    //2.双指针法
    public static int maxArea(int[] height) {
        int maxarea = 0, l = 0, r = height.length - 1;
        while (l < r) {
            maxarea = Math.max(maxarea, Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r])
                l++;
            else
                r--;
        }
        return maxarea;
    }
    public static void main(String[] args) {
        int[] num=new int[]{1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(num));
    }
}
