package com.person.cn.demotestone.iocom.nio.watchservice;

import java.nio.file.*;

/**
 * @author ym.y
 * @description WatchService实现文件系统的监听
 * @package com.person.cn.demotestone.iocom.nio
 * @updateUser
 * @date 11:372020/12/9
 */
public  class WatchServiceTest {
    public static void main(String[] args) throws  Exception {
        //获取文件系统

        WatchService watchService = FileSystems.getDefault().newWatchService();
        //添加监听器以及监听事件
        Paths.get("D:/").register(watchService,
                StandardWatchEventKinds.ENTRY_CREATE,
                StandardWatchEventKinds.ENTRY_DELETE,
                StandardWatchEventKinds.ENTRY_MODIFY
        );
        while (true) {
            //获取一个文件变化事件
            WatchKey watchKey = watchService.take();
            for (WatchEvent<?> event : watchKey.pollEvents()) {
                System.out.println(event.context() + " 文件发生了" + event.kind() + " 事件");
            }
            //重置失败跳出循环
            if( !watchKey.reset()){
                break;
            }
        }
    }
}
