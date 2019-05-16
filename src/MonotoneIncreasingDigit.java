public class MonotoneIncreasingDigit {
    public static void main(String[] args) {
        System.out.println(monotoneIncreasingDigits(120));
    }
    public static int monotoneIncreasingDigits(int N) {
        if(increasingDigits(N))
            return N;
        else
            return findmonotoneIncreasingDigits(N,0);
    }
    public static int findmonotoneIncreasingDigits(int N,int digit) {
        N=N/((int)Math.pow(10,digit))*((int)Math.pow(10,digit))-1;
        if(increasingDigits(N))
            return N;
        else
            return findmonotoneIncreasingDigits(N,++digit);
    }
    public static boolean increasingDigits(int N) {
        int pre=N%10;
        while(N>0){
            N/=10;
            int cur=N%10;
            if(pre<cur)
                return false;
            pre=cur;
        }
        return true;
    }

}
