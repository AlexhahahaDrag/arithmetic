package array;

import java.util.HashMap;
import java.util.Map;

public class ArithmeticTriplets {

    public int arithmeticTriplets(int[] nums, int diff) {
        int res = 0;
        boolean[] map = new boolean[201];
        for(int i : nums) {
            map[i] = true;
        }
        for(int i = 0; i <= 200 - 2 * diff; i++) {
           if (map[i] && map[i + diff] && map[i + diff * 2]) {
               res++;
           }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,4,6,7,10};
        int diff = 3;
        ArithmeticTriplets arithmeticTriplets = new ArithmeticTriplets();
        System.out.println(arithmeticTriplets.arithmeticTriplets(nums, diff));
    }
}
