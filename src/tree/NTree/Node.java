package tree.NTree;

import java.util.List;

/**
 *description:  N叉树
 *author:       alex
 *createDate:  2020/2/28 22:25
 *version:      1.0.0
*/
public class Node {

    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
