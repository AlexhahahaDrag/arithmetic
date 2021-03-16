package tree.NTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 *description:
 * 429. N叉树的层序遍历
 * 给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。
 *
 * 例如，给定一个 3叉树 :
 *
 * 返回其层序遍历:
 *
 * [
 *      [1],
 *      [3,2,4],
 *      [5,6]
 * ]
 *
 *
 * 说明:
 *
 * 树的深度不会超过 1000。
 * 树的节点总数不会超过 5000。
 *author:       alex
 *createDate:  2020/3/24 19:51
 *version:      1.0.0      
*/
public class LevelOrder {

    public List<List<Integer>> levelOrder1(Node<Integer> root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<Node<Integer>> queue = new LinkedBlockingQueue<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            Queue<Node<Integer>> cur = new LinkedBlockingQueue<>();
            List<Integer> list = new ArrayList<>();
            while(!queue.isEmpty()) {
                Node<Integer> node = queue.poll();
                if (node != null) {
                    list.add(node.val);
                    List<Node<Integer>> children = node.children;
                    cur.addAll(children);
                }
            }
            queue = cur;
            res.add(list);
        }
        return res;
    }

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(root, 0, res);
        return res;
    }

    private void dfs(Node<Integer> node, int level, List<List<Integer>> res) {
        if (node == null) {
            return;
        }
        if (res.size() == level) {
            res.add(new ArrayList<>());
        }
        res.get(level).add(node.val);
        for(Node<Integer> child : node.children) {
            dfs(child, level + 1, res);
        }
    }
}
