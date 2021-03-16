public class DivideNum {
    public static void main(String[] args) {
        int num=divide(-1,1);
        System.out.println(num);
    }
    public static int divide(int dividend, int divisor) {
        long divideNum=divideLong((long) dividend,(long) divisor);
        return divideNum>Integer.MAX_VALUE?Integer.MAX_VALUE:(int)divideNum;
    }
    public static long divideLong(long dividend, long divisor) {
        long num=0;
        int minusFlag=0;
        if (dividend<0){
            dividend=-dividend;
            minusFlag++;
        }
        if (divisor<0){
            divisor=-divisor;
            minusFlag++;
        }
        while(dividend>=divisor){
            divisor+=divisor;
            num+=num;
        }
        if (minusFlag%2==1) {
            num=-num;
        }
        return num;
    }
}
