package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 *description:  
 *author:       alex
 *createDate:   2021/11/18 21:59
 *version:      1.0.0
 */
public class Permute {
    private List<List<Integer>> res;
    private List<Integer> list;
    public List<List<Integer>> permute1(int[] nums) {
        res = new ArrayList<>();
        Arrays.sort(nums);
        list = new ArrayList<>();
        for(int num : nums) {
            list.add(num);
        }
        res.add(list);
        dfs(nums);
        return res;
    }

    private void dfs(int[] nums) {
        for(int i = nums.length - 2; i >= 0; i--) {
            for(int j = nums.length - 1; j > i; j--) {
                if(nums[i] < nums[j]) {
                    swap(nums, j, i);
                    Arrays.sort(nums, i + 1, nums.length);
                    list = new ArrayList<>();
                    for(int num : nums) {
                        list.add(num);
                    }
                    res.add(list);
                    i = nums.length - 1;
                }
            }
        }
    }


    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> map = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        for(int num : nums) {
            cur.add(num);
        }
        search(nums, cur,  map, 0);
        return map;
    }

    private void search(int[] nums, List<Integer> cur, List<List<Integer>> map, int start) {
        if(start == nums.length) {
            map.add(new ArrayList<>(cur));
        }
        for(int i = start; i < nums.length; i++) {
            Collections.swap(cur, i, start);
            search(nums, cur, map, start + 1);
            Collections.swap(cur, i, start);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        Permute permute = new Permute();
        System.out.println(permute.permute(nums));
    }
}
