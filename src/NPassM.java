
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class NPassM {
    public static void main(String[] args) {
        getReturn(5,10000,5);
    }
    public static void getReturn(int M,int N,int start){
        System.out.println(new Date().getTime());
        List<Integer> list=new LinkedList<>();
        for( int i = 1; i <= N; i++)
            list.add(i);
        start-=1;
        while(list.size()>0){
            int index=(start+M)%list.size();
            start=index;
            System.out.println(list.get(index));
            ((LinkedList<Integer>) list).remove(index);
        }
        System.out.println(new Date().getTime());
    }
}
