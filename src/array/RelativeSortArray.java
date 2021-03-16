package array;

/**
 *description:
 * 1122. 数组的相对排序
 * 给你两个数组，arr1 和 arr2，
 *
 * arr2 中的元素各不相同
 * arr2 中的每个元素都出现在 arr1 中
 * 对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。
 *
 *
 *
 * 示例：
 *
 * 输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
 * 输出：[2,2,2,1,4,3,3,9,6,7,19]
 *
 *
 * 提示：
 *
 * arr1.length, arr2.length <= 1000
 * 0 <= arr1[i], arr2[i] <= 1000
 * arr2 中的元素 arr2[i] 各不相同
 * arr2 中的每个元素 arr2[i] 都出现在 arr1 中
 *author:       alex
 *createDate:   2020/11/14 13:10
 *version:      1.0.0
 */
public class RelativeSortArray {

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] map = new int[1001];
        for(int i : arr1) {
            map[i]++;
        }
        int index = 0;
        for(int i : arr2) {
            while(map[i]-- > 0) {
                arr1[index++] = i;
            }
        }
        for(int i = 0; i < 1001; i++) {
            while (map[i]-- > 0) {
                arr1[index++] = i;
            }
        }
        return arr1;
    }

    public static void main(String[] args) {
        int[] arr1 = {};
        int[] arr2 = {};
        RelativeSortArray relativeSortArray = new RelativeSortArray();
        int[] res = relativeSortArray.relativeSortArray(arr1, arr2);
        for(int i : res) {
            System.out.print(i + "   ");
        }
    }
}
