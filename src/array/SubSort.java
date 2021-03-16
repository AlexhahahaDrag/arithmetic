package array;

import java.util.Arrays;

/**
 * @description:
 * 面试题 16.16. 部分排序
 * 难度
 * 中等
 *
 * 25
 *
 * 收藏
 *
 * 分享
 *
 * 切换为英文
 *
 * 关注
 *
 * 反馈
 * 给定一个整数数组，编写一个函数，找出索引m和n，只要将索引区间[m,n]的元素排好序，整个数组就是有序的。注意：n-m尽量最小，也就是说，找出符合条件的最短序列。函数返回值为[m,n]，若不存在这样的m和n（例如整个数组是有序的），请返回[-1,-1]。
 * 示例：
 * 输入： [1,2,4,7,10,11,7,12,6,7,16,18,19]
 * 输出： [3,9]
 * 提示：
 * 0 <= len(array) <= 1000000
 * @author:      alex
 * @createTime:  2020/7/17 12:39
 * @version:     1.0
 */
public class SubSort {

    public int[] subSort1(int[] array) {
        int start = 0;
        int end = array.length - 1;
        int[] ne = Arrays.copyOf(array, array.length);
        Arrays.sort(ne);
        while(start < end && ne[start] == array[start]) {
            start++;
        }
        while(start < end && ne[end] == array[end]) {
            end--;
        }
        if (start >= end) {
            return new int[]{-1, -1};
        }
        return new int[] {start, end};
    }

    public int[] subSort(int[] array) {
        int start = 0;
        int end = array.length - 1;
        while(start < array.length - 1 && array[start] <= array[start + 1]) {
            start++;
        }
        while(start < end && array[end] >= array[end - 1]) {
            end--;
        }
        if (start >= end) {
            return new int[]{-1, -1};
        }
        int min = array[start];
        int max = array[end];
        for (int i = start + 1; i <= end; i++) {
            if (min > array[i]) {
                min = array[i];
            }
            if (max < array[i]) {
                max = array[i];
            }
        }
        while(start >= 0 && min < array[start]) {
            start--;
        }
        while(end < array.length && max > array[end]) {
            end++;
        }
        return new int[] {start + 1, end - 1};
    }

    public static void main(String[] args) {
        int[] array = {1,2,4,7,10,11,7,12,6,7,16,18,19};
        SubSort subSort = new SubSort();
        int[] res = subSort.subSort(array);
        for (int i : res) {
            System.out.println(i +  "  ");
        }
    }
}
