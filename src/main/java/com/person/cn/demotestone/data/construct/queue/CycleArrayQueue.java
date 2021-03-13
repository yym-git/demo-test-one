package com.person.cn.demotestone.data.construct.queue;

import java.util.Scanner;

/**
 * @author ym.y
 * @description 数组实现循环队列
 * @package com.person.cn.demotestone.data.construct.queue
 * @updateUser
 * @date 15:342020/11/19
 */
public class CycleArrayQueue {
    public static void main(String[] args) {
        // 设置最大为4，实则有效个数为3
        CycleQueue queueModel = new CycleQueue(4);
        // 接收用户输入
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop) {
            System.out.println("s(show)：显示队列");
            System.out.println("e(exit)：退出程序");
            System.out.println("a(add)：添加数据到队列");
            System.out.println("g(get)：从队列取数据");
            System.out.println("h(head)：查看队列头元素");
            key = scanner.next().charAt(0);
            switch (key) {
                case 's':
                    queueModel.showQueue();
                    break;
                case 'a':
                    System.out.println("输入一个数");
                    int value = scanner.nextInt();
                    queueModel.addQueue(value);
                    break;
                case 'g':
                    try {
                        int tail = queueModel.getQueue();
                        System.out.println("取出数据："+tail);
                    } catch (Exception e) {
                        System.out.println("队列为空");
                    }
                    break;
                case 'h':
                    try {
                        int head = queueModel.headData();
                        System.out.println("队列头数据："+head);
                    } catch (Exception e) {
                        System.out.println("获取队列头数据异常：" + e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序退出~~~~");
    }

}

class CycleQueue {
    private int maxSize;
    // 默认为0
    private int head;
    // 默认为0
    private int tail;
    private int[] array;

    public CycleQueue(int maxSize) {
        this.maxSize = maxSize;
        array = new int[maxSize];
    }

    public boolean isFull() {
        return (tail + 1) % maxSize == head;
    }

    public boolean isEmpty() {
        return tail == head;
    }

    public void addQueue(int n) {
        if (isFull()) {
            System.out.println("队列已满~~~");
            return;
        }
        array[tail] = n;
        tail = (tail + 1) % maxSize;
    }

    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空，不能取数据");
        }
        int value = array[head];
        head = (head + 1) % maxSize;
        return value;
    }

    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列为空！");
        }
        for (int i = head; i < head+queueSize(); i++) {
            System.out.printf("array[%d]=%d\n", i%maxSize, array[i%maxSize]);
        }

    }

    /**
     * 返回循环队列的有效个数
     *
     * @return
     */
    public int queueSize() {
        return (tail + maxSize - head) % maxSize;
    }

    /**
     * 显示队列头数据
     *
     * @return
     */
    public int headData() {
        if (isEmpty()) {
            throw new RuntimeException("队列空的没有数据！");
        }
        return array[head];
    }
}
