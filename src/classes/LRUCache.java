package classes;

import java.util.HashMap;
import java.util.Map;

/**
 *description:
 * 146. LRU缓存机制
 * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
 * 获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
 * 写入数据 put(key, value) - 如果密钥已经存在，则变更其数据值；如果密钥不存在，则插入该组「密钥/数据值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 * 进阶:
 * 你是否可以在 O(1) 时间复杂度内完成这两种操作？
 * 示例:
 * LRUCache cache = new LRUCache( 2 /* 缓存容量 *
        *
        *cache.put(1,1);
        *cache.put(2,2);
        *cache.get(1);       // 返回  1
        *cache.put(3,3);    // 该操作会使得密钥 2 作废
        *cache.get(2);       // 返回 -1 (未找到)
        *cache.put(4,4);    // 该操作会使得密钥 1 作废
        *cache.get(1);       // 返回 -1 (未找到)
        *cache.get(3);       // 返回  3
        *cache.get(4);       // 返回  4
 *author:       alex
 *createDate:  2020/5/25 7:00
 *version:      1.0.0
 */
public class LRUCache {
    private int size = 0;
    private int capacity;
    private DLinkNode head = new DLinkNode();
    private DLinkNode tail = new DLinkNode();
    private Map<Integer, DLinkNode> map = new HashMap<>();
    public LRUCache(int setCapacity) {
        capacity = setCapacity;
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        DLinkNode node = map.get(key);
        if (node == null)
            return -1;
        moveToHead(node);
        return node.val;
    }

    public void put(int key, int value) {
        DLinkNode node = map.get(key);
        if (node != null) {
            node.val = value;
            moveToHead(node);
        } else {
            DLinkNode dLinkNode = new DLinkNode(key, value);
            map.put(key, dLinkNode);
            size++;
            addToHead(dLinkNode);
            if (size > capacity) {
                map.remove(tail.pre.key);
                removeNode(tail.pre);
                size--;
            }
        }
    }

    private void addToHead(DLinkNode dLinkNode) {
        dLinkNode.pre = head;
        dLinkNode.next = head.next;
        head.next.pre = dLinkNode;
        head.next = dLinkNode;
    }

    private void removeNode(DLinkNode dLinkNode) {
        dLinkNode.pre.next = dLinkNode.next;
        dLinkNode.next.pre = dLinkNode.pre;
    }

    private void moveToHead(DLinkNode dLinkNode) {
        removeNode(dLinkNode);
        addToHead(dLinkNode);
    }

    class DLinkNode {
        public DLinkNode() {}
        public DLinkNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
        private int key;
        private int val;
        private DLinkNode pre;
        private DLinkNode next;
    }
}
