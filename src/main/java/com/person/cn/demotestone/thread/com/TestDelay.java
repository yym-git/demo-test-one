package com.person.cn.demotestone.thread.com;

import java.util.Random;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @author ym.y
 * @description 测试延迟队列
 * @package com.person.cn.demotestone.thread
 * @updateUser
 * @date 16:102020/11/23
 */
public class TestDelay {
    static class DelayedEle implements Delayed{
        //延迟时间
        private  long  delayTime;
        //到期时间
        private long expire;
        //任务名
        private String taskName;

        public long getDelayTime() {
            return delayTime;
        }

        public void setDelayTime(long delayTime) {
            this.delayTime = delayTime;
        }

        public long getExpire() {
            return expire;
        }

        public void setExpire(long expire) {
            this.expire = expire;
        }

        public String getTaskName() {
            return taskName;
        }

        public void setTaskName(String taskName) {
            this.taskName = taskName;
        }

        /**
         * 获取剩余时间 = 到期时间 - 当前时间
         * @param unit
         * @return
         */
        @Override
        public long getDelay(TimeUnit unit) {
            return unit.convert(this.expire - System.currentTimeMillis(),TimeUnit.MILLISECONDS);
        }


        /**
         * 优先级处理
         * @param o
         * @return
         */
        @Override
        public int compareTo(Delayed o) {
            return (int)(this.getDelay(TimeUnit.MILLISECONDS) -  o.getDelay(TimeUnit.MILLISECONDS));
        }

        /**
         * 有参构造函数
         * @param delay
         * @param taskName
         */
        public DelayedEle(long delay,String taskName){
            delayTime = delay;
            this.taskName = taskName;
            // 到期时间 = 当前时间 + 延迟时间
            expire = System.currentTimeMillis()+delay;
        }

        @Override
        public String toString() {
            final StringBuffer sb  = new StringBuffer("DelayedEle{");
            sb.append("delay=").append(delayTime);
            sb.append(",expire=").append(expire);
            sb.append(",taskName='").append(taskName).append("\'");
            sb.append("}");
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        //创建延迟队列
        DelayQueue<DelayedEle> delayQueue  = new DelayQueue<>();
        Random random  = new Random();
        //创建延迟队列任务
        for(int i  = 0; i< 10; i++){
//            int a  = random.nextInt(500);
            DelayedEle element = new DelayedEle(i+1,"task:"+i);
            delayQueue.offer(element);
        }
        // 依次取出任务并打印
        DelayedEle  ele  = null;
        try{
            for(;;){
                while((ele = delayQueue.take())!=null){
                    System.out.println(ele);
                }
            }
        }catch (Exception e){}
    }
}
