import java.util.HashMap;
import java.util.Map;

/**
 * 一个整形数组，给定一个数，在数组中找出两个数的和等于这个数，并打印出来，我写的时间复杂度高，要求O(n)
 */

public class TwoNumberSum {
    public static void main(String[] args) {
        int[] arr={2,7,11,15};
        int num=9;
        int[] arr1=getSumToANum(arr,0,arr.length-1,num);
        int[] arr2=getSumToANum111(arr,num);
        System.out.println(arr1[0]+","+arr1[1]);
        System.out.println(arr2[0]+","+arr1[1]);
    }
    public static int[] getSumToANum(int arr[],int start,int end,int num){
        int[] arr1=new int[2];
        while (start<=end){
            if (num==(arr[start]+arr[end])){
                arr1[0]=start;
                arr1[1]=end;
                break;
            }else if (num>(arr[start]+arr[end])) {
                start++;
            } else {
                end--;
            }
        }
        return arr1;
    }
    public static int[] getSumToANum111(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
