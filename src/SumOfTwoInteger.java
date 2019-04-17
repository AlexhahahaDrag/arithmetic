
public class SumOfTwoInteger {
    static int sum=0;
    static int carry=0;

    public static void main(String[] args) {
        System.out.println(getSum(-2,3));
    }
    public static int getSum(int a, int b) {
        if(b == 0)
            return sum;
        sum = a ^ b;
        carry = (a & b) << 1;
        return getSum(sum,carry);
    }
}
