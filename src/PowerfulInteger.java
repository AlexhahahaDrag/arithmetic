import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PowerfulInteger {
    public static void main(String[] args) {
        System.out.println(powerfulIntegers(1,2,100));
    }
    public static List<Integer> powerfulIntegers(int x,int y,int bound){
        Set<Integer> list = new HashSet<>();
        long sumX;
        int i=0;
        while(true){
            int j=0;
            sumX=0;
            sumX+=(int)Math.pow(y,i++);
            if (sumX>bound)
                break;
            while(true){
                long sumY=sumX+(int)Math.pow(x,j++);
                if (sumY>bound)
                    break;
                list.add(sumY>Integer.MAX_VALUE?Integer.MAX_VALUE:(int)sumY);
                if (x==1)
                    break;
            }
            if (y==1)
                break;
        }
        return new ArrayList<>(list);
    }
}
