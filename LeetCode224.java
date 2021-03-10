import java.util.Stack;

/**
 * @ProjectName: LeetCode
 * @Author: XinyuLiu
 * @Description:
 */
public class LeetCode224 {
    //1.栈暴力
    /*public int calculate(String s) {
        int n = s.length();
        Stack<Integer> stack = new Stack<>();
        int flag = 1,res = 0;
        for (int i = 0; i <n ; i++) {
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                int cur = c-'0';
                while(i+1<n && Character.isDigit(s.charAt(i+1))){
                    cur = cur*10+s.charAt(i+1)-'0';
                }
                res = res + flag * cur;
            }else if(c=='+'){
                flag = 1;
            }else if(c=='-'){
                flag = -1;
            }else if(c=='('){
                stack.push(res);
                res = 0;
                stack.push(flag);
                flag = 1;
            }else if(c==')'){
                res = stack.pop()*res +stack.pop();
            }else if(c==' '){
                continue;
            }
        }
        return res;
    }*/
    //2.双栈解法
    public int calculate(String s) {
        int ans=0;
        char[] str=s.toCharArray();
        int len=str.length;
        Stack<Integer> st_num=new Stack<>();
        Stack<Integer> st_signs=new Stack<>();
        int sign=1;//正负号,运算符号
        for(int i=0;i<len;i++){
            if(str[i]==' ') continue;
            if(str[i]=='+'||str[i]=='-') sign=str[i]=='+'? 1:-1;
            else if(str[i]>='0'&&str[i]<='9'){//数字
                int num=str[i]-'0';
                while(i<len-1&&str[i+1]>='0'&&str[i+1]<='9'){//将这个数字找完
                    num=num*10+(str[++i]-'0');
                }
                ans+=sign*num;
            }else if(str[i]=='('){//左括号，暂存结果
                st_num.push(ans);
                st_signs.push(sign);
                ans=0;
                sign=1;
            }
            else ans=st_num.pop()+ans*st_signs.pop();//右括号更新结果
        }
        return ans;
    }
}
