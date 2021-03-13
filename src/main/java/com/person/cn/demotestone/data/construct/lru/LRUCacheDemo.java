package com.person.cn.demotestone.data.construct.lru;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ym.y
 * @description 分析：为了实现查询和增删的时间复杂度为O(1)
 * @package com.person.cn.demotestone.data.construct.lru
 * @updateUser
 * @date 17:38 2021/3/4
 */
public class LRUCacheDemo {
    private int capacity;
    Map<Integer, Node<Integer, Integer>> map;
    private DoubleLinked<Integer, Integer> doubleLinked;

    public LRUCacheDemo(int capacity) {
        this.capacity = capacity;
        doubleLinked = new DoubleLinked<>();
        map = new HashMap<>();
    }

    //1、节点类
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

    //2、创建双向链表类
    class DoubleLinked<K, V> {
        Node<K, V> head;
        Node<K, V> tail;

        public DoubleLinked() {
            head = new Node();
            tail = new Node();
            this.head.next = tail;
            this.tail.prev = head;
        }

        public void addHead(Node<K, V> node) {
            node.next = head.next;
            node.prev = head;
            head.next = node;
            node.next.prev= node;

        }

        public void removeNode(Node<K, V> node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            node.next = null;
            node.prev = null;
        }

        public Node<K, V> getLastNode() {
            return tail.prev;
        }
    }

    //3、添加元素
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node<Integer, Integer> node = map.get(key);
            node.value = value;
            map.put(key, node);
            //从双向链表删除元素
            doubleLinked.removeNode(node);
            //添加元素
            doubleLinked.addHead(node);
        } else {
            //不包含
            if (map.size() == capacity) {
                //获取队列尾部元素
                Node<Integer, Integer> lastNode = doubleLinked.getLastNode();
                doubleLinked.removeNode(lastNode);
                map.remove(lastNode.key);
            }
            //新增
            Node<Integer, Integer> newNode = new Node<>(key, value);
            doubleLinked.addHead(newNode);
            map.put(key, newNode);

        }
    }

    public static void main(String[] args) {
        LRUCacheDemo demo = new LRUCacheDemo(3);
        demo.put(1, 1);
        demo.put(2, 2);
        demo.put(3, 3);
        System.out.println(demo.map.keySet());
        demo.put(4, 4);
        System.out.println(demo.map.keySet());
        demo.put(5, 5);
    }
}
