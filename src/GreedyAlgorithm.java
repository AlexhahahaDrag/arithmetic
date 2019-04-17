import java.util.ArrayList;
import java.util.List;

public class GreedyAlgorithm {
    public static void main(String[] args) {
        Active active1=new Active(1,4);
        Active active2=new Active(3,5);
        Active active3=new Active(0,6);
        Active active4=new Active(5,7);
        Active active5=new Active(3,8);
        Active active6=new Active(5,9);
        Active active7=new Active(6,10);
        Active active8=new Active(8,11);
        Active active9=new Active(8,12);
        Active active10=new Active(2,13);
        Active active11=new Active(12,14);
        List<Active> actives=new ArrayList<>();
        actives.add(active1);
        actives.add(active2);
        actives.add(active3);
        actives.add(active4);
        actives.add(active5);
        actives.add(active6);
        actives.add(active7);
        actives.add(active8);
        actives.add(active9);
        actives.add(active10);
        actives.add(active11);
        List<Active> bestAcitves=getBestActive(actives,0,16);
        for (int i = 0; i < bestAcitves.size(); i++) {
            System.out.println(bestAcitves.get(i));
        }
    }
    public static List<Active> getBestActive(List<Active> actives,int startTime,int endTime){
        List<Active> bestActives=new ArrayList<Active>();
        actives.sort(null);
        int nowTime=startTime;
        for (int i = 0; i < actives.size(); i++) {
            Active active=actives.get(i);
            if (active.getStartTime()>nowTime&&active.getEndTime()<=endTime){
                bestActives.add(active);
                nowTime=active.getEndTime();
            }
        }
        return bestActives;
    }
}
class Active implements Comparable<Active>{
    private int startTime;
    private int endTime;

    public Active(int startTime, int endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "active time: [start time="+startTime+",end time="+endTime+"]";
    }

    @Override
    public int compareTo(Active o) {
        if (this.endTime>o.endTime){
            return 1;
        }else if (this.endTime==o.endTime){
            return 0;
        }else {
            return -1;
        }

    }
}
