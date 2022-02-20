public class LeetCode717 {
    public static boolean isOneBitCharacter(int[] bits) {
        int length = bits.length;
        for (int i = 0; i < bits.length; i++) {
            if(i == bits.length - 1 && bits[i] == 0) return true;
            if(bits[i] == 1) i += 1;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] num = new int[]{1,0,0};
        System.out.println(isOneBitCharacter(num));
    }
}
