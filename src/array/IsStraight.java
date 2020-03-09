package array;

import java.util.Arrays;

/**
 *description:
 * 面试题61. 扑克牌中的顺子
 * 从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
 *
 *
 *
 * 示例 1:
 *
 * 输入: [1,2,3,4,5]
 * 输出: True
 *
 *
 * 示例 2:
 *
 * 输入: [0,0,1,2,5]
 * 输出: True
 *
 *
 * 限制：
 *
 * 数组长度为 5
 *
 * 数组的数取值为 [0, 13] .
 *author:       alex
 *createDate:  2020/3/6 18:00
 *version:      1.0.0
*/
public class IsStraight {

    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        int index = -1;
        while(nums[++index] == 0)
            count++;
        int cur = nums[index++];
        while(index < 5) {
            if (nums[index] == cur + 1)
                index++;
            else if (count > 0) {
                count--;
            }else
                return false;
            cur++;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 0, 0};
        IsStraight isStraight = new IsStraight();
        System.out.println(isStraight.isStraight(arr));
    }
}
