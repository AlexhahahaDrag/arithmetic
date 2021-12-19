package array;

import java.util.HashMap;
import java.util.Map;

public class KIncreasing {

    Map<String, Integer> map = new HashMap<>();
    public int kIncreasing(int[] arr, int k) {
        return dfs(arr, k, k);
    }

    private int dfs(int[] arr, int k, int i) {
        if(i >= arr.length) {
            return 0;
        }
        if (map.get(i + "_" + arr[i]) != null) {
            return map.get(i + "_" + arr[i]);
        }
        int old = arr[i - k];
        int oldk = arr[i];
        int res = Integer.MAX_VALUE;
        if(arr[i] >= arr[i - k]) {
            res = Math.min(res, dfs(arr, k, i + 1));
        } else {
            if(i - k * 2 < 0) {
                arr[i - k] = 1;
                res = Math.min(res, dfs(arr, k, i + 1) + 1);
            } else {
                if(arr[i - k * 2] <= arr[i]) {
                    arr[i - k] = arr[i - k * 2];
                    res = Math.min(res, dfs(arr, k, i + 1) + 1);
                }
            }
        }
        arr[i - k] = old;
        arr[i] = old;
        res = Math.min(res, dfs(arr, k, i + 1) + 1);
        arr[i] = oldk;
        map.put(i + "_" + arr[i], res);
        return res;
    }

    public static void main(String[] args) {
//        int[] arr = {5,4,3,2,1};//4
//        int k = 1;
//        int[] arr = {4,1,5,2,6,2};//2
//        int k = 3;
//        int[] arr = {4,1,5,2,6,2};//0
//        int k = 2;
        int[] arr = {12,6,12,6,14,2,13,17,3,8,11,7,4,11,18,8,8,3};//0
        int k = 1;
        KIncreasing kIncreasing = new KIncreasing();
        System.out.println(kIncreasing.kIncreasing(arr, k));
    }
}
