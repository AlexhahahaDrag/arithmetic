package classes;

import java.util.HashMap;
import java.util.Map;

/**
 *description:
 * 677. 键值映射
 * 实现一个 MapSum 类，支持两个方法，insert 和 sum：
 *
 * MapSum() 初始化 MapSum 对象
 * void insert(String key, int val) 插入 key-val 键值对，字符串表示键 key ，整数表示值 val 。如果键 key 已经存在，那么原来的键值对将被替代成新的键值对。
 * int sum(string prefix) 返回所有以该前缀 prefix 开头的键 key 的值的总和。
 *
 *
 * 示例：
 *
 * 输入：
 * ["MapSum", "insert", "sum", "insert", "sum"]
 * [[], ["apple", 3], ["ap"], ["app", 2], ["ap"]]
 * 输出：
 * [null, null, 3, null, 5]
 *
 * 解释：
 * MapSum mapSum = new MapSum();
 * mapSum.insert("apple", 3);
 * mapSum.sum("ap");           // return 3 (apple = 3)
 * mapSum.insert("app", 2);
 * mapSum.sum("ap");           // return 5 (apple + app = 3 + 2 = 5)
 *
 *
 * 提示：
 *
 * 1 <= key.length, prefix.length <= 50
 * key 和 prefix 仅由小写英文字母组成
 * 1 <= val <= 1000
 * 最多调用 50 次 insert 和 sum
 *author:       alex
 *createDate:   2021/11/14 19:49
 *version:      1.0.0
 */
public class MapSum {
    private DicTree root;
    private Map<String, Integer> map;
    public MapSum() {
        root = new DicTree();
        map = new HashMap<>();
    }

    public void insert(String key, int val) {
        Integer c = map.get(key);
        if (c != null) {
            insertValue(key, -c);
        }
        map.put(key, val);
        insertValue(key, val);
    }

    private void insertValue(String key, int val) {
        char[] ks = key.toCharArray();
        DicTree cur = root;
        for(char k : ks) {
            if (cur.child[k - 'a'] == null) {
                cur.child[k - 'a'] = new DicTree();
                cur.child[k - 'a'].code = k;
            }
            cur.child[k - 'a'].val += val;
            cur = cur.child[k - 'a'];
        }
    }

    public int sum(String prefix) {
        char[] ch = prefix.toCharArray();
        DicTree cur = root;
        for(char c : ch) {
            if(cur.child[c - 'a'] == null) {
                return 0;
            }
            cur = cur.child[c - 'a'];
        }
        return cur.val;
    }

    class DicTree {
        int val = 0;
        int code;
        DicTree[] child = new DicTree[26];
        public DicTree() {

        }
    }
}
