package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description:
 * @Author:     alex
 * @CreateDate: 2019/8/22 17:14
 * @Version:    1.0
 *
*/
public class Permutations {

    public static void main(String[] args) {
        Permutations permutations = new Permutations();
        int[] arr = {1, 2, 3};
        System.out.println(permutations.permute(arr));
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        int p = nums.length - 1;
        int q;
        int pFind;
        list.add(getList(nums));
        while(p != 0) {
            q = p;
            p--;
            if (nums[p] < nums[q]) {
                pFind = nums.length - 1;
                while(nums[pFind] < nums[p]) {
                    pFind--;
                }
                swap(nums, pFind, p);
                sort(nums, q, nums.length - 1);
                list.add(getList(nums));
                p = nums.length - 1;
            }
        }
        return list;
    }

    private void sort(int[] arr, int i, int j) {
        while(i < j) {
            swap(arr, i++, j--);
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private List<Integer> getList(int[] arr) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
        }
        return list;
    }
}
