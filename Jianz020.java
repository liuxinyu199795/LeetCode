public class Jianz020 {
    public boolean isNumeric (String str) {
        if(str == null || str.length() == 0){
            return false;
        }
        boolean isNum = false,isDot = false,isE = false;
        char[] arr = str.trim().toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] >= '0' && arr[i] <= '9'){
               isNum = true;
            }else if(arr[i] == '.'){
                if(isDot || isE){
                    return false;
                }
                isDot = true;
            }else if(arr[i] == 'E' || arr[i] == 'e'){
                if(!isNum || isE){
                    return false;
                }
                isE = true;
                isNum = false;//E后必须是整数，且最后返回是否是数字，必须重置
            }else if(arr[i] == '+' || arr[i] == '-'){
                if(i != 0 && arr[i - 1] != 'e' && arr[i - 1] != 'E'){
                    return false;
                }
            }else {
                return false;
            }
        }
        return isNum;
    }
}
