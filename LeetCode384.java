import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class LeetCode384 {
    int[] nums;
    int n;
    Random random = new Random();
    public LeetCode384(int[] _nums) {
        nums = _nums;
        n = nums.length;
    }
    public int[] reset() {
        return nums;
    }
    public int[] shuffle() {
        int[] ans = nums.clone();
        for (int i = 0; i < n; i++) {
            swap(ans, i, i + random.nextInt(n - i));
        }
        return ans;
    }
    void swap(int[] arr, int i, int j) {
        int c = arr[i];
        arr[i] = arr[j];
        arr[j] = c;
    }

    public static void main(String[] args) {

    }
}
