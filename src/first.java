//求2^100mod(5)余几
public class first {
    public static void main(String[] args) {
        System.out.println("2^101mod(5)的余数是:"+getMod(101));
    }
    public static int getMod(int num){
        int num2;
        int mod=num%4;
        switch (mod){
            case 0:num2=1;
                break;
            case 1:num2=2;
                break;
            case 2:num2=4;
                break;
            case 3:num2=3;
                break;
            default:num2=0;
        }
        return num2;
    }
}
