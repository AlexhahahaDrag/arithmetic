package array;

import java.util.Arrays;

public class MaximumGroups {

    public int maximumGroups(int[] grades) {
        if (grades.length <= 2) {
            return 1;
        }
        Arrays.sort(grades);
        int res = 0;
        return res;
    }

    public static void main(String[] args) {
        int[] grades = {10,6,12,7,3,5};
        MaximumGroups maximumGroups = new MaximumGroups();
        System.out.println(maximumGroups.maximumGroups(grades));
    }
}
