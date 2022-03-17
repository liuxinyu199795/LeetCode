import java.util.Arrays;

public class Jianz033 {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence == null || sequence.length == 0) return false;
        return VerifySquenceOfBST(sequence,0,sequence.length - 1);
    }
    public boolean VerifySquenceOfBST(int [] sequence,int start,int end){
        if(start >= end) return true;
        int node = sequence[end];
        int mid = 0;
        for (; mid < end; mid++) {
            if(sequence[mid] > node) break;
        }
        for (int i = mid; i < end; i++) {
            if(sequence[i] <= node) return false;
        }
        boolean left = true;
        if(mid > start) left = VerifySquenceOfBST(sequence,start,mid - 1);
        boolean right = true;
        if(mid < end) right = VerifySquenceOfBST(sequence,mid,end - 1);

        return left && right;
    }
}
