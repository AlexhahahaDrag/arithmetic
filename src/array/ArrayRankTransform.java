package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ArrayRankTransform {

    public int[] arrayRankTransform(int[] arr) {
        int n = arr.length;
        if(n == 0) {
            return arr;
        }
        if (n == 1) {
            arr[0] = 1;
            return arr;
        }
        int[] ar = Arrays.copyOfRange(arr, 0, arr.length);
        Arrays.sort(arr);
        Map<Integer, Integer> map = new HashMap<>(n);
        for(int i = 0, last = arr[i] + 1, index = 1; i < arr.length; last = arr[i++]) {
            if (last != arr[i]) {
                map.put(arr[i], index++);
            }
        }
        for(int j = 0; j < arr.length; j++) {
            ar[j] = map.get(ar[j]);
        }
        return ar;
    }
}
