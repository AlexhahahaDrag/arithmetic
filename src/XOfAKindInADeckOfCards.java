import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @Description: In a deck of cards, each card has an integer written on it.
 *
 * Return true if and only if you can choose X >= 2 such that it is possible to split the entire deck into 1 or more groups of cards, where:
 *
 * Each group has exactly X cards.
 * All the cards in each group have the same integer.
 *
 *
 * Example 1:
 *
 * Input: [1,2,3,4,4,3,2,1]
 * Output: true
 * Explanation: Possible partition [1,1],[2,2],[3,3],[4,4]
 * Example 2:
 *
 * Input: [1,1,1,2,2,2,3,3]
 * Output: false
 * Explanation: No possible partition.
 * Example 3:
 *
 * Input: [1]
 * Output: false
 * Explanation: No possible partition.
 * Example 4:
 *
 * Input: [1,1]
 * Output: true
 * Explanation: Possible partition [1,1]
 * Example 5:
 *
 * Input: [1,1,2,2,2,2]
 * Output: true
 * Explanation: Possible partition [1,1],[2,2],[2,2]
 *
 * Note:
 *
 * 1 <= deck.length <= 10000
 * 0 <= deck[i] < 10000
 * @Author:      alex
 * @CreateDate:  2019/2/22 15:40
 * @param
 * @return
*/
public class XOfAKindInADeckOfCards {
    public static void main(String[] args) {
        int deck[]={1,1,2,2,2,2};
        System.out.println(hasGroupsSizeX(deck));
    }
    public static boolean hasGroupsSizeX(int[] deck) {
        if(deck.length<=1)
            return false;
        Map<Integer,Integer>map =new HashMap<>();
        for(int i=0;i<deck.length;i++)
            map.put(deck[i],map.getOrDefault(deck[i],0)+1);
        Iterator<Map.Entry<Integer,Integer>> it=map.entrySet().iterator();
        map.values();
        Integer value=it.next().getValue();
        while(it.hasNext()){
            int num=it.next().getValue();
            int x=gcd(num,value);
            if(x!=num&&(x&1)==1)
                return false;
        }
        return true;
    }
    public static int gcd(int x,int y){
        return x==0?y:gcd(y%x,x);
    }
}
