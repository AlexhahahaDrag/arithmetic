package array;

public class NumTimesAllBlue {

    public int numTimesAllBlue(int[] flips) {
        int max = flips[0];
        int res = 0;
        for(int i = 0; i < flips.length; i++) {
            max = Math.max(flips[i], max);
            if (max == i + 1) {
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] flips = {3,2,4,1,5};
        NumTimesAllBlue numTimesAllBlue = new NumTimesAllBlue();
        System.out.println(numTimesAllBlue.numTimesAllBlue(flips));
    }
}
