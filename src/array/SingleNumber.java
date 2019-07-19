package array;

import java.util.HashSet;
import java.util.Iterator;
/**Given a non-empty array of integers, every element appears twice except for one. Find that single one.

        Note:

        Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

        Example 1:

        Input: [2,2,1]
        Output: 1
        Example 2:

        Input: [4,1,2,1,2]
        Output: 4*/
public class SingleNumber {
    public static void main(String[] args) {
        int arr[]={2,2,1};
        System.out.println(getSingleNumber2(arr));
    }
    public static int getSingleNumber(int nums[]){
        boolean[] sameFlag=new boolean[nums.length];
        int sameNum=0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (!sameFlag[j]&&nums[i]==nums[j]){
                    sameFlag[i]=true;
                    sameFlag[j]=true;
                }
            }
            if(!sameFlag[i])
                sameNum=nums[i];
        }
        return sameNum;
    }
    public static int getSingleNumber1(int nums[]){
        int sumNum=0;
        HashSet hashSet=new HashSet();
        for (int i = 0; i < nums.length; i++) {
            hashSet.add(nums[i]);
        }
        System.out.println("ha"+hashSet);
        Iterator it=hashSet.iterator();
        while (it.hasNext()){
            sumNum+=(Integer) it.next();
        }
        sumNum*=2;
        for (int j = 0; j < nums.length; j++) {
            sumNum-=nums[j];
        }
        return sumNum;
    }
    public static int getSingleNumber2(int nums[]){
        int sumNum=0;
        for (int i = 0; i < nums.length; i++) {
            sumNum=sumNum^nums[i];
        }
        return sumNum;
    }
}
