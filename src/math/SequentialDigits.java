package math;

import java.util.ArrayList;
import java.util.List;

public class SequentialDigits {

    public List<Integer> sequentialDigits(int low, int high) {
        int lowDi = getDigit(low);
        int highDi = getDigit(high);
        int lowSt = low / (int)(Math.pow(10, lowDi));
        int num = low;
        List<Integer> list = new ArrayList<>();
        while(lowDi <= highDi && num <= high) {
            num = getNum(lowSt, lowDi);
            if (num <= high && num >= low)
                list.add(num);
            if (lowSt + lowDi >= 10) {
                lowSt = 1;
                lowDi++;
            } else
                lowSt++;
        }
        return list;
    }

    private int getDigit(int num) {
        int digit = 0;
        while(num > 0) {
            digit++;
            num /= 10;
        }
        return digit;
    }

    private int getNum(int start, int digit) {
        int num = start;
        while(digit-- > 1)
            num = (num * 10) + ++start;
        return num;
    }

    public static void main(String[] args) {
        SequentialDigits sequentialDigits = new SequentialDigits();
        System.out.println(sequentialDigits.sequentialDigits(1000, 3000));
    }
}
