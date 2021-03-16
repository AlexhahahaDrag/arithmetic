package array;

/**
 * Description:
 * 给你一个非递减的 有序 整数数组，已知这个数组中恰好有一个整数，它的出现次数超过数组元素总数的 25%。
 *
 * 请你找到并返回这个整数
 *
 *  
 *
 * 示例：
 *
 * 输入：arr = [1,2,2,6,6,6,6,7,10]
 * 输出：6
 *  
 *
 * 提示：
 *
 * 1 <= arr.length <= 10^4
 * 0 <= arr[i] <= 10^5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/element-appearing-more-than-25-in-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * Author:      alex
 * CreateDate:  2019/12/26 13:34
 * Version:     1.0
 *
*/
public class FindSpecialInteger {

    public int findSpecialInteger(int[] arr) {
        if(arr.length < 4) {
            return arr[0];
        }
        int len = arr.length >> 2;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == arr[i + len]) {
                return arr[i];
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        FindSpecialInteger findSpecialInteger = new FindSpecialInteger();
        int[] arr = {1,2,2,6,6,6,6,7,10};
        System.out.println(findSpecialInteger.findSpecialInteger(arr));
    }
}
