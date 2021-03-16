import java.util.Arrays;
import java.util.HashMap;

/**
 * @Description: Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * Example:
 *
 * Given nums = [2, 7, 11, 15], target = 9,
 *
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 * @Author:      alex
 * @CreateDate:  2019/3/22 10:09
 * @param
 * @return
*/
public class TwoSum {
    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        int[] nums = {1, 8, 2, 7, 11, 15};
        for (int i : twoSum.twoSum2(nums,9)) {
            System.out.println(i);
        }
    }
    public int[] twoSum2(int[] nums, int target) {
        int[] answer = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; ++i){
            int b = target - nums[i];
            if (map.containsKey(b) && i != map.get(b)) {
                return new int[]{i, map.get(b)};
            }
        }
        return answer;
    }

    public int[] twoSum1(int[] nums, int target) {
        int[] ns = Arrays.copyOf(nums, nums.length);
        Arrays.sort(ns);
        int length = nums.length;
        int end = nums.length - 1;
        for (int i = 0; i < length; ++i) {
            for (int j = end; j > i; --j) {
                int tt = ns[i] + ns[j];
                if (tt == target) {
                    length = nums.length;
                    int a = -1;
                    int b = -1;
                    int s1 = ns[i];
                    int s2 = ns[j];
                    boolean isFirst = true;
                    boolean isSec = true;
                    for (int k = 0; k < length; ++k) {
                        if (isFirst && nums[k] == s1) {
                            a = k;
                            isFirst = false;
                            if(!isSec) {
                                break;
                            }
                        } else if (isSec && nums[k] == s2) {
                            b = k;
                            isSec = false;
                            if(!isFirst) {
                                break;
                            }
                        }
                    }
                    return new int[] { a, b };
                } else if (tt < target) {
                    break;
                } else {
                    end = j - 1;
                }

            }
        }
        return new int[] { -1, -1 };
    }

    public int[] twoSum(int[] nums, int target) {
        int[] ns = Arrays.copyOf(nums, nums.length);
        Arrays.sort(ns);
        for (int i = 0; i < ns.length; i++) {
            for (int j = ns.length - 1; j >= 0; j--) {
                int sum = ns[i] + ns[j];
                if (sum == target) {
                    boolean isFirst = true;
                    boolean isSecond = true;
                    int a = -1;
                    int b = -1;
                    for (int k = 0; k < nums.length; k++) {
                        if (isFirst && nums[k] == ns[i]) {
                            a = k;
                            isFirst = false;
                            if (!isSecond) {
                                break;
                            }
                        } else if (isSecond && nums[k] == ns[j]) {
                            b = k;
                            isSecond = false;
                            if(!isFirst) {
                                break;
                            }
                        }
                    }
                    return new int[] {a, b};
                } else if (sum < target) {
                    break;
                }
            }
        }
        return new int[] {};
    }
}
