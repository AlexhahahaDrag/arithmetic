public class Test1 {
    public static void main(String[] args) {
        System.out.println(getDigits(20190324));
    }
    public static int getDigits(int num){
        if (num<=3)
            return 1;
        int a=1;
        int b=1;
        int c=1;
        int sum=0;
        while(num>3){
           /* sum=a+b+c;*/
           sum=(a+b+c)%10000;
            a=b;
            b=c;
            c=sum;
            num--;
        }
       return sum;
    }
}
