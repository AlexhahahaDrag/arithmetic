package tree.binartTree;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: alex
 * @createDate: 2022/10/30 17:18
 * @version: 1.0.0
 */
public class TreeQueries {

    private Map<Integer, Integer> height;
    public int[] treeQueries(TreeNode root, int[] queries) {
        int[] res = new int[queries.length];
        height = new HashMap<>();
        return res;
    }



    /**
     * @param node
     * @description: 获取节点高度
     * @author:      alex
     * @return:      int
    */
    private int getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int h = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
        height.put(node.val, h);
        return h;
    }
}
