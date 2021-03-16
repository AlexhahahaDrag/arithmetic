import java.util.*;

/**
 * @Description: Given an array of integers A with even length, return true if and only if it is possible to reorder it such that A[2 * i + 1] = 2 * A[2 * i] for every 0 <= i < len(A) / 2.
 *
 *
 *
 * Example 1:
 *
 * Input: [3,1,3,6]
 * Output: false
 * Example 2:
 *
 * Input: [2,1,2,6]
 * Output: false
 * Example 3:
 *
 * Input: [4,-2,2,-4]
 * Output: true
 * Explanation: We can take two groups, [-2,-4] and [2,4] to form [-2,-4,2,4] or [2,4,-2,-4].
 * Example 4:
 *
 * Input: [1,2,4,16,8,4]
 * Output: false
 *
 *
 * Note:
 *
 * 0 <= A.length <= 30000
 * A.length is even
 * -100000 <= A[i] <= 100000
 * @Author:      alex
 * @CreateDate:  2019/2/20 13:54
 * @param
 * @return
*/
public class ArrayOfDoubledPairs {
    public static void main(String[] args) {
        int[] A={4,-2,2,-4,-4,-8,8,16};
        System.out.println(canReorderDoubled(A));
    }
    public static boolean canReorderDoubled(int[] A) {
        Map<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            map.put(A[i],map.getOrDefault(A[i],0)+1);
        }
        Integer[] B=new Integer[A.length];
        for (int i = 0; i < A.length; i++) {
            B[i]=A[i];
        }
        Arrays.sort(B,Comparator.comparingInt(Math::abs));
        for (int x: B) {
            if (map.get(x)==0) {
                continue;
            }
            if (map.getOrDefault(x*2,0)<=0) {
                return false;
            }
            map.put(x,map.get(x)-1);
            map.put(x*2,map.get(x*2)-1);
        }
        return true;

    }
}
