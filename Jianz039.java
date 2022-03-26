public class Jianz039 {
    //投票算法（计数，相同加一不同减一，最后遍历数组中有多少个最后的数）
    public int MoreThanHalfNum_Solution(int [] array) {
        int candidate = -1;
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if(count == 0){
                candidate = array[i];
                count++;
            }else{
                if(candidate == array[i]) count++;
                else count--;
            }
        }
        count = 0;
        for (int num : array) {
            if(num == candidate) count++;
        }
        return count > array.length / 2 ? candidate : 0;
    }
}
