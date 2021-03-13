package com.person.cn.demotestone.designmodel.prototype;

import lombok.extern.slf4j.Slf4j;

/**
 * @author ym.y
 * @description
 * @package com.person.cn.demotestone.designmodel.prototype
 * @updateUser
 * @date 12:29 2020/12/12
 */
@Slf4j
public class Client {
    public static void main(String[] args) {
//        test1();
        test2();
    }

    public static void test1() {
        WeekLog weekLog_prev = new WeekLog();
        weekLog_prev.setName("张无忌");
        weekLog_prev.setDate("第五周");
        weekLog_prev.setContent("划水的一天");
        log.info("*****周报********");
        log.info("周次：" + weekLog_prev.getDate());
        log.info("姓名：" + weekLog_prev.getName());
        log.info("内容：" + weekLog_prev.getContent());
        log.info("-----------------------------------------------");
        //克隆对象
        WeekLog log_new = weekLog_prev.clone();
        log_new.setDate("第六周");
        log.info("*****周报********");
        log.info("周次：" + log_new.getDate());
        log.info("姓名：" + log_new.getName());
        log.info("内容：" + log_new.getContent());
        log.info("------------------------------------------------------");
        log.info("log_new==weekLog_prev:" + (log_new == weekLog_prev));
        log.info("log_new.getDate()==weekLog_prev.getDate():" + (log_new.getDate() == weekLog_prev.getDate()));
        log.info("log_new.geName()==weekLog_prev.getName():" + (log_new.getName() == weekLog_prev.getName()));
        log.info("log_new.getContent() == weekLog_prev.getContent():" + (log_new.getContent() == weekLog_prev.getContent()));

    }

    public static void test2() {
        WeekLog weekLog_prev = new WeekLog();
        weekLog_prev.setName("张无忌");
        weekLog_prev.setDate("第五周");
        weekLog_prev.setContent("划水的一天");
        Attachment attachment = new Attachment();
        attachment.setName("附件");
        weekLog_prev.setAttachment(attachment);
        log.info("*****周报********");
        log.info("周次：" + weekLog_prev.getDate());
        log.info("姓名：" + weekLog_prev.getName());
        log.info("内容：" + weekLog_prev.getContent());
        log.info("-----------------------------------------------");
        //克隆对象
        WeekLog log_new = weekLog_prev.clone();
        log_new.setDate("第六周");
        log.info("*****周报********");
        log.info("周次：" + log_new.getDate());
        log.info("姓名：" + log_new.getName());
        log.info("内容：" + log_new.getContent());
        log.info("------------------------------------------------------");
        log.info("log_new==weekLog_prev:" + (log_new == weekLog_prev));
        //浅克隆
        log.info("log_new.getAttachment()==weekLog_prev.getAttachment():" +
                (log_new.getAttachment() == weekLog_prev.getAttachment()));

    }

}
