package string_array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * 两个列表的最小索引总和
 * 假设Andy和Doris想在晚餐时选择一家餐厅，并且他们都有一个表示最喜爱餐厅的列表，每个餐厅的名字用字符串表示。
 *
 * 你需要帮助他们用最少的索引和找出他们共同喜爱的餐厅。 如果答案不止一个，则输出所有答案并且不考虑顺序。 你可以假设总是存在一个答案。
 *
 * 示例 1:
 *
 * 输入:
 * ["Shogun", "Tapioca Express", "Burger King", "KFC"]
 * ["Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"]
 * 输出: ["Shogun"]
 * 解释: 他们唯一共同喜爱的餐厅是“Shogun”。
 * 示例 2:
 *
 * 输入:
 * ["Shogun", "Tapioca Express", "Burger King", "KFC"]
 * ["KFC", "Shogun", "Burger King"]
 * 输出: ["Shogun"]
 * 解释: 他们共同喜爱且具有最小索引和的餐厅是“Shogun”，它有最小的索引和1(0+1)。
 * 提示:
 *
 * 两个列表的长度范围都在 [1, 1000]内。
 * 两个列表中的字符串的长度将在[1，30]的范围内。
 * 下标从0开始，到列表的长度减1。
 * 两个列表都没有重复的元素。
 * @Author:     alex
 * @CreateDate: 2019/12/6 15:32
 * @Version:    1.0
 *
*/
public class FindRestaurant {

    public String[] findRestaurant1(String[] list1, String[] list2) {
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < list1.length; i++)
            map.put(list1[i], i);
        int min = Integer.MAX_VALUE;
        int size = 0;
        for(int j = 0; j < list2.length; j++) {
            if(map.containsKey(list2[j])) {
                int index = map.get(list2[j]) + j;
                if(min > index) {
                    min = index;
                    size = 1;
                } else if (min == index)
                    size++;
            }
        }
        String[] result = new String[size];
        int start = 0;
        for(int k = 0; k < list2.length; k++) {
            if(map.containsKey(list2[k])) {
                int index = map.get(list2[k]) + k;
                if (min == index)
                    result[start++] = list2[k];
            }
        }
        return result;
    }

    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < list1.length; i++)
            map.put(list1[i], i);
        int min = Integer.MAX_VALUE;
        List<String> list = null;
        for(int j = 0; j < list2.length; j++) {
            if(map.containsKey(list2[j])) {
                int index = map.get(list2[j]) + j;
                if(min > index) {
                    min = index;
                    list = new ArrayList<>();
                    list.add(list2[j]);
                } else if (min == index)
                    list.add(list2[j]);
            }
        }
        return (String[]) list.toArray(new String[list.size()]);
    }

    public static void main(String[] args) {
        FindRestaurant findRestaurant = new FindRestaurant();
        String[] list1 = {"Shogun","Tapioca Express","Burger King","KFC"};
        String[] list2 = {"KFC","Burger King","Tapioca Express","Shogun"};
        String[] result = findRestaurant.findRestaurant(list1, list2);
        for (String s : result)
            System.out.println(s);
    }
}
