package array;

/**
 *description:
 * 面试题11. 旋转数组的最小数字
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。
 *
 * 示例 1：
 *
 * 输入：[3,4,5,1,2]
 * 输出：1
 * 示例 2：
 *
 * 输入：[2,2,2,0,1]
 * 输出：0
 * 注意：本题与主站 154 题相同：https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array-ii/
 *author:       alex
 *createDate:  2020/3/31 21:39
 *version:      1.0.0      
*/
public class MinArray {

    public int minArray1(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return  -1;
        }
        int cur = numbers[0];
        for(int i : numbers) {
            if (i < cur) {
                return i;
            }
        }
            return cur;
    }

    public int minArray(int[] numbers) {
        int start = 0;
        int end = numbers.length -1;
        while (start < end) {
            int mid = start + (end - start >> 1);
            if (numbers[mid] < numbers[end]) {
                end = mid;
            } else if (numbers[mid] > numbers[end]) {
                start = mid + 1;
            } else {
                end -= 1;
            }
        }
        return numbers[start];
    }

    public static void main(String[] args) {
        int[] numbers = {1, 3, 5};
        MinArray minArray = new MinArray();
        System.out.println(minArray.minArray(numbers));
    }
}
