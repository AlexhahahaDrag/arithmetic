import java.util.*;

/**
 * Given a non-empty array of integers, return the k most frequent elements.
 *
 * Example 1:
 *
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 * Example 2:
 *
 * Input: nums = [1], k = 1
 * Output: [1]
 * Note:
 *
 * You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 * Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 */
public class TopKFrequentElement {
    public static void main(String[] args) {
        int[] nums={3,2,3,1,2,4,5,5,6,7,7,8,2,3,1,1,1,10,11,5,6,2,4,7,8,5,6};
        System.out.println(topKFrequent(nums,10));
    }
    /**
     * @Description:
     * @Author:      alex
     * @CreateDate:  2019/1/10 9:18
     * @param int[] nums
     * @param int k
     * @return list
    */
    public static List<Integer> topKFrequent(int[] nums, int k) {
        List list=new ArrayList();
        HashMap<Integer,Integer> hashtable=new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            hashtable.put(nums[i],hashtable.getOrDefault(nums[i],0)+1);
        }
        Set<Map.Entry<Integer,Integer>> set= hashtable.entrySet();
        Iterator it=set.iterator();
        int[] values=new int[set.size()];
        int i=0;
        while(it.hasNext()){
            Map.Entry<Integer,Integer> entry=(Map.Entry) it.next();
            values[i++]=entry.getValue();
        }
        Arrays.sort(values);
        for (int j = values.length-1; j >=0&&k>0; j--) {
            for (int n:
                    hashtable.keySet()) {
                if (hashtable.get(n)==values[j]){
                    list.add(n);
                    hashtable.remove(n);
                    k--;
                }
            }

        }
        return list;
    }
}
