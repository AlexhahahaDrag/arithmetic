package array;

/**
 * @Description:
 * 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在众数。
 *
 * 示例 1:
 *
 * 输入: [3,2,3]
 * 输出: 3
 * 示例 2:
 *
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 * @Author:     alex
 * @CreateDate: 2019/11/21 16:34
 * @Version:    1.0
 *
*/
public class MajorityElement {

    public static void main(String[] args) {
        MajorityElement majorityElement = new MajorityElement();
        int[] arr = {3, 3, 4};
        System.out.println(majorityElement.majorityElement(arr));
    }
    public int majorityElement(int[] nums) {
        int num = 0;
        int count = 0;
        for(int i : nums) {
            if(count == 0){
                num = i;
                count++;
            } else if (num == i)
                count++;
            else
                count--;
        }
        return num;
    }
}
