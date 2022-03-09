public class Jianz021 {
    //1.双指针 + 新建数组
    /*public int[] reOrderArray (int[] array) {
        int len = array.length;
        int[] res = new int[len];
        int l = 0,r = len - 1,i = l,j = r;
        while(l < len && r >= 0){
            if(array[l] % 2 == 1){
                res[i] = array[l];
                i++;
            }
            l++;
            if(array[r] % 2 == 0){
                res[j] = array[r];
                j--;
            }
            r--;
        }
        return res;
    }*/
    //2.插入排序
    public int[] reOrderArray (int[] array) {
        if(array == null || array.length == 0) return array;
        int j = 0,temp = 0;
        for (int i = 0; i < array.length; i++) {
            temp = array[i];
            if(array[i] % 2 == 0){
                continue;
            }else{
                int k = i;
                while(k > j){
                    array[k] = array[k - 1];
                    k--;
                }
                array[k] = temp;
                j++;
            }
        }
        return array;
    }
}
