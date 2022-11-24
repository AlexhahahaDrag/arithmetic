package array;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

public class FindClosestElements {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int start = 0;
        int end = arr.length - k;
        int mid;
        while (start < end) {
            mid = start + (end - start >> 1);
            if (x - arr[mid] > arr[mid + k] - x) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        int finalStart = start;
        return new AbstractList<Integer>() {
            @Override
            public Integer get(int index) {
                return arr[finalStart + index];
            }

            @Override
            public int size() {
                return k;
            }
        };
    }

    public List<Integer> findClosestElements1(int[] arr, int k, int x) {
        int index = findx1(arr, x);
        int start = index - 1;
        int end = index;
        int num = 0;
        List<Integer> list = new ArrayList<>();
        while (num < k) {
            if (start < 0) {
                end++;
            } else if (end >= arr.length) {
                start--;
            } else if (arr[end] - x >= x - arr[start]) {
                start--;
            } else {
                end++;
            }
            num++;
        }
        int finalStart = start;
        return new AbstractList<Integer>() {
            @Override
            public Integer get(int index) {
                return arr[finalStart + index + 1];
            }

            @Override
            public int size() {
                return k;
            }
        };
    }

    private int findx1(int[] arr, int x) {
        int start = 0;
        int end = arr.length - 1;
        int mid;
        while (start < end) {
            mid = start + (end - start >> 1);
            if (arr[mid] < x) {
                start = mid + 1;
            } else if (arr[mid] == x) {
                return mid;
            } else {
                end = mid;
            }
        }
        return start;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int k = 4;
        int x = 3;
        FindClosestElements findClosestElements = new FindClosestElements();
        System.out.println(findClosestElements.findClosestElements(arr, k, x));
    }
}
