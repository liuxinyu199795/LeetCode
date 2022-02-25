public class LeetCode537 {
    public static String complexNumberMultiply(String num1, String num2) {
        int[] number1 = check(num1);
        int[] number2 = check(num2);
        StringBuilder res = new StringBuilder();
        res.append(number1[0] * number2[0]-number1[1] * number2[1]);
        res.append("+");
        res.append(number1[0] * number2[1] + number1[1] * number2[0]);
        res.append("i");
        return res.toString();
    }
    public static int[] check(String str){
        StringBuilder num = new StringBuilder();
        StringBuilder i = new StringBuilder();
        boolean isI = false;
        for (char c : str.toCharArray()) {
            if(c == 'i') break;
            if(c == '+' || isI){
                if(c == '+'){
                    isI = true;
                    continue;
                }else{
                    i.append(c);
                }
            }else{
                num.append(c);
            }
        }
        return new int[]{Integer.parseInt(num.toString()),Integer.parseInt(i.toString())};
    }

    public static void main(String[] args) {
        complexNumberMultiply("1+-1i","0+0i");
    }
}
