package GaoPinSuanFa;

public class test8 {
    /*public int myAtoi(String str) {
        //先去掉最前面或者最后面的空格
        str=str.trim();
        if(str==null||str.length()==0) return 0;
        StringBuilder sb = new StringBuilder();
        //去除空格之后，字符串开头只能是+-数字，其他都不符合规则
        if(str.charAt(0)=='+'||str.charAt(0)=='-'||Character.isDigit(str.charAt(0))){
            sb.append(str.charAt(0));
        }else{
            return 0;
        }
        //如果只有+-号
        if((str.charAt(0)=='+'||str.charAt(0)=='-')&&str.length()==1) return 0;
        int i=1;
        while(i<str.length()){
            if(!Character.isDigit(str.charAt(i)){
                break;//开始后不是数字就退出
            }
            sb.append(str.charAt(i));
            //8位以上要判断是否超过int的范围
            if(i>8){//****先将stringbuilder转换成string，再转换为Long类型******
                if(Long.valueOf(sb.toString())>Integer.MAX_VALUE) return Integer.MAX_VALUE;
                if(Long.valueOf(sb.toString())<Integer.MIN_VALUE) return Integer.MIN_VALUE;
            }
            i++;
        }
        return Integer.valueOf(sb.toString());
    }*/

    public static int myAtoi(String str) {
        if (null == str || "".equals(str)) {
            return 0;
        }
        char[] chars = str.toCharArray();
        int count = 0;
        int plus = 0;
        boolean flag = false;
        for(int i = 0;i<chars.length;i++){
            if(' ' == chars[i]&&!flag) {
                continue;
            }
            if(plus == 0 &&'+'==chars[i]&&!flag){
                plus = 1;
                flag = true;
            } else if(plus == 0 && '-' == chars[i]&&!flag){
                plus = 2;
                flag = true;
            } else if(chars[i] >= 48 && chars[i] <= 57){
                flag = true;
                if(chars[i] == '0'&&count == 0) {
                    continue;
                }
                chars[count] = chars[i];
                count++;
            } else {
                break;
            }
        }
        if(count == 0) {
            return 0;
        }
        char[] arr = new char[count];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = chars[i];
        }
        if (arr.length > 10) {
            if (plus <= 1) {
                return 2147483647;
            }
            return -2147483648;
        }
        long l = Long.valueOf(String.valueOf(arr));
        if ((plus <= 1) && l > 2147483647) {
            return 2147483647;
        }
        if (plus == 2 && l > 2147483648l) {
            return -2147483648;
        }
        if (plus <= 1) {
            return (int)l;
        }else return -(int)l;
    }
    public static void main(String[] args) {
        String str="   +1000dasd";
        System.out.println(myAtoi(str));
    }
}
