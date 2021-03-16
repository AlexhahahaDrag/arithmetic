public class ReverseInteger {
    public static void main(String[] args) {
        System.out.println(reverse(-1230));
    }
    public static int reverse(int x) {
        long num=0;
        for (; 0 != x; x/=10){
            if (num>Integer.MAX_VALUE) {
                return 0;
            }
            num=num*10+x%10;
        }
        if ((int)num==num) {
            return (int)num;
        } else {
            return 0;
        }
    }
}
