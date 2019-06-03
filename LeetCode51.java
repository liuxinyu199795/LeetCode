import java.util.*;

public class LeetCode51 {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> list = new ArrayList<>();
        Set<Integer> col = new HashSet<>();
        Set<Integer> z = new HashSet<>();
        Set<Integer> y = new HashSet<>();
        track(0,n,new ArrayList<String>(),list,col,z,y);
        return list;
    }
    public static void track(int i,int n,ArrayList<String> strings,List<List<String>> list,Set<Integer> col,Set<Integer> z,Set<Integer> y){
        //判断如果弄完了就加载到list中去
        if(i==n){
            list.add(new ArrayList<>(strings));
            return;
        }

        for (int j = 0; j <n ; j++) {
            if(!col.contains(j)&&!z.contains(i+j)&&!y.contains(i-j)){
                //该添加的添加
                col.add(j);
                z.add(i+j);
                y.add(i-j);
                char[] chars = new char[n];
                Arrays.fill(chars,'.');
                chars[j]='Q';
                strings.add(new String(chars));
                //继续进行递归
                track(i+1,n,strings,list,col,z,y);
                //递归完了进行恢复操作
                strings.remove(strings.size()-1);
                col.remove(j);
                z.remove(i+j);
                y.remove(i-j);
            }

        }
    }
    public static void main(String[] args) {

    }
}
