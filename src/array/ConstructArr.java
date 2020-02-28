package array;

import java.util.Arrays;

/**
 *description:
 * 面试题66. 构建乘积数组
 * 给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，其中 B 中的元素 B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。
 *
 *
 *
 * 示例:
 *
 * 输入: [1,2,3,4,5]
 * 输出: [120,60,40,30,24]
 *
 *
 * 提示：
 *
 * 所有元素乘积之和不会溢出 32 位整数
 * a.length <= 100000
 *author:       alex
 *createDate:  2020/2/28 14:00
 *version:      1.0.0      
*/
public class ConstructArr {

    public int[] constructArr(int[] a) {
        int ms = 1;
        for(int j : a)
            ms *= j;
        int[] res = new int[a.length];
        Arrays.fill(res, 1);
        int index = 0;
        int len = a.length;
        int pre = 1;
        while(index < len) {
            if (a[index] == 1) {
                res[index++] = ms;
                continue;
            }

            res[index] *= pre;
            for (int i = index + 1; i < len; i++)
                res[index] = a[i] * res[index];
            pre *= a[index++];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        ConstructArr constructArr = new ConstructArr();
        int[] res = constructArr.constructArr(arr);
        for (int i : res)
            System.out.print(i + "   ");
    }
}
