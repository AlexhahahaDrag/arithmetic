package array;

import java.util.Arrays;

/**
 *description:
 *
 * 5332. 检查整数及其两倍数是否存在 显示英文描述
 * 用户通过次数1249
 * 用户尝试次数1347
 * 通过次数1266
 * 提交次数3096
 * 题目难度Easy
 * 给你一个整数数组 arr，请你检查是否存在两个整数 N 和 M，满足 N 是 M 的两倍（即，N = 2 * M）。
 *
 * 更正式地，检查是否存在两个下标 i 和 j 满足：
 *
 * i != j
 * 0 <= i, j < arr.length
 * arr[i] == 2 * arr[j]
 *
 *
 * 示例 1：
 *
 * 输入：arr = [10,2,5,3]
 * 输出：true
 * 解释：N = 10 是 M = 5 的两倍，即 10 = 2 * 5 。
 * 示例 2：
 *
 * 输入：arr = [7,1,14,11]
 * 输出：true
 * 解释：N = 14 是 M = 7 的两倍，即 14 = 2 * 7 。
 * 示例 3：
 *
 * 输入：arr = [3,1,7,11]
 * 输出：false
 * 解释：在该情况下不存在 N 和 M 满足 N = 2 * M 。
 *
 *
 * 提示：
 *
 * 2 <= arr.length <= 500
 * -10^3 <= arr[i] <= 10^3
 *author:       alex
 *createDate:  2020/2/9 11:13
 *version:      1.0.0      
*/
public class CheckIfExist {

    public boolean checkIfExist(int[] arr) {
        Arrays.sort(arr);
        int[] arrBig = new int[arr.length];
        for(int i = 0; i < arr.length; i++) {
            arrBig[i] = arr[i] << 1;
        }
        for(int j = 0; j < arrBig.length; j++) {
            for (int k = 0; k < arr.length; k++) {
                if (k != j) {
                    if (arrBig[j] == arr[k]) {
                        return true;
                    } else if (arrBig[j] < arr[k]) {
                        break;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        CheckIfExist checkIfExist = new CheckIfExist();
        int[] arr = {-7,1,-14,11};
        System.out.println(checkIfExist.checkIfExist(arr));
    }
}
