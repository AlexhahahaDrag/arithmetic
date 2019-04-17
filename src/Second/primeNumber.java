package Second;

public class primeNumber {
    public static void main(String[] args) {
        judgePrimeNumber(22);
    }
    public static void judgePrimeNumber(int num){
        boolean flag=true;
        for (int i = 2; i < Math.sqrt(num); i++) {
            if (num%i==0){
                flag=false;
                break;
            }
        }
        if (flag)
            System.out.println(num+"是素数");
        else
            System.out.println(num+"不是素数");
    }
}
