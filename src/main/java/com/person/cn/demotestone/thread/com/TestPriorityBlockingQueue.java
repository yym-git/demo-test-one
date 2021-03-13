package com.person.cn.demotestone.thread.com;

import java.util.PriorityQueue;
import java.util.Random;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.thread
 * @updateUser
 * @date 15:302020/11/23
 */
public class TestPriorityBlockingQueue {
    static class  Task implements Comparable<Task>{
        private  int priority = 0;
        private String taskName;

        public int getPriority() {
            return priority;
        }

        public void setPriority(int priority) {
            this.priority = priority;
        }

        public String getTaskName() {
            return taskName;
        }

        public void setTaskName(String taskName) {
            this.taskName = taskName;
        }

        @Override
        public int compareTo(Task o) {
            if(this.priority > o.priority){
                return 1;
            }else {
                return -1;
            }
        }
        public void doSomeThing(){
            System.out.println(taskName+":"+taskName);
        }
    }

    public static void main(String[] args) {
        PriorityBlockingQueue<Task> priorityBlockingQueue = new PriorityBlockingQueue<>();
        Random random = new Random();
        for(int i = 0 ; i< 10; i++){
            Task task = new Task();
            task.setPriority(random.nextInt(10));
            task.setTaskName("taskName_"+i);
            priorityBlockingQueue.offer(task);
        }

        while(!priorityBlockingQueue.isEmpty()){
           Task task  =  priorityBlockingQueue.poll();
           if(task != null ){
               task.doSomeThing();
           }
        }
    }
}
