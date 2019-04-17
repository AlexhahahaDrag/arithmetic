/**
 * @Description:The set S originally contains numbers from 1 to n. But unfortunately, due to the data error, one of the numbers in the set got duplicated to another number in the set, which results in repetition of one number and loss of another number.
 *
 * Given an array nums representing the data status of this set after the error. Your task is to firstly find the number occurs twice and then find the number that is missing. Return them in the form of an array.
 *
 * Example 1:
 * Input: nums = [1,2,2,4]
 * Output: [2,3]
 * Note:
 * The given array size will in the range [2, 10000].
 * The given array's numbers won't have any order.
 * @Author:      alex
 * @CreateDate:  2019/2/27 16:13
 * @param
 * @return
*/
public class SetMismatch {
    public static void main(String[] args) {
        int[] nums={1,2,2,4};
        System.out.println(findErrorNums(nums));
    }
    public static int[] findErrorNums(int[] nums) {
        int[] indexs=new int[nums.length+1];
        for(int i:nums)
            indexs[i]++;
        int missing=1;
        int due=-1;
        for(int k=1;k<indexs.length;k++)
            if(indexs[k]==0)
                missing=k;
            else if(indexs[k]==2)
                due=k;
        return new int[]{due,missing};
    }
}
