public class Test2 {
    public static void main(String[] args) {
        System.out.println(getCount(2019));
    }
    public static int getCount(int num){
        int count=0;
        for (int i=1;i<num/3;i++){
            if (contains2Or4(i)){
                for (int j=i+1;j<num/2;j++){
                    if (num-i-j>j&&contains2Or4(j)&&contains2Or4(num-i-j)){
                            count++;
                    }
                }
            }
        }
        return count;
    }
    public static boolean contains2Or4(int num){
        while(num>0){
            if (num%10==2||num%10==4)
                return false;
            num/=10;
        }
        return true;
    }
}
