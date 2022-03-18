/**
 * @ProjectName: LeetCode
 * @Author: XinyuLiu
 * @Description:
 */
public class LeetCode2043 {
    long[] val;
    int length;
    public LeetCode2043(long[] balance) {
        val = balance;
        length = balance.length;
    }

    public boolean transfer(int account1, int account2, long money) {
        if(account1 > length || account2 > length) return false;
        if(val[account1 - 1] < money) return false;
        val[account1 - 1] -= money;
        val[account2 - 1] += money;
        return true;
    }

    public boolean deposit(int account, long money) {
        if(account > length) return false;
        val[account - 1] += money;
        return true;
    }

    public boolean withdraw(int account, long money) {
        if(account > length || val[account - 1] < money) return false;
        val[account - 1] -= money;
        return true;
    }
}
