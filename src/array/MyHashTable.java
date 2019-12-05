package array;

/**
 * @Description:
 * 不使用任何内建的哈希表库设计一个哈希集合
 *
 * 具体地说，你的设计应该包含以下的功能
 *
 * add(value)：向哈希集合中插入一个值。
 * contains(value) ：返回哈希集合中是否存在这个值。
 * remove(value)：将给定值从哈希集合中删除。如果哈希集合中没有这个值，什么也不做。
 *
 * 示例:
 *
 * MyHashSet hashSet = new MyHashSet();
 * hashSet.add(1);
 * hashSet.add(2);
 * hashSet.contains(1);    // 返回 true
 * hashSet.contains(3);    // 返回 false (未找到)
 * hashSet.add(2);
 * hashSet.contains(2);    // 返回 true
 * hashSet.remove(2);
 * hashSet.contains(2);    // 返回  false (已经被删除)
 *
 * 注意：
 *
 * 所有的值都在 [0, 1000000]的范围内。
 * 操作的总数目在[1, 10000]范围内。
 * 不要使用内建的哈希集合库。
 *
 *
 * @Author:     alex
 * @CreateDate: 2019/12/5 17:19
 * @Version:    1.0
 *
*/
class MyHashTable {

    class Node{
        public int value;
        public Node nextNode;
    }

    private Node[] arr = null;

    private static int size = 10000;

    public MyHashTable() {
        this.arr = new Node[size];
    }

    public void add(int key) {
        if (contains(key))
            return;
        int index = hash(key);
        if (arr[index] == null) {
            Node node = new Node();
            node.value = key;
            arr[index] = node;
        } else {
            Node node = new Node();
            node.value = key;
            Node oldNode = arr[index];
            while(oldNode.nextNode != null)
                oldNode = oldNode.nextNode;
            oldNode.nextNode = node;
        }
    }

    public void remove(int key) {
        if (!contains(key))
            return;
        int index = hash(key);
        if (arr[index].value == key) {
            arr[index] = arr[index].nextNode;
            return;
        }
        Node preNode = arr[index];
        while(preNode.nextNode.value != key)
            preNode = preNode.nextNode;
        preNode.nextNode = preNode.nextNode.nextNode;
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int index = hash(key);
        if (arr[index] == null)
            return false;
        Node node = arr[index];
        while(node != null) {
            if (node.value == key)
                return true;
            node = node.nextNode;
        }

        return false;
    }

    private int hash(int key) {
        return key % 100;
    }
}
