import java.util.ArrayList;
import java.util.List;

public class CutOffTreesForGolfEvent {
    private static int treeNum=0;
    public static void main(String[] args) {
        List<List<Integer>> forest=new ArrayList<>();
        List<Integer> list1=new ArrayList<>();
        list1.add(54581641);
        list1.add(64080174);
        list1.add(24346381);
        list1.add(69107959);
        forest.add(list1);
        List<Integer> list2=new ArrayList<>();
        list2.add(86374198);
        list2.add(61363882);
        list2.add(68783324);
        list2.add(79706116);
        forest.add(list2);
        List<Integer> list3=new ArrayList<>();
        list3.add(668150);
        list3.add(92178815);
        list3.add(89819108);
        list3.add(94701471);
        forest.add(list3);
        List<Integer> list4=new ArrayList<>();
        list4.add(83920491);
        list4.add(22724204);
        list4.add(46281641);
        list4.add(47531096);
        forest.add(list3);
        List<Integer> list5=new ArrayList<>();
        list5.add(89078499);
        list5.add(18904913);
        list5.add(25462145);
        list5.add(60813308);
        forest.add(list3);
        System.out.println(cutOffTree(forest));
    }
    public static int cutOffTree(List<List<Integer>> forest) {
        if(forest.size()==0) {
            return -1;
        }
        if(forest.get(0).get(0)==0) {
            return -1;
        }
        int x=0;
        int y=0;
        method:while(x>=0&&y>=0&&x<forest.size()&&y<forest.get(x).size()){
            char flag='a';
            int min=Integer.MAX_VALUE;
            int lmove=1;
            while(y-lmove>=0){
                int lnum=forest.get(x).get(y-lmove);
                if (lnum==1) {
                    lmove++;
                } else if(lnum!=0&&min>lnum){
                    min=lnum;
                    flag='l';
                }else {
                    break;
                }
            }
            int rmove=1;
            while(x<forest.size()&&y+rmove<forest.get(x).size()){
                int lnum=forest.get(x).get(y+rmove);
                if (lnum==1) {
                    rmove++;
                } else if(lnum!=0&&min>lnum){
                    min=lnum;
                    flag='r';
                }else {
                    break;
                }
            }
            int umove=1;
            while(x-umove>=0&&y<forest.get(x-umove).size()){
                int lnum=forest.get(x-umove).get(y);
                if (lnum==1) {
                    umove++;
                } else if(lnum!=0&&min>lnum){
                    min=lnum;
                    flag='u';
                }else {
                    break;
                }
            }
            int dmove=1;
            while(x+dmove<forest.size()&&y<forest.get(x+dmove).size()){
                int lnum=forest.get(x+dmove).get(y);
                if (lnum==1) {
                    dmove++;
                } else if(lnum!=0&&min>lnum){
                    min=lnum;
                    flag='d';
                }else {
                    break;
                }
            }
            forest.get(x).remove(y);
            forest.get(x).add(y,1);
            switch (flag){
                case 'l':
                    y-=lmove;
                    break;
                case 'r':
                    y+=rmove;
                    break;
                case 'u':
                    x-=umove;
                    break;
                case 'd':
                    x+=dmove;
                    break;
                default:
                    break method;
            }
            treeNum++;
        }
        for (List list: forest) {
            for (Object i:list ) {
                if ((Integer)i!=1&&(Integer)i!=0) {
                    return -1;
                }
            }
        }
        return treeNum;
    }
}
