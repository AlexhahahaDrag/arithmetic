package tree.binartTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *@description:
 *@author:       alex
 *@createDate:   2022/8/22 7:16
 *@version:      1.0.0
 */
public class PrintTree {

    private int height;
    public List<List<String>> printTree(TreeNode root) {
        height = height(root);
        int n = (int)Math.pow(2, height) - 1;
        String[][] res = new String[height][n];
        get(root, res, n - 1 >> 1, 0);
        List<List<String>> result = new ArrayList<>();
        for(String[] i : res) {
            result.add(Arrays.asList(i));
        }
        return result;
    }

    private void get(TreeNode root, String[][] res, int index, int level) {
        if(root == null) {
            return;
        }
        res[level][index] = root.val + "";
        int cur = (int)Math.pow(2, height - level - 2);
        get(root.left, res, index - cur, level + 1);
        get(root.right, res, index + cur, level + 1);
    }

    private int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(height(root.left), height(root.right)) + 1;
    }
}
