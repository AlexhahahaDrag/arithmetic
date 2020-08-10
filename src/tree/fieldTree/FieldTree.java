package tree.fieldTree;

/**
 * @description: 字段树
 * @author:      alex
 * @createTime:  2020/8/5 19:17
 * @version:     1.0
 */
public class FieldTree {
    FieldTree left;
    FieldTree right;
    int value;
    int count;
    int dup;

    public FieldTree(int val) {
        this.value = val;
        this.left = null;
        this.right = null;
        this.count = 0;
        this.dup = 0;
    }
}
