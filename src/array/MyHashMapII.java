package array;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @Description:
 * 不使用任何内建的哈希表库设计一个哈希映射
 *
 * 具体地说，你的设计应该包含以下的功能
 *
 * put(key, value)：向哈希映射中插入(键,值)的数值对。如果键对应的值已经存在，更新这个值。
 * get(key)：返回给定的键所对应的值，如果映射中不包含这个键，返回-1。
 * remove(key)：如果映射中存在这个键，删除这个数值对。
 *
 * 示例：
 *
 * MyHashMap hashMap = new MyHashMap();
 * hashMap.put(1, 1);
 * hashMap.put(2, 2);
 * hashMap.get(1);            // 返回 1
 * hashMap.get(3);            // 返回 -1 (未找到)
 * hashMap.put(2, 1);         // 更新已有的值
 * hashMap.get(2);            // 返回 1
 * hashMap.remove(2);         // 删除键为2的数据
 * hashMap.get(2);            // 返回 -1 (未找到)
 *
 * 注意：
 *
 * 所有的值都在 [1, 1000000]的范围内。
 * 操作的总数目在[1, 10000]范围内。
 * 不要使用内建的哈希库。
 * @Author:     alex
 * @CreateDate: 2019/12/6 9:28
 * @Version:    1.0
 *
 */
public class MyHashMapII {

    class Node {
        int key;
        int value;
        Node next;
    }

    private static int SIZE = 10000;

    private Node[] arr = new Node[SIZE];

    /** Initialize your data structure here. */
    public MyHashMapII() {

    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int index = hash(key);
        if (arr[index] == null) {
            Node node = new Node();
            node.key = key;
            node.value = value;
            arr[index] = node;
        } else {
            Node node = arr[index];
            while(node.next != null) {
                if (node.key == key) {
                    node.value = value;
                    return;
                }
                node = node.next;
            }
            if (node.key == key) {
                node.value = value;
                return;
            }
            Node newNode = new Node();
            newNode.key = key;
            newNode.value = value;
            node.next = newNode;
        }
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int index = hash(key);
        Node node = arr[index];
        while(node != null) {
            if (node.key == key) {
                return node.value;
            }
            node = node.next;
        }
        return -1;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int index = hash(key);
        Node node = arr[index];
        if(node == null) {
            return;
        }
        if(node.key == key) {
            arr[index] = node.next;
        } else {
            Node pre = node;
            while (pre.next != null) {
                if (pre.next.key == key) {
                    pre.next = pre.next.next;
                    return;
                }
                pre = pre.next;
            }
        }
    }

    private int hash(int key) {
        return key % SIZE;
    }

    public static void main(String[] args) {
        MyHashMapII myHashMapII = new MyHashMapII();
        myHashMapII.put(1, 2);
        myHashMapII.put(2, 2);
        myHashMapII.put(100002, 2);
        myHashMapII.put(2, 5);
        myHashMapII.put(100002, 3);
        System.out.println(myHashMapII.get(1));
        System.out.println(myHashMapII.get(3));
        myHashMapII.put(2, 1);
        System.out.println(myHashMapII.get(2));
        myHashMapII.remove(2);
        System.out.println(myHashMapII.get(2));
    }
}
