import java.util.HashMap;
import java.util.Map;

/**
 * @ProjectName: LeetCode
 * @Author: XinyuLiu
 * @Description:
 */
public class LeetCode1603 {
    //1.map存储（时间长，内存小）
   /* Map<Integer,Integer> map = new HashMap<>();
    public ParkingSystem(int big, int medium, int small) {
        map.put(1,big);
        map.put(2,medium);
        map.put(3,small);
    }

    public boolean addCar(int carType) {
        if(map.get(carType)!=0){
            map.put(carType,map.get(carType)-1);
            return true;
        }else{
            return false;
        }
    }*/
    //2.简单变量存储（同上）
    /*int big, medium, small;
    public ParkingSystem(int _big, int _medium, int _small) {
        big = _big;
        medium = _medium;
        small = _small;
    }

    public boolean addCar(int ct) {
        if (ct == 1 && big > 0) return big-- > 0;
        else if (ct == 2 && medium > 0) return medium-- > 0;
        else if (ct == 3 && small > 0) return small-- > 0;
        return false;
    }*/
}
