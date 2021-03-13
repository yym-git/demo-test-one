package com.person.cn.demotestone.data.construct.queue;

import java.util.Scanner;

/**
 * @author ym.y
 * @description 数组实现队列(非循环队列)
 * @package com.person.cn.demotestone.data.construct.queue
 * @updateUser
 * @date 11:202020/11/19
 */
public class ArrayQueueDemon {
    public static void main(String[] args) {
        QueueModel queueModel = new QueueModel(3);
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

class QueueModel {
    private int maxSize;
    private int head;
    private int tail;
    private int[] array;

    public QueueModel(int maxSize) {
        this.maxSize = maxSize;
        array = new int[maxSize];
        tail = -1;
        head = -1;
    }

    public boolean isFull() {
        return tail == maxSize - 1;
    }

    public boolean isEmpty() {
        return tail == head;
    }

    public void addQueue(int n) {
        if (isFull()) {
            System.out.println("队列已满~~~");
            return;
        }
        tail++;
        array[tail] = n;
    }

    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空，不能取数据");
        }
        return array[++head];
    }

    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列为空！");
        }
        for (int i = 0; i < array.length; i++) {
            System.out.printf("array[%d]=%d\n", i, array[i]);
        }

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
        return array[head + 1];
    }
}
