import java.util.HashSet;
import java.util.Set;

public class LeetCode69 {
    public int mySqrt(int x) {
        int left=1,right=x,res=0,mid;
        while(left<=right){
            mid=(left+right)/2;
            if(mid==x/mid){
                return mid;
            }else if(mid<x/mid){
                left=mid+1;
                res=mid;
            }else{
                right=mid-1;
            }
        }
        return res;
    }
    public static void main(String[] args) {

    }
}
