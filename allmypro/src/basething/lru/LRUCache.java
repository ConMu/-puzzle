package basething.lru;

import java.util.*;
/*https://leetcode-cn.com/problems/lru-cache/*/
public class LRUCache  {
    class MapListNode{
        int k;
        int v;
        MapListNode pre;
        MapListNode next;
        MapListNode(){}
        MapListNode(int k, int v) {
            this.k = k;
            this.v = v;
        }
    }

    private int capacity;
    private int size;
    HashMap<Integer, MapListNode> cache = new HashMap<>();
    MapListNode head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        head = new MapListNode();
        tail = new MapListNode();
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        MapListNode node = cache.get(key);

        if (node == null) {
            return -1;
        } else {
            int res = node.v;
            moveToHead(node);
            return res;
        }
    }

    private void moveToHead(MapListNode node) {
        delete(node);
        addToHead(node);
    }

    private void addToHead(MapListNode node) {
        MapListNode oldNode = head.next;
        head.next = node;
        node.pre = head;
        node.next = oldNode;
        oldNode.pre = node;
    }

    private void delete(MapListNode node) {
        MapListNode pre = node.pre;
        pre.next = node.next;
        node.next.pre = pre;
    }

    public void put(int key, int value) {
        MapListNode node = cache.get(key);
        if (node == null) {
            MapListNode tmp = new MapListNode(key, value);
            cache.put(key, tmp);
            addToHead(tmp);
            size++;
            if (size > capacity) {
                MapListNode nodeA = removeTail();
                cache.remove(nodeA.k);
                size--;
            }
        } else {
            node.v = value;
            moveToHead(node);
        }
    }

    private MapListNode removeTail() {
        MapListNode pre = tail.pre;
        delete(pre);
        return pre;
    }


}
