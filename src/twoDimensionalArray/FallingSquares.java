package twoDimensionalArray;

import java.util.ArrayList;
import java.util.List;

public class FallingSquares {

    public List<Integer> fallingSquares(int[][] positions) {
        Tree tree = new Tree();
        List<Integer> res = new ArrayList<>();
        int n = (int) 1e9;
        for(int[] i : positions) {
            int x = i[0];
            int h = i[1];
            int cur = query(tree, x, x + h - 1, 0, n);
            update(tree, h + cur, x, x + h - 1, 0, n);
            res.add(tree.val);
        }
        return res;
    }

    class Tree {
        Tree left;
        Tree right;
        int val;
        int add;

        public Tree() {
        }
    }

    private int query(Tree node, int ll, int rr, int l, int r) {
        if (ll <= l && r <= rr) {
            return node.val;
        }
        pushDown(node);
        int mid = l + (r - l >> 1);
        int ans = 0;
        if(ll <= mid) {
            ans = query(node.left, ll, rr, l, mid);
        }
        if (mid < rr) {
            ans = Math.max(ans, query(node.right, ll, rr, mid + 1, r));
        }
        return ans;
    }

    private void update(Tree node, int val, int ll, int rr, int l, int r) {
        if (l >= ll && r <= rr) {
            node.val = val;
            node.add = val;
            return;
        }
        pushDown(node);
        int mid = l + (r - l >> 1);
        if (ll <= mid) {
            update(node.left, val, ll, rr, l, mid);
        }
        if (rr > mid) {
            update(node.right, val, ll, rr, mid + 1 , r);
        }
        pushUp(node);
    }

    private void pushDown(Tree node)  {
        if (node.left == null) {
            node.left = new Tree();
        }
        if (node.right == null) {
            node.right = new Tree();
        }
        if (node.add == 0) {
            return;
        }
        node.left.add = node.add;
        node.left.val = node.add;
        node.right.add = node.add;
        node.right.val = node.add;
        node.add = 0;
    }

    private void pushUp(Tree node) {
        node.val = Math.max(node.left.val, node.right.val);
    }

    public static void main(String[] args) {
        int[][] positions = {{1, 2}, {2, 3}, {6, 1}};
        FallingSquares fallingSquares = new FallingSquares();
        System.out.println(fallingSquares.fallingSquares(positions));
    }
}
