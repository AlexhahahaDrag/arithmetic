package tree.binartTree;

import java.util.ArrayList;
import java.util.List;

public class LevelOrderBottom {

    List<List<Integer>> res;
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        res = new ArrayList<>();
        level(root, 0);
        List<List<Integer>> result = new ArrayList<>();
        for (List<Integer> li : res)
            result.add(0, li);
        return result;
    }

    private void level(TreeNode root, int level) {
        if(root == null)
            return;
        List<Integer> li;
        if(level == res.size()) {
            li = new ArrayList<>();
            res.add(li);
        }
        level(root.left, level + 1);
        level(root.right, level + 1);
        li = res.get(level);
        li.add(root.val);
    }

    public static void main(String[] args) {
        TreeNode root = null;
        LevelOrderBottom levelOrderBottom = new LevelOrderBottom();
        System.out.println(levelOrderBottom.levelOrderBottom(root));
    }
}
