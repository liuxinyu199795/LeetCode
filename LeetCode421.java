/**
 * @ProjectName: LeetCode
 * @Author: XinyuLiu
 * @Description:
 */
public class LeetCode421 {
    //1.字典树， & 1得到数本身
    class Node{
        Node[] ns = new Node[2];
    }
    Node root = new Node();
    public void add(int num){
        Node p = root;
        for (int i = 31; i >= 0; i--) {
            int a = (num >> i) & 1;
            if(p.ns[a] == null) p.ns[a] = new Node();
            p = p.ns[a];
        }
    }
    public int findVal(int num){
        int ans = 0;
        Node p = root;
        for (int i = 31; i >= 0; i--) {
            int a =(num >> i) & 1, b = 1 - a;
            if(p.ns[b] != null){
                ans |= (b << i);
                p = p.ns[b];
            }else{
                ans |= (a << i);
                p = p.ns[a];
            }
        }
        return ans;
    }
    public int findMaximumXOR(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            add(num);
            max = Math.max(max,num ^ findVal(num));
        }
        return max;
    }
}
