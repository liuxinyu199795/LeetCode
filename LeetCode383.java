public class LeetCode383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] num1 = new int[26], num2 = new int[26];
        for (char num : ransomNote.toCharArray()) {
            num1[num - 'a']++;
        }
        for (char num : magazine.toCharArray()) {
            num2[num - 'a']++;
        }
        for (int i = 0; i < num1.length; i++) {
            if(num1[i] > num2[i]) return false;
        }
        return true;
    }
}
