package com.person.cn.demotestone.data.construct.lru;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ym.y
 * @description  map + 双向链表实现LRU最近最少使用算法
 * @package com.person.cn.demotestone.data.construct.lru
 * @updateUser
 * @date 16:14 2021/3/4
 */
public class LRUCacheDemo2 {
    /**
     * @author ym.y
     * @description 双向链表节点
     * @updateUser
     * @date 16:15 2021/3/4
     */
    class Node<K, V> {
        K key;
        V value;
        Node<K, V> prev;
        Node<K, V> next;

        public Node() {
            this.prev = this.next = null;
        }

        public Node(K k, V v) {
            this.key = k;
            this.value = v;
            this.prev = this.next = null;
        }
    }

    /**
     * @author ym.y
     * @description 构建一个双向链表节点
     * @updateUser
     * @date 16:19 2021/3/4
     */
    class DoubleLinkedList<K, V> {
        Node<K, V> head;
        Node<K, V> tail;

        /**
         * @description 双向链表构造方法
         * @author ym.y
         * @updateUser
         * @date 16:23 2021/3/4
         */
        public DoubleLinkedList() {
            head = new Node<>();
            tail = new Node<>();
            head.next = tail;
            tail.prev = head;
        }

        /**
         * @description 添加节点
         * @author ym.y
         * @updateUser
         * @date 16:36 2021/3/4
         */
        public void addHead(Node<K, V> node) {
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
        }

        /**
         * @description 删除节点
         * @author ym.y
         * @updateUser
         * @date 16:37 2021/3/4
         */
        public void removeNode(Node<K, V> node) {
            node.next.prev = node.prev;
            node.prev.next = node.next;
            node.prev = null;
            node.next = null;
        }

        /**
         * @description 删除最后一个节点
         * @author ym.y
         * @updateUser
         * @date 16:41 2021/3/4
         */
        public Node getLastNode() {
            return tail.prev;
        }
    }

    private int cacheSize;
    Map<Integer, Node<Integer, Integer>> map;
    DoubleLinkedList<Integer, Integer> doubleLinkedList;

    public LRUCacheDemo2(int cacheSize) {
        this.cacheSize = cacheSize;
        map = new HashMap<>();
        doubleLinkedList = new DoubleLinkedList<>();
    }


    /**
     * @description 取数据
     * @author ym.y
     * @updateUser
     * @date 16:56 2021/3/4
     */
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node<Integer, Integer> node = map.get(key);
        //将使用过的节点先从链表中删除
        doubleLinkedList.removeNode(node);
        //然后添加到队列头部
        doubleLinkedList.addHead(node);
        return node.value;
    }

    /**
     * @description 写数据 尾插法
     * @author ym.y
     * @updateUser
     * @date 16:56 2021/3/4
     */
    public void put(int key, int value) {
        //添加时，如果可以存在，则更新key，同时将节点放入到头部
        if (map.containsKey(key)) {
            Node<Integer, Integer> node = map.get(key);
            node.value = value;
            map.put(key, node);
            doubleLinkedList.removeNode(node);
            doubleLinkedList.addHead(node);
        } else {
            //超出map的大小
            if (map.size() == cacheSize) {
                Node<Integer, Integer> lastNode = doubleLinkedList.getLastNode();
                map.remove(lastNode.key);
                doubleLinkedList.removeNode(lastNode);
            }
            //新增
            Node<Integer, Integer> newNode = new Node<>(key, value);
            map.put(key, newNode);
            doubleLinkedList.addHead(newNode);

        }
    }

    public static void main(String[] args) {
        LRUCacheDemo2 demo2 = new LRUCacheDemo2(3);
        demo2.put(1,1);
        demo2.put(2,2);
        demo2.put(3,3);
        System.out.println(demo2.map.keySet());
        demo2.put(4,4);
        System.out.println(demo2.map.keySet());
        demo2.put(4,4);
        System.out.println(demo2.map.keySet());


    }
}

