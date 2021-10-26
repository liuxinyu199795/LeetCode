public class LeetCode496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            int j = 0;
            while(j < nums2.length && nums1[i] != nums2[j]) j++;
            while(j < nums2.length && nums1[i] >= nums2[j]) j++;
            res[i] = j < nums2.length ? nums2[j] : -1;
        }
        return res;
    }
}